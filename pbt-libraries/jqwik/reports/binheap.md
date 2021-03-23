# Report for Hypothesis Shrinking on "binheap"

This report was generated with jqwik 1.5.0

## Normalization

jqwik produced 85 distinct results in 100 test runs.

The most common were:

* ``(0, None, (0, (0, None, None), (1, None, None)))`` (8.00%)
* ``(0, (0, (0, None, None), (1, None, None)), None)`` (7.00%)
* ``(0, (0, None, (0, (0, None, None), (1, None, None))), None)`` (2.00%)
* ``(0, (0, (1, None, None), None), (0, None, None))`` (2.00%)
* ``(18045, (18068, None, (470131, None, None)), (18594, (470657, None, None), None))`` (1.00%)
* ``(0, None, (0, (0, (0, None, None), (1, None, None)), None))`` (1.00%)
* ``(1159739312, None, (1160646016, (1160646194, None, None), (1161281628, None, None)))`` (1.00%)
* ``(221, None, (108551, (108601, None, (108623, None, (109146, None, (112328, (112328, None, None), (224620, None, None))))), None))`` (1.00%)

## Performance

Over 100 runs, Hypothesis performed between 28 and 6103 evaluations during shrinking,
with a mean cost of 483.95 (95% confidence interval 314.22 - 617.49).
