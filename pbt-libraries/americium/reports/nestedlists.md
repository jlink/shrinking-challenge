# Report for Americium Shrinking on "nestedlists"

This report was generated with Americium 1.4.2

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[[[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]]`` - casesLimit = 500

## Performance

1248 cases were run.

78 successful runs were performed out of a limit of 500 successful cases, prior to the first failing case.

1 + 5 = 6 runs then failed out of a subsequent shrinkage sequence of 1248 - 78 = 1170 runs, including the first failing case.

The best shrunk case was followed by 1248 - 930 = 318 successful cases in the shrinkage sequence.


