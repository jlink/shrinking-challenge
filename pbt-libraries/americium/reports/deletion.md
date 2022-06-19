# Report for Americium Shrinking on "deletion"

This report was generated with Americium 1.4.6

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[[0, 0], 0]`` - casesLimit = 20


## Performance

372 cases were run.

341 of these were discarded by the test's inline filter, as the removal index was out of range.

*No* successful runs were performed out of a limit of 20 successful cases, prior to the first failing case.

1 + 26 = 27 runs then failed out of a subsequent shrinkage sequence of 372 - 8 = 364 runs, including the first failing case.

The best shrunk case was followed by no successful cases and 4 discarded cases in the shrinkage sequence.
