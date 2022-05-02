# Report for Americium Shrinking on "difference must not be zero"

This report was generated with Americium 1.4.2

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[10, 10]`` - casesLimit = 1000


## Performance

6016 cases were run.

992 successful runs were performed out of a limit of 1000 successful cases, prior to the first failing case.

1 + 5 = 6 runs then failed out of a subsequent shrinkage sequence of 6016 - 992 = 5024 runs, including the first failing case.

The best shrunk case was followed by 6016 - 4632 = 1384 successful cases in the shrinkage sequence.
