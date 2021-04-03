# Difference

There are two tests in this challenge. Both deal with the absolute difference 
between two random positive integer parameters. 

Test 1 ("difference must not be zero") only succeeds if 
- the first parameter is less than 10 
- _or_ the difference is not zero.
The smallest falsified sample is `[10, 10]`

Test 2 ("difference must not be small") only succeeds if 
- the first parameter is less than 10 
- _or_ the difference is not between 1 and 4.
The smallest falsified sample is `[10, 6]`.

Test 3 ("difference must not be one") only succeeds if 
- the first parameter is less than 10 
- _or_ the difference is not exactly 1.
The smallest falsified sample is `[10, 9]`.

Shrinking is a challenge in these examples because it requires keeping up a dependency between 
two distinct parameters. 
Additionally, it can be a challenge to find a first failing sample when generation of 
integers is naively done uniformly across the realm of positive integers. 

Test 3 seems the most difficult one to shrink because shrinking parameters individually
will never lead to a smaller and falsifying sample.
This is also the hardest to find a falsifying sample in the first place.


## Implementors

|Library   |Code|Report|
|----------|----|------|
| jqwik    |[DifferenceProperties.java](/pbt-libraries/jqwik/src/test/java/challenges/difference/DifferenceProperties.java)|[difference_must_not_be_zero.md](/pbt-libraries/jqwik/reports/difference_must_not_be_zero.md)
|          |    |[difference_must_not_be_one.md](/pbt-libraries/jqwik/reports/difference_must_not_be_one.md)
|          |    |[difference_must_not_be_small.md](/pbt-libraries/jqwik/reports/difference_must_not_be_small.md)
| CsCheck  |[ShrinkingChallengeTests.cs](/pbt-libraries/cscheck/ShrinkingChallengeTests.cs#L105)|[difference_must_not_be_zero.md](/pbt-libraries/cscheck/reports/difference_must_not_be_zero.md)
|          |[ShrinkingChallengeTests.cs](/pbt-libraries/cscheck/ShrinkingChallengeTests.cs#L119)|[difference_must_not_be_one.md](/pbt-libraries/cscheck/reports/difference_must_not_be_one.md)
|          |[ShrinkingChallengeTests.cs](/pbt-libraries/cscheck/ShrinkingChallengeTests.cs#L112)|[difference_must_not_be_small.md](/pbt-libraries/cscheck/reports/difference_must_not_be_small.md)
