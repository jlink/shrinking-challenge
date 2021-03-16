# Report for fast-check Shrinking on "large union list"

This report was generated with fast-check 2.14.0

## Normalization

fast-check produced 52 distinct results in 100 test runs.

The most common were:

* ``[[0,-1,-2,-3,1]]`` (7.00%)
* ``[[0,1,-1,2,-2]]`` (6.00%)
* ``[[0,1,-1,-2,-3]]`` (5.00%)
* ``[[0,1,2,3,4]]`` (5.00%)
* ``[[0,-1,1,2,-2]]`` (5.00%)
* ``[[0,1,2,3,-1]]`` (4.00%)
* ``[[0,-1,-2,1,2]]`` (4.00%)
* ``[[0,-1,-2,-3,-4]]`` (4.00%)
* ``[[0,-1,1,-2,2]]`` (3.00%)
* ``[[0,1,2,-1,3]]`` (3.00%)

## Performance

Over 100 runs, fast-check performed between 392 and 1452 evaluations during shrinking,
with a mean cost of 1162.49 (95% confidence interval 1115.88 - 1212.58).
