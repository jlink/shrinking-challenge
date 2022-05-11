# Report for Americium Shrinking on "lengthlist"

This report was generated with Americium 1.4.2

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``[[900, 0]]`` - casesLimit = 200

Investigation shows that it is extremely unlikely for version 1.4.2 of Americium to achieve the best shrinkage of ``[[900]]``, as the upper bound of the list elements (1000) is close to the cutoff limit of 900, and value shrinkage is not applied independently to parts of the DSL.

Cheating by increasing the upper bound to 1250 yields ``[[900]]`` as the best shrinkage.
Cheating by using a non-shrinkable range for the list elements from 0 to 1000 yields ``[[986]]`` as the best shrinkage.

## Performance

12051 cases were run.

0 successful runs were performed out of a limit of 200 successful cases, prior to the first failing case.

1 + 12 = 13 runs then failed out of a subsequent shrinkage sequence of 12051 - 0 = 12051 runs, including the first failing case.

The best shrunk case was followed by 12051 - 9785 = 2266 successful cases in the shrinkage sequence.


