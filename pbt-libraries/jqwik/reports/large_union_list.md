# Report for jqwik Shrinking on "large union list"

This report was generated with jqwik 1.3.4

## Normalization

jqwik produced 3 distinct results in 100 test runs.

These were:

* ``[[0, 1, -1, 2, 3]]`` (53.00%)
* ``[[0, 1, -1, 2, -2]]`` (39.00%)
* ``[[0, 1, 2, 3, 4]]`` (8.00%)

## Performance

Over 100 runs, jqwik performed between 52 and 187 evaluations during shrinking,
with a mean cost of 79.52 (95% confidence interval 76.07 - 82.50).
