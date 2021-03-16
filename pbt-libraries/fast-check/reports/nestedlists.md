# Report for fast-check Shrinking on "nestedlists"

This report was generated with fast-check 2.14.0

## Normalization

fast-check produced 36 distinct results in 100 test runs.

The most common were:

* ``[[0,0],[0,0,0,0,0,0,0,0,0]]`` (13.00%)
* ``[[0],[0,0,0,0,0,0,0,0,0,0]]`` (11.00%)
* ``[[0,0,0],[0,0,0,0,0,0,0,0]]`` (9.00%)
* ``[[0,0,0,0],[0,0,0,0,0,0,0]]`` (8.00%)
* ``[[0,0,0,0,0],[0,0,0,0,0,0]]`` (8.00%)
* ``[[0,0,0,0,0,0],[0,0,0,0,0]]`` (6.00%)
* ``[[0,0,0,0,0,0,0,0],[0,0,0]]`` (5.00%)
* ``[[0,0,0,0],[0,0,0,0,0,0],[0]]`` (4.00%)
* ``[[0,0,0,0,0,0,0],[0,0,0,0]]`` (4.00%)
* ``[[0,0,0,0,0],[0,0,0],[0,0,0]]`` (3.00%)

## Performance

Over 100 runs, fast-check performed between 27 and 77 evaluations during shrinking,
with a mean cost of 37.52 (95% confidence interval 35.46 - 39.40).
