# Report for jqwik Shrinking on "binheap"

This report was generated with jqwik 1.3.6

## Normalization

jqwik produced 92 distinct results in 100 test runs.

A few examples of these were:

* ``(0, (0, (0, None, None), (1, None, None)), None)``
* ``(0, None, (0, (0, None, None), (1, None, None)))``
* ``(0, None, (0, None, (0, (0, None, None), (1, None, None))))``
* ``(1610, None, (71532, (71532, None, None), (71533, None, None)))``
* ``(39, None, (39, (39, None, None), (40, None, None)))``

## Performance

Over 100 runs, jqwik performed between 98 and 14373 evaluations during shrinking,
with a mean cost of 1238.22 (95% confidence interval 824.45 - 1579.69).
