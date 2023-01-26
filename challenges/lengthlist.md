# Length List

A list should be generated first by picking a length between 1 and 100, then by generating a list of precisely that length whose elements are integers between 0 and 1000.
The test should fail if the maximum value of the list is 900 or larger.

This list should specifically be generated using monadic combinators (bind) or some equivalent, and this is a test that is only interesting for integrated shrinking.
This is only interesting as a test of a problem [some property-based testing libraries have with monadic bind](https://clojure.github.io/test.check/growth-and-shrinking.html#unnecessary-bind).
In particular the use of the length parameter is critical, and the challenge is to shrink this example to `[900]` reliably when using a PBT library's built in generator for lists.

## Implementors

| Library    | Code                                                                                                            | Report                                                              |
|------------|-----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------|
| Americium  | [LengthListTest.java](/pbt-libraries/americium/src/test/java/challenges/lengthlist/LengthListTest.java)         | [lengthlist.md](/pbt-libraries/americium/reports/lengthlist.md)     |
| Hypothesis | [lengthlist.py](/pbt-libraries/hypothesis/challenges/lengthlist.py)                                             | [lengthlist.md](/pbt-libraries/hypothesis/challenges/lengthlist.md) |
| jqwik      | [LengthListProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/lengthlist/LengthListProperties.java) | [lengthlist.md](/pbt-libraries/jqwik/reports/lengthlist.md)         |
| PropEr     | [lengthlist.erl](/pbt-libraries/proper/challenges/lengthlist.erl)                                               | [lengthlist.md](/pbt-libraries/proper/challenges/lengthlist.md)     |
| fast-check | [lengthlist.js](/pbt-libraries/fast-check/challenges/lengthlist.js)                                             | [lengthlist.md](/pbt-libraries/fast-check/reports/lengthlist.md)    |
| CsCheck    | [ShrinkingChallengeTests.cs](/pbt-libraries/cscheck/ShrinkingChallengeTests.cs#L93)                             | [lengthlist.md](/pbt-libraries/cscheck/reports/lengthlist.md)       |
| elm-test   | [LengthList.elm](/pbt-libraries/elm-test/src/Challenge/LengthList.elm)                                          | [lengthList.md](/pbt-libraries/elm-test/reports/lengthList.md)      |
