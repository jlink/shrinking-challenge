# Coupling

[Original source](https://github.com/mc-imperial/hypothesis-ecoop-2020-artifact/tree/master/smartcheck-benchmarks/evaluations/coupling)

In this example the elements of a list of integers are coupled to their position
in an unusual way.

The expected smallest falsified sample is `[1, 0]`.

## Implementors

| Library    | Code                                                                                                      | Report                                                       |
| ---------- | --------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------ |
| jqwik      | [CouplingProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/coupling/CouplingProperties.java) | [coupling.md](/pbt-libraries/jqwik/reports/coupling.md)      |
| fast-check | [coupling.js](/pbt-libraries/fast-check/challenges/coupling.js)                                           | [coupling.md](/pbt-libraries/fast-check/reports/coupling.md) |
| CsCheck    |[ShrinkingChallengeTests.cs](/pbt-libraries/cscheck/ShrinkingChallengeTests.cs#L190)|[coupling.md](/pbt-libraries/cscheck/reports/coupling.md)|
| elm-test   |[Coupling.elm](/pbt-libraries/elm-test/src/Challenge/Coupling.elm)|[coupling.md](/pbt-libraries/elm-test/reports/coupling.md)|
