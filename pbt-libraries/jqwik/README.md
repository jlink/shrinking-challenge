# jqwik

[jqwik](https://jqwik.net) is a property-based library for the JVM.
It's implemented as a test enginge for the
[JUnit 5 platform](https://junit.org/junit5/docs/current/api/org.junit.platform.engine/org/junit/platform/engine/TestEngine.html).

## jqwik's Shrinking Approach

jqwik goes for
[Integrated Shrinking](https://jqwik.net/docs/current/user-guide.html#integrated-shrinking),
which means that all constraints from value generation are also considered during shrinking.

## Implemented Challenges

- [bound5](/pbt-libraries/jqwik/src/test/java/challenges/bound5/Bound5Properties.java)
- [large union list](/pbt-libraries/jqwik/src/test/java/challenges/largeunionlist/LargeUnionListProperties.java)


## Running examples

You need Java >= 11.

```bash
cd pbt-libraries/jqwik
./gradlew test
```
