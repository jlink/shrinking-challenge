# Report for Americium Shrinking on "binheap"

This report was generated with Americium 1.5.1

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[[0,[0,[0,None,None],[1,None,None]],None]]`` - casesLimit = 190


## Performance

8075 cases were run.

3 successful runs were performed out of a limit of 190 successful cases, prior to the first failing case.

1 + 42 = 43 runs then failed out of a subsequent shrinkage sequence of 8075 - 3 = 8072 runs, including the first failing case.

The best shrunk case was followed by 8072 - 7806 = 266 successful cases in the shrinkage sequence.
