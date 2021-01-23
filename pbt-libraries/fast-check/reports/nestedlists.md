# Report for fast-check Shrinking on "nestedlists"

This report was generated with fast-check 

## Normalization

fast-check produced 47 distinct results in 100 test runs.

The most common were:

* ``[[0],[0,0,0,0,0,0,0,0,0,0]]`` (10.00%)
* ``[[0,0,0,0,0,0],[0,0,0,0,0]]`` (7.00%)
* ``[[0,0],[0,0,0,0,0,0,0,0,0]]`` (7.00%)
* ``[[0,0,0,0,0],[0,0,0,0,0,0]]`` (6.00%)
* ``[[0,0,0,0,0,0,0,0],[0,0,0]]`` (6.00%)
* ``[[0,0,0,0,0,0,0,0,0],[0,0]]`` (4.00%)
* ``[[0,0,0],[0,0,0,0,0,0,0,0]]`` (4.00%)
* ``[[0,0,0,0,0,0,0],[0,0,0,0]]`` (3.00%)
* ``[[0,0,0,0,0,0,0,0,0,0],[0]]`` (3.00%)
* ``[[0,0,0,0,0],[0,0,0],[0,0,0]]`` (3.00%)

## Performance

Over 100 runs, fast-check performed between 26 and 81 evaluations during shrinking,
with a mean cost of 40.17 (95% confidence interval 37.63 - 42.51).
