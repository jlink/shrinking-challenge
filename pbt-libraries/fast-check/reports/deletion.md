# Report for fast-check Shrinking on "deletion"

This report was generated with fast-check 2.12.0

## Normalization

fast-check produced 14 distinct results in 41 test runs.

The most common were:

* ``i=0``, ``ls=[0,0]`` (65.85%)
* ``i=0``, ``ls=[14,14]`` (4.88%)
* ``i=0``, ``ls=[19,19]`` (2.44%)
* ``i=0``, ``ls=[30,30]`` (2.44%)
* ``i=0``, ``ls=[4,4]`` (2.44%)
* ``i=0``, ``ls=[-18,-18]`` (2.44%)
* ``i=0``, ``ls=[-2147483625,-2147483625]`` (2.44%)
* ``i=0``, ``ls=[-2147483636,-2147483636]`` (2.44%)
* ``i=0``, ``ls=[21,21]`` (2.44%)
* ``i=0``, ``ls=[-26,-26]`` (2.44%)

## Performance

Over 41 runs, fast-check performed between 13 and 437 evaluations during shrinking,
with a mean cost of 92.18 (95% confidence interval 63.49 - 116.66).
