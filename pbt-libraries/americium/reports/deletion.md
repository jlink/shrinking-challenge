# Report for Americium Shrinking on "deletion"

This report was generated with Americium 1.3.5

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[[0, 0], 0]`` - casesLimit = 20


## Performance

398 cases were run.

331 of these were discarded by the test's inline filter, as the removal index was out of range.

*No* successful runs were performed out of a limit of 20 successful cases, prior to the first failing case.

1 + 50 = 51 runs then failed out of a subsequent shrinkage sequence of 398 - (331 + 0) = 67 runs, including the first failing case.

The best shrunk case was followed by two successful cases in the shrinkage sequence.
