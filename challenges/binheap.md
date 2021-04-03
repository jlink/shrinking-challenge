# Wrong Binary Heap

[Original source](https://github.com/mc-imperial/hypothesis-ecoop-2020-artifact/tree/master/smartcheck-benchmarks/evaluations/binheap)

This is based on an example from QuickCheck's test suite (via the SmartCheck paper). 
It generates binary heaps, and then uses a wrong implementation of a function 
that converts the binary heap to a sorted list and asserts that the result is sorted.

Interestingly most libraries seem to never find the smallest example here, 
which is the four valued heap (0, None, (0, (0, None, None), (1, None, None))). 
This is essentially because small examples are "too sparse", so it's very hard to find one by luck.

## Implementors

|Library   |Code|Report|
|----------|----|------|
| jqwik    |[BinheapProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/binheap/BinheapProperties.java)|[binheap.md](/pbt-libraries/jqwik/reports/binheap.md)|
| CsCheck  |[ShrinkingChallengeTests.cs](/pbt-libraries/cscheck/ShrinkingChallengeTests.cs#L128)|[binheap.md](/pbt-libraries/cscheck/reports/binheap.md)|

