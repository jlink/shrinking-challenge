# Large Union List

[Original source](https://github.com/HypothesisWorks/hypothesis/blob/master/hypothesis-python/tests/quality/test_shrink_quality.py)

Given a list of lists of arbitrary sized integers, we want to test the property that there are no more than four distinct integers across all the lists.
This is trivially false, and this example is an artificial one to stress test a shrinker's ability to normalise (always produce the same output regardless of starting point).

In particular, a shrinker cannot hope to normalise this unless it is able to either split or join elements of the larger list. For example, it would have to be able to transform one of `[[0, 1, -1, 2, -2]]` and `[[0], [1], [-1], [2], [-2]]` into the other.

## Implementors

| Library    | Code                                                                                                                        | Report                                                                          |
|------------|-----------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------|
| Americium  | [LargeUnionListTest.java](/pbt-libraries/americium/src/test/java/challenges/largeunionlist/LargeUnionListTest.java)         | [largeUnionList.md](/pbt-libraries/americium/reports/largeUnionList.md)         |
| Hypothesis | [large_union_list.py](/pbt-libraries/hypothesis/challenges/large_union_list.py)                                             | [large_union_list.md](/pbt-libraries/hypothesis/challenges/large_union_list.md) |
| jqwik      | [LargeUnionListProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/largeunionlist/LargeUnionListProperties.java) | [large_union_list.md](/pbt-libraries/jqwik/reports/large_union_list.md)         |
| PropEr     | [large_union_list.erl](/pbt-libraries/proper/challenges/large_union_list.erl)                                               | [large_union_list.md](/pbt-libraries/proper/challenges/large_union_list.md)     |
| FsCheck    | [LargeUnionList.fsx](/pbt-libraries/fscheck/challenges/LargeUnionList.fsx)                                                  | [LargeUnionList.md](/pbt-libraries/fscheck/challenges/LargeUnionList.md)        |
| fast-check | [large_union_list.js](/pbt-libraries/fast-check/challenges/large_union_list.js)                                             | [large_union_list.md](/pbt-libraries/fast-check/reports/large_union_list.md)    |
| CsCheck    | [ShrinkingChallengeTests.cs](/pbt-libraries/cscheck/ShrinkingChallengeTests.cs#L30)                                         | [large_union_list.md](/pbt-libraries/cscheck/reports/large_union_list.md)       |
| elm-test   | [LargeUnionList.elm](/pbt-libraries/elm-test/src/Challenge/LargeUnionList.elm)                                              | [largeUnionList.md](/pbt-libraries/elm-test/reports/largeUnionList.md)          |
