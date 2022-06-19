# Report for Americium Shrinking on "difference must not be one"

This report was generated with Americium 1.4.6

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[10, 9]`` - casesLimit = 1000


## Performance

566 cases were run.

332 successful runs were performed out of a limit of 1000 successful cases, prior to the first failing case.

1 + 1 = 2 runs then failed out of a subsequent shrinkage sequence of 566 - 332 = 234 runs, including the first failing case.

The best shrunk case was followed by 566 - 391 = 175 successful cases in the shrinkage sequence.
