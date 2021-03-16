# Report for fast-check Shrinking on "distinct"

This report was generated with fast-check 2.14.0

## Normalization

fast-check produced 6 distinct results in 100 test runs.

These were:

* ``[0,1,-1]`` (34.00%)
* ``[0,-1,1]`` (26.00%)
* ``[0,-1,-2]`` (22.00%)
* ``[0,1,2]`` (16.00%)
* ``[0,2,1]`` (1.00%)
* ``[0,-2,-1]`` (1.00%)

## Performance

Over 100 runs, fast-check performed between 55 and 324 evaluations during shrinking,
with a mean cost of 275.19 (95% confidence interval 262.75 - 288.62).
