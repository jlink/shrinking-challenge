# Report for Americium Shrinking on "difference must not be small"

This report was generated with Americium 1.4.2

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[10, 6]`` - casesLimit = 150


## Performance

4985 cases were run.

126 successful runs were performed out of a limit of 150 successful cases, prior to the first failing case.

1 + 44 = 45 runs then failed out of a subsequent shrinkage sequence of 4985 - 126 = 4859 runs, including the first failing case.

The best shrunk case was followed by 4985 - 4632 = 353 successful cases in the shrinkage sequence.