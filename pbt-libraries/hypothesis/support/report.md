# Report for Hypothesis Shrinking on "${benchmark.replace('_', ' ')}"

This report was generated with Hypothesis ${version}

${"##"} Normalization

% if len(examples) == 1:
Hypothesis currently normalises this example to ${examples[0][0]}
% else:
Hypothesis produced ${len(examples)} distinct results in ${n_runs} test runs.
% if len(examples) > 0.9 * n_runs:

A few examples of these were:

% for eg, percent in examples[:5]:
* ${eg}
% endfor
% else:

% if len(examples) > 10:
The most common were:
% else:
These were:
% endif

% for eg, percent in examples[:10]:
* ${eg} (${percent})
% endfor
% endif
% endif

${"##"} Performance

Over ${n_runs} runs, Hypothesis performed between ${min_cost} and ${max_cost} evaluations during shrinking,
with a mean cost of ${mean_est} (95% confidence interval ${mean_lower} - ${mean_upper}).
