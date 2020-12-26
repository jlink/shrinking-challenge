# FsCheck

[FsCheck](https://fscheck.github.io/FsCheck/) is a library for property-based testing .NET programs.

## FsCheck's Shrinking Approach

FsCheck's shrinking approach is vintage, similar in approach to the mother of all property-based testing: Haskell's QuickCheck. FsCheck generates values of increasing size throughout the test run, and once a failing test is found it searches for smaller values from the failing seed.

## Implemented Challenges

- [bound5](/pbt-libraries/fscheck/challenges/bound5.fsx)
- [reverse](/pbt-libraries/fscheck/challenges/reverse.fsx)
