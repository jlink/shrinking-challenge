# Report for fast-check Shrinking on "calculator"

This report was generated with fast-check 2.14.0

## Normalization

fast-check produced 53 distinct results in 100 test runs.

The most common were:

* ``["/",0,["/",0,-1]]`` (17.00%)
* ``["/",0,["/",0,1]]`` (9.00%)
* ``["/",["/",0,["/",0,1]],1]`` (4.00%)
* ``["/",0,["+",0,["/",0,-1]]]`` (4.00%)
* ``["/",0,["/",["/",0,1],1]]`` (3.00%)
* ``["+",["/",0,["/",0,-1]],0]`` (3.00%)
* ``["/",0,["/",["/",0,1],-1]]`` (3.00%)
* ``["/",0,["/",["/",0,-1],1]]`` (3.00%)
* ``["/",["/",0,["/",0,1]],-1]`` (3.00%)
* ``["+",["/",0,["/",0,1]],0]`` (2.00%)

## Performance

Over 100 runs, fast-check performed between 6 and 334 evaluations during shrinking,
with a mean cost of 66.44 (95% confidence interval 56.55 - 75.53).
