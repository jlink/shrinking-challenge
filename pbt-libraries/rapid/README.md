# rapid

[Rapid](https://pgregory.net/rapid) is a Go library for property-based testing that supports state machine ("stateful"
or "model-based") testing and fully automatic test case minimization ("shrinking").

Rapid uses Hypothesis's approach of integrated data generation and shrinking: data generation creates a labeled stream
of random bits, and shrinking tries to simplify this stream without any high-level knowledge about generated values.
Values drawn from the simplified stream are simpler (because the generators are specifically constructed this way).

## Implemented challenges

| Challenge                                           | Code                                                             | Report                                                                                          |
|-----------------------------------------------------|------------------------------------------------------------------|-------------------------------------------------------------------------------------------------|
| [bound5](/challenges/bound5.md)                     | [TestBound5](/pbt-libraries/rapid/challenge_test.go)             | [bound5.md](/pbt-libraries/rapid/reports/bound5.md)                                             |
| [large union list](/challenges/large_union_list.md) | [TestLargeUnionList](/pbt-libraries/rapid/challenge_test.go)     | [large_union_list.md](/pbt-libraries/rapid/reports/large_union_list.md)                         |
| [reverse](/challenges/reverse.md)                   | [TestReverse](/pbt-libraries/rapid/challenge_test.go)            | [reverse.md](/pbt-libraries/rapid/reports/reverse.md)                                           |
| [length list](/challenges/lengthlist.md)            | [TestLengthList](/pbt-libraries/rapid/challenge_test.go)         | [lengthlist.md](/pbt-libraries/rapid/reports/lengthlist.md)                                     |
| [difference](/challenges/difference.md)             | [TestDifferenceNotZero](/pbt-libraries/rapid/challenge_test.go)  | [difference_must_not_be_zero.md](/pbt-libraries/rapid/reports/difference_must_not_be_zero.md)   |
|                                                     | [TestDifferenceNotSmall](/pbt-libraries/rapid/challenge_test.go) | [difference_must_not_be_small.md](/pbt-libraries/rapid/reports/difference_must_not_be_small.md) |
|                                                     | [TestDifferenceNotOne](/pbt-libraries/rapid/challenge_test.go)   | [difference_must_not_be_one.md](/pbt-libraries/rapid/reports/difference_must_not_be_one.md)     |
| [coupling](/challenges/coupling.md)                 | [TestCoupling](/pbt-libraries/rapid/challenge_test.go)           | [coupling.md](/pbt-libraries/rapid/reports/coupling.md)                                         |
| [deletion](/challenges/deletion.md)                 | [TestDeletion](/pbt-libraries/rapid/challenge_test.go)           | [deletion.md](/pbt-libraries/rapid/reports/deletion.md)                                         |
| [distinct](/challenges/distinct.md)                 | [TestDistinct](/pbt-libraries/rapid/challenge_test.go)           | [distinct.md](/pbt-libraries/rapid/reports/distinct.md)                                         |
| [nestedlists](/challenges/nestedlists.md)           | [TestNestedLists](/pbt-libraries/rapid/challenge_test.go)        | [nestedlists.md](/pbt-libraries/rapid/reports/nestedlists.md)                                   |

## Running tests

To run e.g. `bound5` test, run `go test -run=TestBound5`. To view the list of all tests, run `go test -list .`.

## Generating reports

To re-generate all reports, run `go run runner.go`.
