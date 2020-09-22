# Report for jqwik Shrinking on "calculator"

This report was generated with jqwik 1.3.6

## Normalization

jqwik produced 3 distinct results in 100 test runs.

These were:

* ``(/, 0, (/, 0, 1))`` (98.00%)
* ``(/, 0, (/, (+, 0, 0), 1))`` (1.00%)
* ``(/, 0, (/, (+, (+, 0, 0), 0), 1))`` (1.00%)

## Performance

Over 100 runs, jqwik performed between 12 and 343 evaluations during shrinking,
with a mean cost of 56.68 (95% confidence interval 45.63 - 66.40).
