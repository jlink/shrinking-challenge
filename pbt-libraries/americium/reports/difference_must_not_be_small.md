# Report for Americium Shrinking on "difference must not be small"

This report was generated with Americium 1.5.1

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[10, 6]`` - casesLimit = 1700


## Performance

9028 cases were run.

1640 successful runs were performed out of a limit of 1700 successful cases, prior to the first failing case.

1 + 6 = 7 runs then failed out of a subsequent shrinkage sequence of 9028 - 1640 = 7388 runs, including the first failing case.

The best shrunk case was followed by 9028 - 5386 = 3642 successful cases in the shrinkage sequence.