# Large Union List

[Original source](https://github.com/HypothesisWorks/hypothesis/blob/master/hypothesis-python/tests/quality/test_shrink_quality.py)

Given a list of lists of arbitrary sized integers, we want to test the property that there are no more than four distinct integers across all the lists.
This is trivially false, and this example is an artificial one to stress test a shrinker's ability to normalise (always produce the same output regardless of starting point).

In particular, a shrinker cannot hope to normalise this unless it is able to either split or join elements of the larger list. For example, it would have to be able to transform one of ``[[0, 1, -1, 2, -2]]`` and ``[[0], [1], [-1], [2], [-2]]`` into the other.

## Implementors

- [hypothesis: Large Union List](/pbt-libraries/hypothesis/challenges/large_union_list.py)

- [jqwik: Large Union List](/pbt-libraries/jqwik/src/test/java/challenges/largeunionlist/LargeUnionListProperties.java)
