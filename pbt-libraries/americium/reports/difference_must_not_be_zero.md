# Report for Americium Shrinking on "difference must not be zero"

This report was generated with Americium 1.4.2

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[10, 10]`` - casesLimit = 3500


## Performance

1615 cases were run.

992 successful runs were performed out of a limit of 3500 successful cases, prior to the first failing case.

1 + 1 = 2 runs then failed out of a subsequent shrinkage sequence of 1615 - 992 = 623 runs, including the first failing case.

The best shrunk case was followed by 1615 - 1292 = 323 successful cases in the shrinkage sequence.
