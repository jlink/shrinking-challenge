# Report for Americium Shrinking on "difference must not be zero"

This report was generated with Americium 1.5.1

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[10, 10]`` - casesLimit = 300


## Performance

1516 cases were run.

250 successful runs were performed out of a limit of 300 successful cases, prior to the first failing case.

1 + 3 = 4 runs then failed out of a subsequent shrinkage sequence of 1516 - 250 = 1266 runs, including the first failing case.

The best shrunk case was followed by 1516 - 1009 = 507 successful cases in the shrinkage sequence.
