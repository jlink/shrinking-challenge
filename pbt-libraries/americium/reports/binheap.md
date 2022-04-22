# Report for Americium Shrinking on "binheap"

This report was generated with Americium 1.3.5

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[[0,[0,[0,None,None],[1,None,None]],None]]`` - casesLimit = 10


## Performance

444 cases were run.

3 successful runs were performed out of a limit of 10 successful cases, prior to the first failing case.

1 + 55 = 56 runs then failed out of a subsequent shrinkage sequence of 444 - 3 = 441 runs, including the first failing case.

The best shrunk case was the last one examined.
