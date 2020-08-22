# Nested Lists

[Original source](https://github.com/mc-imperial/hypothesis-ecoop-2020-artifact/tree/master/smartcheck-benchmarks/evaluations/nestedlists)

This tests the performance of shrinking a list of lists, subject to the
constraint that the sum of the element lists is at least 10.

The reason this is interesting is that it has lots of local minima under
pure deletion based approaches. e.g. `[[0], ..., [0]]` and `[[0, ..., 0]]` are
both minima for this under anything that can only make individual elements
smaller.

Some libraries, e.g. Hypothesis and jqwik, can shrink this reliably to 
a single list of 11 elements: `[[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]`.

## Implementors

|Library   |Code|Report|
|----------|----|------|
|jqwik     |[NestedListsProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/nestedlists/NestedListsProperties.java)|[nestedlists.md](/pbt-libraries/jqwik/reports/nestedlists.md)|

