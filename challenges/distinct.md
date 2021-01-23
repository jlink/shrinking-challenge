# Distinct Elements in a List

[Original source](https://github.com/mc-imperial/hypothesis-ecoop-2020-artifact/tree/master/smartcheck-benchmarks/evaluations/distinct)

This tests the example provided for the property "a list of integers containing at least three distinct elements".

This is interesting because:

1. Most property-based testing libraries will not successfully normalize (i.e. always return the same answer) this property, because it requires reordering examples to do so.
2. Hypothesis and test.check both provide a built in generator for "a list of distinct elements", so the "example of size at least N" provides a sort of lower bound for how well they can shrink those built in generators.

The expected smallest falsified sample is `[0, 1, -1]` or `[0, 1, 2]`.

## Implementors

| Library    | Code                                                                                                      | Report                                                       |
| ---------- | --------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------ |
| jqwik      | [DistinctProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/distinct/DistinctProperties.java) | [distinct.md](/pbt-libraries/jqwik/reports/distinct.md)      |
| PropEr     | [distinct.erl](/pbt-libraries/proper/challenges/distinct.erl)                                             | [distinct.md](/pbt-libraries/proper/challenges/distinct.md)  |
| fast-check | [distinct.js](/pbt-libraries/fast-check/challenges/distinct.js)                                           | [distinct.md](/pbt-libraries/fast-check/reports/distinct.md) |
