# Report for jqwik Shrinking on "large union list"

This report was generated with jqwik 1.3.6

## Normalization

jqwik produced 3 distinct results in 100 test runs.

These were:

* ``[[0, 1, -1, 2, -2]]`` (48.00%)
* ``[[0, 1, -1, 2, 3]]`` (44.00%)
* ``[[0, 1, 2, 3, 4]]`` (8.00%)

## Performance

Over 100 runs, jqwik performed between 55 and 137 evaluations during shrinking,
with a mean cost of 80.54 (95% confidence interval 77.24 - 83.65).
