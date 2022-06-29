# Report for Americium Shrinking on "deletion"

This report was generated with Americium 1.5.1

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[[0, 0], 0]`` - casesLimit = 20


## Performance

202 cases were run.

171 of these were discarded by the test's inline filter, as the removal index was out of range.

*No* successful runs were performed out of a limit of 20 successful cases, prior to the first failing case.

1 + 27 = 28 runs then failed out of a subsequent shrinkage sequence of 202 - 8 = 194 runs, including the first failing case.

The best shrunk case was followed by no successful cases and 5 discarded cases in the shrinkage sequence.
