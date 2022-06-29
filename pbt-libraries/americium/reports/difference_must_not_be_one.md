# Report for Americium Shrinking on "difference must not be one"

This report was generated with Americium 1.5.1

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[10, 9]`` - casesLimit = 2000


## Performance

6896 cases were run.

1959 successful runs were performed out of a limit of 2000 successful cases, prior to the first failing case.

1 + 3 = 4 runs then failed out of a subsequent shrinkage sequence of 6896 - 1959 = 4937 runs, including the first failing case.

The best shrunk case was followed by 6896 - 2739 = 4157 successful cases in the shrinkage sequence.
