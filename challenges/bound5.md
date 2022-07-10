# Bound 5

[Original source](https://github.com/mc-imperial/hypothesis-ecoop-2020-artifact/tree/master/smartcheck-benchmarks/evaluations/bound5)

Given a 5-tuple of
lists of 16-bit integers, we want to test the property that if each list sums
to less than 256, then the sum of all the values in the lists is less than
5 \* 256. This is false because of overflow. e.g.
`([-20000], [-20000], [], [], [])` is a counter-example.

The interesting thing about this example is the interdependence between separate parts of the sample data.
A single list in the tuple will never break the invariant, but you need at least two lists together.
This prevents most of trivial shrinking algorithms from getting close to a minimum example,
which would look somethink like `([-32768], [-1], [], [], [])`.

## Implementors

| Library    | Code                                                                                                | Report                                                      |
| ---------- | --------------------------------------------------------------------------------------------------- | ----------------------------------------------------------- |
| Hypothesis | [bound5.py](/pbt-libraries/hypothesis/challenges/bound5.py)                                         | [bound5.md](/pbt-libraries/hypothesis/challenges/bound5.md) |
| jqwik      | [Bound5Properties.java](/pbt-libraries/jqwik/src/test/java/challenges/bound5/Bound5Properties.java) | [bound5.md](/pbt-libraries/jqwik/reports/bound5.md)         |
| FsCheck    | [Bound5.fsx](/pbt-libraries/fscheck/challenges/Bound5.fsx)                                          | [bound5.md](/pbt-libraries/fscheck/challenges/bound5.md)    |
| fast-check | [bound5.js](/pbt-libraries/fast-check/challenges/bound5.js)                                         | [bound5.md](/pbt-libraries/fast-check/reports/bound5.md)    |
| CsCheck    |[ShrinkingChallengeTests.cs](/pbt-libraries/cscheck/ShrinkingChallengeTests.cs#L12)|[bound5.md](/pbt-libraries/cscheck/reports/bound5.md)|
| elm-test   |[Bound5.elm](/pbt-libraries/elm-test/src/Challenge/Bound5.elm)|[bound5.md](/pbt-libraries/elm-test/reports/bound5.md)|
