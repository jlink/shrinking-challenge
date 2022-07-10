# Deletion

[Original source](https://github.com/mc-imperial/hypothesis-ecoop-2020-artifact/tree/master/smartcheck-benchmarks/evaluations/deletion)

This tests the property "if we remove an element from a list, the element is
no longer in the list". The remove function we use however only actually
removes the _first_ instance of the element, so this fails whenever the list
contains a duplicate and we try to remove one of those elements.

This example is interesting for a couple of reasons:

1. It's a nice easy to explain example of property-based testing.
2. Shrinking duplicates simultaneously is something that most property-based
   testing libraries can't do.

The expected smallest falsified sample is `([0, 0], 0)`.

## Implementors

| Library    | Code                                                                                                      | Report                                                       |
| ---------- | --------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------ |
| jqwik      | [DeletionProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/deletion/DeletionProperties.java) | [deletion.md](/pbt-libraries/jqwik/reports/deletion.md)      |
| fast-check | [deletion.js](/pbt-libraries/fast-check/challenges/deletion.js)                                           | [deletion.md](/pbt-libraries/fast-check/reports/deletion.md) |
| CsCheck    |[ShrinkingChallengeTests.cs](/pbt-libraries/cscheck/ShrinkingChallengeTests.cs#L205)|[deletion.md](/pbt-libraries/cscheck/reports/deletion.md)|
| elm-test   |[Deletion.elm](/pbt-libraries/elm-test/src/Challenge/Deletion.elm)|[deletion.md](/pbt-libraries/elm-test/reports/deletion.md)|
