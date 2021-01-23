# Report for fast-check Shrinking on "distinct"

This report was generated with fast-check 2.12.0

## Normalization

fast-check produced 5 distinct results in 100 test runs.

These were:

* ``[0,1,-1]`` (29.00%)
* ``[0,-1,1]`` (25.00%)
* ``[0,1,2]`` (22.00%)
* ``[0,-1,-2]`` (22.00%)
* ``[0,-2,-1]`` (2.00%)

## Performance

Over 100 runs, fast-check performed between 38 and 324 evaluations during shrinking,
with a mean cost of 273.24 (95% confidence interval 259.68 - 287.90).
