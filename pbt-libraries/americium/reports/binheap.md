# Report for Americium Shrinking on "binheap"

This report was generated with Americium 1.4.6

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[[0,[0,[0,None,None],[1,None,None]],None]]`` - casesLimit = 170


## Performance

5747 cases were run.

3 successful runs were performed out of a limit of 170 successful cases, prior to the first failing case.

1 + 41 = 42 runs then failed out of a subsequent shrinkage sequence of 5747 - 3 = 5744 runs, including the first failing case.

The best shrunk case was followed by 5747 - 5540 = 207 successful cases in the shrinkage sequence.
