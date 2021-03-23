# Report for Hypothesis Shrinking on "binheap"

This report was generated with jqwik 1.5.0

## Normalization

jqwik produced 99 distinct results in 100 test runs.

A few examples of these were:

* ``(0, None, (0, (426, None, (0, None, None)), None))``
* ``(0, (0, None, (0, None, (0, (0, None, (0, None, None)), (0, (1, None, None), None)))), None)``
* ``(620, (483, None, (331, None, (7072, (1166, (0, (0, None, None), (0, None, (0, None, (0, (0, (0, None, None), None), (0, None, None))))), (301, (0, None, (599601, None, (0, (119, (0, None, None), None), (19, None, None)))), (111002, (599601, None, (67, (119, (161426, None, None), None), (19, None, None))), (326, (67, (119, (161426, None, None), None), (19, None, None)), None)))), (206927, (301, (20, None, (599601, None, (67, (119, (161426, None, None), None), (19, None, None)))), (111002, (599601, None, (67, (119, (161426, None, None), None), (19, None, None))), (326, (67, (119, (161426, None, None), None), (19, None, None)), None))), (6667, (111002, (599601, None, (67, (119, (161426, None, None), None), (19, None, None))), (326, (67, (119, (161426, None, None), None), (19, None, None)), None)), (888742, (326, (67, (119, (161426, None, None), None), (19, None, None)), None), None)))))), None)``

## Performance

Over 100 runs, Hypothesis performed between 1 and 1078 evaluations during shrinking,
with a mean cost of 251.26 (95% confidence interval 199.69 - 299.14).
