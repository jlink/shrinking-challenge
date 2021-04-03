# Nested Lists

[Original source](https://github.com/mc-imperial/hypothesis-ecoop-2020-artifact/tree/master/smartcheck-benchmarks/evaluations/nestedlists)

This tests the performance of shrinking a list of lists, testing the false
property that the sum of lengths of the element lists is at most 10.

The reason this is interesting is that it has lots of local minima under
pure deletion based approaches. e.g. `[[0], ..., [0]]` and `[[0, ..., 0]]` are
both minima for this under anything that can only make individual elements
smaller.

Some libraries, e.g. Hypothesis and jqwik, can shrink this reliably to
a single list of 11 elements: `[[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]`.

## Implementors

| Library    | Code                                                                                                               | Report                                                             |
| ---------- | ------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------ |
| jqwik      | [NestedListsProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/nestedlists/NestedListsProperties.java) | [nestedlists.md](/pbt-libraries/jqwik/reports/nestedlists.md)      |
| fast-check | [nestedlist.js](/pbt-libraries/fast-check/challenges/nestedlists.js)                                               | [nestedlists.md](/pbt-libraries/fast-check/reports/nestedlists.md) |
| CsCheck    |[ShrinkingChallengeTests.cs](/pbt-libraries/cscheck/ShrinkingChallengeTests.cs#L225)|[nestedlists.md](/pbt-libraries/cscheck/reports/nestedlists.md)|
