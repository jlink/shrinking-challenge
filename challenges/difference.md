# Difference

There are two tests in this challenge. Both deal with the absolute difference 
between two random positive integer parameters. 

Test 1 ("difference must not be zero") only succeeds if 
- the first parameter is less than 10 
- _or_ the difference is zero.
The smallest falsified sample is `[10, 10]`

Test 2 ("difference must not be small") only succeeds if 
- the first parameter is less than 10 
- _or_ the difference is between 1 and 4.
The smallest falsified sample is `[10, 6]`.

Shrinking is a challenge here because it requires keeping up a dependency between 
two distinct parameters. 
Additionally, it can be a challenge to find a first failing sample when generation of 
integers is naively done uniformly across the realm of positive integers. 

## Implementors

- [jqwik: Difference](/pbt-libraries/jqwik/src/test/java/challenges/difference/DifferenceProperties.java)
