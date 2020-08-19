# Reversing a list

[Original source](https://github.com/mc-imperial/hypothesis-ecoop-2020-artifact/tree/master/smartcheck-benchmarks/evaluations/reverse)

This tests the (wrong) property that reversing a list results in the same list.
It's a basic example to validate that a library can reliably normalize simple sample data.

## Implementors

|Library   |Code|Report|
|----------|----|------|
|Hypothesis|[reverse.py](/pbt-libraries/hypothesis/challenges/reverse.py)|[reverse.md](/pbt-libraries/hypothesis/challenges/reverse.md)
|jqwik     |[ReverseProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/reverse/ReverseProperties.java)|[reverse.md](/pbt-libraries/hypothesis/reports/reverse.md)
