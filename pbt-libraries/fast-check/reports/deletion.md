# Report for fast-check Shrinking on "deletion"

This report was generated with fast-check 2.12.0

## Normalization

fast-check produced 13 distinct results in 55 test runs.

The most common were:

* ``i=0``, ``ls=[0,0]`` (76.36%)
* ``i=0``, ``ls=[-16,-16]`` (3.64%)
* ``i=0``, ``ls=[8,8]`` (1.82%)
* ``i=0``, ``ls=[21,21]`` (1.82%)
* ``i=0``, ``ls=[2147483624,2147483624]`` (1.82%)
* ``i=0``, ``ls=[27,27]`` (1.82%)
* ``i=0``, ``ls=[-25,-25]`` (1.82%)
* ``i=0``, ``ls=[2147483647,2147483647]`` (1.82%)
* ``i=0``, ``ls=[9,9]`` (1.82%)
* ``i=0``, ``ls=[-31,-31]`` (1.82%)

## Performance

Over 55 runs, fast-check performed between 19 and 304 evaluations during shrinking,
with a mean cost of 81.62 (95% confidence interval 63.11 - 98.73).
