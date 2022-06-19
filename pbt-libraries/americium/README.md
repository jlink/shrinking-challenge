# Americium

[Americium](https://index.scala-lang.org/sageserpent-open/americium) is a testing utility for Scala and Java.

Its philosophy is to be lean and not too opinionated - it generates test cases for parameterised tests, but what style
of testing those tests employ is down to you. It has APIs that are customized to suit both Scala and Java testing code.

A simple DSL is provided to generate test data - this is fed directly to a parameterised test, which may or may not be
housed within in a standard off-the-shelf test framework suite, and which is free to use any assertion language. All
that matters is that a succeeding test completes, and a failing one throws an exception.

There is an *optional* integration
with [JUnit 5](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-templates) that allows tests to be
written in a similar fashion as JUnit 5's `@ParameterisedTest` approach, only Americium integrates test failure
shrinking into test templates.

By default, all randomly chosen scalar values are equally probable within the overall range. It is possible to specify
the range, and also to set up a skewed distribution, but this is something the end user must consciously opt-into.

The seed value for randomized generation is fixed in the code in release 1.4.2 to allow repeatability of test
runs.

## Americium's Shrinking Approach

Americium features integrated shrinking - when you use the DSL to generate test cases, they will be shrunk for you
automatically without writing custom code to do this. Invariants that are set up by the DSL on the test data are
enforced on shrunk test cases too.

Americium has two notions of what to shrink - the **complexity** of the test cases, and the **magnitude** of scalar
data, where that is an applicable concept. The complexity relates to structured test data that can be extended - the
shallower and thinner the data structure, the less complex it is. The magnitude covers numeric or denumerable values -
by default these are shrunk towards a zero-magnitude case, however it is possible to configure in alternative magnitudes
to shrink towards on an individual basis in the DSL.

It is also possible to mix in finitely enumerable data in the DSL that isn't shrunk at all, modelling the notion of a
set of equally valid choices.

## Implemented Challenges

| Challenge                                 | Code                                                                                                       | Report                                                                                              |
|-------------------------------------------|------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
|                                           ||
||||
||||
||||
| [length list](/challenges/lengthlist.md)  | [LengthListTest.java](/pbt-libraries/americium/src/test/java/challenges/lengthlist/LengthListTest.java)    | [lengthList.md](/pbt-libraries/americium/reports/lengthlist.md)                                     |
| [difference](/challenges/difference.md)   | [DifferenceTest.java](/pbt-libraries/americium/src/test/java/challenges/difference/DifferenceTest.java)    | [difference_must_not_be_zero.md](/pbt-libraries/americium/reports/difference_must_not_be_zero.md)   |
|                                           |                                                                                                            | [difference_must_not_be_one.md](/pbt-libraries/americium/reports/difference_must_not_be_one.md)     |
|                                           |                                                                                                            | [difference_must_not_be_small.md](/pbt-libraries/americium/reports/difference_must_not_be_small.md) |
| [binheap](/challenges/binheap.md)         | [HeapTest.java](/pbt-libraries/americium/src/test/java/challenges/binheap/HeapTest.java)                   | [binheap.md](/pbt-libraries/americium/reports/binheap.md)                                           |
||||
| [deletion](/challenges/deletion.md)       | [DeletionTest.java](/pbt-libraries/americium/src/test/java/challenges/deletion/DeletionTest.java)          | [deletion.md](/pbt-libraries/americium/reports/deletion.md)                                         |
||||
| [nestedlists](/challenges/nestedlists.md) | [NestedListsTest.java](/pbt-libraries/americium/src/test/java/challenges/nestedlists/NestedListsTest.java) | [nestedLists.md](/pbt-libraries/americium/reports/nestedlists.md)                                   |

## Running examples

You need Java >= 8 (1.8) and the SBT build tool if you want to run both the Java and Scala tests.

Get the latter from here: [SBT](https://www.scala-sbt.org/), it is available for Windows, Linux, MacOS.

If you're only interested in the Java tests, use Maven instead.

```bash
cd pbt-libraries/americium
# Run both the Java and Scala tests via SBT...
sbt test
# Alternatively, run just the Java tests via Maven ...
mvn test
```
