# Report for fast-check Shrinking on "nestedlists"

This report was generated with fast-check 2.12.0

## Normalization

fast-check produced 47 distinct results in 100 test runs.

The most common were:

* ``[[0],[0,0,0,0,0,0,0,0,0,0]]`` (13.00%)
* ``[[0,0],[0,0,0,0,0,0,0,0,0]]`` (10.00%)
* ``[[0,0,0],[0,0,0,0,0,0,0,0]]`` (9.00%)
* ``[[0,0,0,0,0,0,0,0],[0,0,0]]`` (6.00%)
* ``[[0,0,0,0,0,0,0],[0,0,0,0]]`` (5.00%)
* ``[[0],[0,0],[0,0,0,0,0,0,0,0]]`` (3.00%)
* ``[[0,0,0,0,0,0],[0,0,0,0,0]]`` (3.00%)
* ``[[0,0,0,0,0],[0,0,0,0,0,0]]`` (3.00%)
* ``[[0,0,0],[0],[0,0,0,0,0,0,0]]`` (2.00%)
* ``[[0,0,0,0],[0,0,0,0,0,0,0]]`` (2.00%)

## Performance

Over 100 runs, fast-check performed between 29 and 76 evaluations during shrinking,
with a mean cost of 38.04 (95% confidence interval 36.13 - 39.78).
