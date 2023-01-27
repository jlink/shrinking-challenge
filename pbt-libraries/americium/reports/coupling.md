# Report for Americium Shrinking on "coupling"

This report was generated with Americium 1.8.2

## Normalization

Americium currently uses a fixed internal randomisation seed, and in this case timing variations make no difference, so shrinkage always proceeds the same way to the same result:

* ``[1, 0]`` - 2 seconds budget, repeated for each successive shrinkage cycle.

## Performance

231 cases were run, of which 223 were ignored.

Failing cases...

```
[82] [1, 0, 3, 3, 0]
Shrinking ... [231] [1, 0]
```



