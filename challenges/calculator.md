# Calculator

[Original source](https://github.com/mc-imperial/hypothesis-ecoop-2020-artifact/blob/master/smartcheck-benchmarks/evaluations/calculator)

The idea is that we have a simple calculator language representing expressions like 1 + (2 / 3).
The property being tested is that if we have no subterms of the form x / 0, then we can evaluate the expression without a zero division error. 
This property is false, because we might have a term like 1 / (3 + -3).

One of the possible difficulties that might come up is the shrinking of recursive expressions.


## Implementors

|Library   |Code|Report|
|----------|----|------|
|Hypothesis|[calculator.py](/pbt-libraries/hypothesis/challenges/calculator.py)|[calculator.md](/pbt-libraries/hypothesis/challenges/calculator.md)
|jqwik     |[CalculatorProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/calculator/CalculatorProperties.java)|[calculator.md](/pbt-libraries/hypothesis/reports/calculator.md)
