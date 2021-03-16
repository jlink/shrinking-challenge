# Report for fast-check Shrinking on "deletion"

This report was generated with fast-check 2.14.0

## Normalization

fast-check produced 19 distinct results in 54 test runs.

The most common were:

* ``i=0``, ``ls=[0,0]`` (66.67%)
* ``i=0``, ``ls=[2147483619,2147483619]`` (1.85%)
* ``i=0``, ``ls=[-1,-1]`` (1.85%)
* ``i=0``, ``ls=[4,4]`` (1.85%)
* ``i=0``, ``ls=[1,1]`` (1.85%)
* ``i=0``, ``ls=[-27,-27]`` (1.85%)
* ``i=0``, ``ls=[-10,-10]`` (1.85%)
* ``i=0``, ``ls=[-2147483627,-2147483627]`` (1.85%)
* ``i=0``, ``ls=[15,15]`` (1.85%)
* ``i=0``, ``ls=[-17,-17]`` (1.85%)

## Performance

Over 54 runs, fast-check performed between 13 and 224 evaluations during shrinking,
with a mean cost of 68.73 (95% confidence interval 52.57 - 83.46).
