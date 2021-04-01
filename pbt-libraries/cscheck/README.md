# CsCheck

[CsCheck](https://github.com/AnthonyLloyd/CsCheck) ia a random testing library for C#.

## Shrinking Approach

CsCheck `Gen<T>` generates a type `T` and `Size` using a random number generator [PCG](https://www.pcg-random.org). Shrinking is simply continuing this sequence but skipping any that have a `Size` equal or greater than the current lowest failing Size. Shrinking is integrated and composable.

This has some quite different properties to other PBT libraries. The seed is of the shrunk case itself so is more easily reproduced and shrinking can be continued later on a local machine say for as long as wanted.

## Implemented Challenges

[ShrinkingChallengeTests.cs](/pbt-libraries/cscheck/ShrinkingChallengeTests.cs)

|Challenge|Report|
|---------|------|
|[bound5](/challenges/bound5.md)|[bound5.md](/pbt-libraries/cscheck/reports/bound5.md)|
|[large union list](/challenges/large_union_list.md)|[large_union_list.md](/pbt-libraries/cscheck/reports/large_union_list.md)|
|[reverse](/challenges/reverse.md)|[reverse.md](/pbt-libraries/cscheck/reports/reverse.md)|
|[calculator](/challenges/calculator.md)|[calculator.md](/pbt-libraries/cscheck/reports/calculator.md)|
|[length list](/challenges/lengthlist.md)|[lengthlist.md](/pbt-libraries/cscheck/reports/lengthlist.md)|
|[difference](/challenges/difference.md)|[difference_must_not_be_zero.md](/pbt-libraries/cscheck/reports/difference_must_not_be_zero.md)|
|         |[difference_must_not_be_one.md](/pbt-libraries/cscheck/reports/difference_must_not_be_one.md)|
|         |[difference_must_not_be_small.md](/pbt-libraries/cscheck/reports/difference_must_not_be_small.md)|
|[binheap](/challenges/binheap.md)|[binheap.md](/pbt-libraries/cscheck/reports/binheap.md)|
|[coupling](/challenges/coupling.md)|[coupling.md](/pbt-libraries/cscheck/reports/coupling.md)|
|[deletion](/challenges/deletion.md)|[deletion.md](/pbt-libraries/cscheck/reports/deletion.md)|
|[distinct](/challenges/distinct.md)|[distinct.md](/pbt-libraries/cscheck/reports/distinct.md)|
|[nestedlists](/challenges/nestedlists.md)|[nestedlists.md](/pbt-libraries/cscheck/reports/nestedlists.md)|

## Running examples

Default 100 iterations:
```powershell
dotnet test -c Release --filter ShrinkingChallendgeTests
```

For 1 minute:
```powershell
$env:CsCheck_Time=60; dotnet test -c Release --filter ShrinkingChallendgeTests; rm env:CsCheck*
```

Or each test individually:
```powershell
dotnet test -c Release --filter ShrinkingChallendgeTests.No1_Bound5
```
