## Bound 5

Given a 5-tuple of
lists of 16-bit integers, we want to test the property that if each list sums
to less than 256, then the sum of all the values in the lists is less than
5 * 256. This is false because of overflow. e.g.
`([-20000], [-20000], [], [], [])` is a counter-example.
