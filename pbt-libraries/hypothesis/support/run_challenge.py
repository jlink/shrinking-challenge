import hashlib
import json
import os
import sys
from random import Random

from tqdm import trange

from hypothesis import HealthCheck, Phase, Verbosity
from hypothesis import seed as with_seed
from hypothesis import settings
from hypothesis.internal.reflection import proxies


def main(filename):
    target = os.path.splitext(filename)[0] + ".json"

    random = Random(
        int.from_bytes(
            hashlib.sha1(os.path.basename(filename).encode("utf-8")).digest(), "big"
        )
    )

    results = []

    with open(filename, "r") as i:
        source = i.read()

    compiled = compile(source, filename, "exec")

    for _ in trange(100):
        seed = random.getrandbits(64)

        namespace = {}

        exec(compiled, namespace)

        test = namespace["test"]

        assert getattr(test, "is_hypothesis_test", False)

        base_function = test.hypothesis.inner_test

        stats = {
            "seed": seed,
            "evaluations": 0,
        }

        def record(kwargs, interesting):
            if interesting:
                kwargs = {name: repr(value) for name, value in kwargs.items()}

                if "original" not in stats:
                    stats["original"] = kwargs
                stats["shrunk"] = kwargs
            if "original" in stats:
                stats["evaluations"] += 1

        @proxies(base_function)
        def replacement_function(**kwargs):
            try:
                base_function(**kwargs)
                record(kwargs, False)
            except Exception:
                record(kwargs, True)
                raise

        test.hypothesis.inner_test = replacement_function

        test = with_seed(seed)(
            settings(
                database=None,
                suppress_health_check=HealthCheck.all(),
                max_examples=10 ** 6,
                phases=[Phase.generate, Phase.shrink],
                verbosity=Verbosity.quiet,
            )(test)
        )

        try:
            test()
        except Exception:
            if "original" not in stats:
                raise

        results.append(stats)
    with open(target, "w") as o:
        o.write(json.dumps(results, sort_keys=True, indent=4,))


if __name__ == "__main__":
    main(sys.argv[1])
