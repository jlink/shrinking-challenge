# jqwik

[jqwik](https://jqwik.net) is a property-based library for the JVM.
It's implemented as a test enginge for the
[JUnit 5 platform](https://junit.org/junit5/docs/current/api/org.junit.platform.engine/org/junit/platform/engine/TestEngine.html).

## jqwik's Shrinking Approach

jqwik derives shrinking behaviour directly from a generator's specification.
That means that users get shrinking for free if they just compose the built-in
generators (aka arbitraries).

jqwik also goes for
[Integrated Shrinking](https://jqwik.net/docs/current/user-guide.html#integrated-shrinking),
which means that all constraints from value generation are also considered during shrinking.

## Implemented Challenges

|Challenge|Code|Report|
|---------|----|------|
|[bound5](/challenges/bound5.md)|[Bound5Properties.java](/pbt-libraries/jqwik/src/test/java/challenges/bound5/Bound5Properties.java)|[bound5.md](/pbt-libraries/jqwik/reports/bound5.md)
|[large union list](/challenges/large_union_list.md)|[LargeUnionListProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/largeunionlist/LargeUnionListProperties.java)|[large_union_list.md](/pbt-libraries/jqwik/reports/large_union_list.md)
|[reverse](/challenges/reverse.md)|[ReverseProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/reverse/ReverseProperties.java)|[reverse.md](/pbt-libraries/jqwik/reports/reverse.md)
|[calculator](/challenges/calculator.md)|[CalculatorProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/calculator/CalculatorProperties.java)|[calculator.md](/pbt-libraries/jqwik/reports/calculator.md)
|[length list](/challenges/lengthlist.md)|[LengthListProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/lengthlist/LengthListProperties.java)|[lengthlist.md](/pbt-libraries/jqwik/reports/lengthlist.md)
|[difference](/challenges/difference.md)|[DifferenceProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/difference/DifferenceProperties.java)|[difference_must_not_be_zero.md](/pbt-libraries/jqwik/reports/difference_must_not_be_zero.md)
|         |    |[difference_must_not_be_one.md](/pbt-libraries/jqwik/reports/difference_must_not_be_one.md)
|         |    |[difference_must_not_be_small.md](/pbt-libraries/jqwik/reports/difference_must_not_be_small.md)

## Running examples

You need Java >= 11.

```bash
cd pbt-libraries/jqwik
./gradlew test
```
