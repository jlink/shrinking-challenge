# Report for jqwik Shrinking on "binheap"

This report was generated with jqwik 1.3.4

## Normalization

jqwik produced 89 distinct results in 100 test runs.

The most common were:

* ``(0, None, (0, (0, None, None), (1, None, None)))`` (6.00%)
* ``(0, (0, (0, None, None), (1, None, None)), None)`` (5.00%)
* ``(0, None, (0, None, (0, (0, None, None), (1, None, None))))`` (2.00%)
* ``(0, None, (0, (0, (0, None, None), (1, None, None)), None))`` (2.00%)
* ``(836882, None, (2395528, (2395528, None, None), (2395529, None, None)))`` (1.00%)
* ``(5788370, (7622738, None, None), (7587092, (7622739, None, None), None))`` (1.00%)
* ``(899, None, (2026, (2026, None, None), (2027, None, None)))`` (1.00%)
* ``(4005795, None, (4005795, (4005795, None, None), (4005796, None, None)))`` (1.00%)
* ``(585740, None, (585740, (585740, None, None), (585741, None, None)))`` (1.00%)
* ``(3149, None, (13482, (15273, (15273, None, None), (15274, None, None)), None))`` (1.00%)

## Performance

Over 100 runs, jqwik performed between 72 and 9724 evaluations during shrinking,
with a mean cost of 1006.47 (95% confidence interval 693.62 - 1275.64).
