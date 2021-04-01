# FsCheck

[FsCheck](https://fscheck.github.io/FsCheck/) is a library for property-based testing .NET programs.

## FsCheck's Shrinking Approach

FsCheck's shrinking approach is vintage, similar in approach to the mother of all property-based testing: Haskell's QuickCheck. FsCheck generates values of increasing size throughout the test run, and once a failing test is found it searches for smaller values from the failing seed.

## Implemented Challenges

|Challenge|Code|Report|
|---------|----|------|
|[bound5](/challenges/bound5.md)|[Bound5.fsx](/pbt-libraries/fscheck/challenges/Bound5.fsx)|[bound5.md](/pbt-libraries/fscheck/challenges/bound5.md)|
|[large union list](/challenges/large_union_list.md)|[LargeUnionList.fsx](/pbt-libraries/fscheck/challenges/LargeUnionList.fsx)|[LargeUnionList.md](/pbt-libraries/fscheck/challenges/LargeUnionList.md)|
|[reverse](/challenges/reverse.md)|[Reverse.fsx](/pbt-libraries/fscheck/challenges/Reverse.fsx)|[Reverse.md](/pbt-libraries/fscheck/challenges/Reverse.md)|
