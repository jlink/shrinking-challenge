import json
import os
import sys
from collections import Counter

import attr
import numpy as np
from mako.lookup import TemplateLookup

import hypothesis

CACHE_DIR = os.path.abspath(os.path.join(os.path.dirname(__file__), "..", ".cache"))


TEMPLATE_LOOKUP = TemplateLookup(
    directories=os.path.abspath(os.path.dirname(__file__)),
    module_directory=os.path.join(CACHE_DIR, "mako_modules"),
)


@attr.s()
class Stat(object):
    estimate = attr.ib()
    lower_confidence = attr.ib()
    upper_confidence = attr.ib()


N_BOOTSTRAPS = 10000


def mean_bootstrap(values):
    np.random.seed(0)
    empirical = np.mean(values)
    bootstraps = np.random.choice(values, size=(len(values), N_BOOTSTRAPS)).mean(0)

    # This is a pivot bootstrap method and I'd be lying if I said I fully
    # understood it. The idea is as follows though: We have some function F
    # of the true distribution. We expect the empirical distribution to be very
    # close to the true distribution. BUT just taking the value of F on the
    # empirical distribution may be a biased estimator. So we use the bootstrap
    # to figure out how biased it is, and use that to correct. A similar effect
    # applies to our confidence intervals.
    base = 2 * empirical
    return Stat(
        estimate=base - np.mean(bootstraps),
        lower_confidence=base - np.percentile(bootstraps, 97.5),
        upper_confidence=base - np.percentile(bootstraps, 2.5),
    )


def main(filename):
    name = os.path.splitext(os.path.basename(filename))[0]

    target = os.path.splitext(filename)[0] + ".md"
    report_template = TEMPLATE_LOOKUP.get_template("report.md")

    with open(filename) as i:
        data = json.loads(i.read())

    examples = Counter()

    for record in data:
        shrunk = record["shrunk"]
        if len(shrunk) == 1:
            shrunk = tuple(shrunk.values())
        else:
            shrunk = tuple(sorted(shrunk.items()))
        examples[shrunk] += 1

    examples = [
        (
            ", ".join(
                "``" + ("=".join(s) if isinstance(s, tuple) else s) + "``" for s in k
            ),
            "%.2f%%" % (v / len(data) * 100,),
        )
        for k, v in examples.most_common(len(examples))
    ]

    evaluations = np.array([rec["evaluations"] for rec in data])

    mean = mean_bootstrap(evaluations)

    with open(target, "w") as o:
        o.write(
            report_template.render(
                version=hypothesis.__version__,
                benchmark=name,
                examples=examples,
                n_runs=len(data),
                max_cost=evaluations.max(),
                min_cost=evaluations.min(),
                mean_est="%.2f" % (mean.estimate,),
                mean_lower="%.2f" % (mean.lower_confidence,),
                mean_upper="%.2f" % (mean.upper_confidence,),
            )
        )


if __name__ == "__main__":
    main(sys.argv[1])
