# Report for fast-check Shrinking on "distinct"

This report was generated with fast-check 2.12.0

## Normalization

fast-check produced 6 distinct results in 100 test runs.

These were:

* ``[0,-1,1]`` (32.00%)
* ``[0,1,-1]`` (27.00%)
* ``[0,1,2]`` (25.00%)
* ``[0,-1,-2]`` (13.00%)
* ``[1,-1,0]`` (2.00%)
* ``[1,0,-1]`` (1.00%)

## Performance

Over 100 runs, fast-check performed between 38 and 324 evaluations during shrinking,
with a mean cost of 266.71 (95% confidence interval 251.58 - 283.26).
