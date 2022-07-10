# Reversing a list

[Original source](https://github.com/mc-imperial/hypothesis-ecoop-2020-artifact/tree/master/smartcheck-benchmarks/evaluations/reverse)

This tests the (wrong) property that reversing a list of integers results in the same list.
It is a basic example to validate that a library can reliably normalize simple sample data.

## Implementors

| Library    | Code                                                                                                   | Report                                                        |
| ---------- | ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------- |
| Hypothesis | [reverse.py](/pbt-libraries/hypothesis/challenges/reverse.py)                                          | [reverse.md](/pbt-libraries/hypothesis/challenges/reverse.md) |
| jqwik      | [ReverseProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/reverse/ReverseProperties.java) | [reverse.md](/pbt-libraries/jqwik/reports/reverse.md)         |
| PropEr     | [reverse.erl](/pbt-libraries/proper/challenges/reverse.erl)                                            | [reverse.md](/pbt-libraries/proper/challenges/reverse.md)     |
| FsCheck    | [Reverse.fsx](/pbt-libraries/fscheck/challenges/Reverse.fsx)                                           | [Reverse.md](/pbt-libraries/fscheck/challenges/Reverse.md)    |
| fast-check | [reverse.js](/pbt-libraries/fast-check/challenges/reverse.js)                                          | [reverse.md](/pbt-libraries/fast-check/reports/reverse.md)    |
| CsCheck    |[ShrinkingChallengeTests.cs](/pbt-libraries/cscheck/ShrinkingChallengeTests.cs#L46)|[reverse.md](/pbt-libraries/cscheck/reports/reverse.md)|
| elm-test   |[Reverse.elm](/pbt-libraries/elm-test/src/Challenge/Reverse.elm)|[reverse.md](/pbt-libraries/elm-test/reports/reverse.md)|
