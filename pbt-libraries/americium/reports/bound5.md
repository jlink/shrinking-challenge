# Report for Americium Shrinking on "bound5"

This report was generated with Americium 1.8.2

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``(List(),List(-16805),List(),List(-15974),List())`` - 1 second budget and then increasing in steps of 1 second for each successive shrinkage cycle.

## Performance

414344 cases were run.

Failing cases...

```
0 - Shrinkage has found a failing case: (List(),List(),List(-28595),List(-23886, -30303, -22013),List(30386, 18619)) after 4 trials including this one.
1 - Shrinkage has found a failing case: (List(),List(),List(),List(-23279, -5840),List(-10545, -23779, 17415)) after 5 trials including this one.
2 - Shrinkage has found a failing case: (List(-26702),List(),List(-26693),List(),List()) after 6 trials including this one.
3 - Shrinkage has found a failing case: (List(),List(-22671),List(),List(-23924),List()) after 24 trials including this one.
4 - Shrinkage has found a failing case: (List(-25809),List(),List(),List(-9943),List()) after 47 trials including this one.
5 - Shrinkage has found a failing case: (List(),List(-19653),List(),List(),List(-13515)) after 50 trials including this one.
6 - Shrinkage has found a failing case: (List(),List(-16292),List(),List(-16771),List()) after 5076 trials including this one.
7 - Shrinkage has found a failing case: (List(),List(-16292),List(),List(-16771),List()) after 18575 trials including this one.
8 - Shrinkage has found a failing case: (List(),List(-16549),List(),List(-16445),List()) after 18732 trials including this one.
9 - Shrinkage has found a failing case: (List(),List(-16549),List(),List(-16445),List()) after 33865 trials including this one.
10 - Shrinkage has found a failing case: (List(),List(-16768),List(),List(-16096),List()) after 35240 trials including this one.
11 - Shrinkage has found a failing case: (List(),List(-16768),List(),List(-16096),List()) after 50571 trials including this one.
12 - Shrinkage has found a failing case: (List(),List(-16759),List(),List(-16088),List()) after 61259 trials including this one.
13 - Shrinkage has found a failing case: (List(),List(-16759),List(),List(-16088),List()) after 77813 trials including this one.
14 - Shrinkage has found a failing case: (List(),List(-16805),List(),List(-15974),List()) after 181895 trials including this one.
15 - Shrinkage has found a failing case: (List(),List(-16805),List(),List(-15974),List()) after 198841 trials including this one.
```

