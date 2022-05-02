# Report for Americium Shrinking on "difference must not be one"

This report was generated with Americium 1.4.2

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[10, 9]`` - casesLimit = 350


## Performance

12656 cases were run.

332 successful runs were performed out of a limit of 350 successful cases, prior to the first failing case.

1 + 42 = 43 runs then failed out of a subsequent shrinkage sequence of 12656 - 332 = 12324 runs, including the first failing case.

The best shrunk case was followed by 12656 - 11871 = 785 successful cases in the shrinkage sequence.
