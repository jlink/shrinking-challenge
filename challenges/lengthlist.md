# Length List

A list should be generated first by picking a length n between 1 and 100, then by generating a list of precisely that length whose elements are integers between 0 and 1000.
The test should fail if the maximum value of the list is 900 or larger.

This list should specifically be generated using monadic combinators (bind) or some equivalent, and this is a test that is only interesting for integrated shrinking.
This is only interesting as a test of a problem [some property-based testing libraries have with monadic bind](https://clojure.github.io/test.check/growth-and-shrinking.html#unnecessary-bind).
In particular the use of the length parameter is critical, and any reasonable library should be able to reduce this example to ``[900]`` reliably if it uses its built in generator for lists.

## Implementors

- [hypothesis: Length List](/pbt-libraries/hypothesis/challenges/lengthlist.py)
- [jqwik: Length List](/pbt-libraries/jqwik/src/test/java/challenges/lengthlist/LengthListProperties.java)
