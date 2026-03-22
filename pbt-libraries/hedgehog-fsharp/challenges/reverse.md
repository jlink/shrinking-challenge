# Report for Hedgehog Shrinking on "Reverse"

Results here obtained with Hedgehog `2.0.3`.

Hedgehog does not settle on a single value in every run.
However, all values found in `5` runs were two element lists:

Some examples:

```
  *** Failed! Falsifiable (after 26 tests and 8 shrinks):

You can reproduce this failure with the following Recheck Seed:
  "25_3479109976523679798_1989646907561279609_3-4-4-4-4-4-4-4"

Generated values:
  [0; 1]
```

```
  *** Failed! Falsifiable (after 25 tests and 8 shrinks):

You can reproduce this failure with the following Recheck Seed:
  "24_8093402549480178335_8201771464568061419_3-4-4-4-4-4-4-4"

Generated values:
  [0; -1]
```

Overall: **PASS**