# Bound 5

[Original source](https://github.com/mc-imperial/hypothesis-ecoop-2020-artifact/tree/master/smartcheck-benchmarks/evaluations/bound5)

Given a 5-tuple of
lists of 16-bit integers, we want to test the property that if each list sums
to less than 256, then the sum of all the values in the lists is less than
5 * 256. This is false because of overflow. e.g.
`([-20000], [-20000], [], [], [])` is a counter-example.

## Implementors

- [jqwik: Bound 5](/pbt-libraries/src/test/java/challenges/bound5/Bound5Properties.java)
