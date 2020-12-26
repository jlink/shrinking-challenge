# Report for FsCheck Shrinking on "Reverse"

Results obtained with FsCheck 2.14.3.

## Normalization

FsCheck shrinks to `[1;0]` or `[0;1]`, typically with a handful of shrinks.

Representative example:

```fsharp
Falsifiable, after 4 tests (3 shrinks) (StdGen (16408286, 296834019)):
Original:
[0; -1; 3]
Shrunk:
[1; 0]
```
