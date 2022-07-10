# Calculator

[Original source](https://github.com/mc-imperial/hypothesis-ecoop-2020-artifact/blob/master/smartcheck-benchmarks/evaluations/calculator)

The challenge involves a simple calculator language representing expressions consisting of integers, their additions and divisions only, like 1 + (2 / 3).

The property being tested is that 
- if we have no subterms of the form x / 0, 
- then we can evaluate the expression without a zero division error.

This property is false, because we might have a term like 1 / (3 + -3), in which the divisor is not literally 0 but evaluates to 0.

One of the possible difficulties that might come up is the shrinking of recursive expressions.

## Implementors

| Library    | Code                                                                                                            | Report                                                              |
| ---------- | --------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------- |
| Hypothesis | [calculator.py](/pbt-libraries/hypothesis/challenges/calculator.py)                                             | [calculator.md](/pbt-libraries/hypothesis/challenges/calculator.md) |
| jqwik      | [CalculatorProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/calculator/CalculatorProperties.java) | [calculator.md](/pbt-libraries/jqwik/reports/calculator.md)         |
| PropEr     | [calculator.erl](/pbt-libraries/proper/challenges/calculator.erl)                                               | [calculator.md](/pbt-libraries/proper/challenges/calculator.md)     |
| fast-check | [calculator.js](/pbt-libraries/fast-check/challenges/calculator.js)                                             | [calculator.md](/pbt-libraries/fast-check/reports/calculator.md)    |
| CsCheck    |[ShrinkingChallengeTests.cs](/pbt-libraries/cscheck/ShrinkingChallengeTests.cs#L60)|[calculator.md](/pbt-libraries/cscheck/reports/calculator.md)|
| elm-test   |[Calculator.elm](/pbt-libraries/elm-test/src/Challenge/Calculator.elm)|[calculator.md](/pbt-libraries/elm-test/reports/calculator.md)|
