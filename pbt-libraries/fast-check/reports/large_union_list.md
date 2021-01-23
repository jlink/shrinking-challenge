# Report for fast-check Shrinking on "large union list"

This report was generated with fast-check 2.12.0

## Normalization

fast-check produced 53 distinct results in 100 test runs.

The most common were:

* ``[[0,-1,-2,-3,-4]]`` (6.00%)
* ``[[0,1,2,-1,3]]`` (6.00%)
* ``[[0,-1,1,-2,-3]]`` (5.00%)
* ``[[0,-1,1,2,-2]]`` (5.00%)
* ``[[0,-1,-2,1,2]]`` (5.00%)
* ``[[0,1,-1,-2,2]]`` (5.00%)
* ``[[0,-1,1,2,3]]`` (4.00%)
* ``[[0,1,-1,2,-2]]`` (4.00%)
* ``[[0,1,2,3,4]]`` (4.00%)
* ``[[0,-1,-2,-3,1]]`` (3.00%)

## Performance

Over 100 runs, fast-check performed between 574 and 1423 evaluations during shrinking,
with a mean cost of 1215.76 (95% confidence interval 1180.01 - 1253.67).
