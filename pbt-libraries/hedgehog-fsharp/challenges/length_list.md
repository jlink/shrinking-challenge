# Report for Hedgehog Shrinking on "Length List"

Results here obtained with Hedgehog `2.0.3`.

Hedgehog does not settle on a single value in every run.

Some examples:

```fsharp
  *** Failed! Falsifiable (after 18 tests and 6 shrinks):

You can reproduce this failure with the following Recheck Seed:
  "17_11099891028185523776_17743195683886446441_2-3-3-8-6-6"

Generated values:
  [116; 36; 66; 66; 80; 132; 54; 133; 84; 133]
```

```fsharp
  *** Failed! Falsifiable (after 18 tests and 4 shrinks):

You can reproduce this failure with the following Recheck Seed:
  "17_12323740322136880770_6689838319721270329_3-5-1-1"

Generated values:
  [13; 44; 54; 84; 168; 95; 145; 2; 23; 6; 70; 154; 42]
```

In `5` attempts it never achieved the optimal shrink of `[ 900 ]`.

Overall: **Fail**
