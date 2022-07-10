# elm-test

[elm-test](https://github.com/elm-explorations/test) is an unit testing /
property-based testing library for the Elm language.

## elm-test's Shrinking Approach

Since version 2.0.0 elm-test uses the "internal shrinking" approach popularized
by Hypothesis: instead of shrinking the generated values it shrinks the
underlying "random dice rolls" stream and tries to generate values from scratch
from these simplified random values.

For a very approachable intro look at the
[minithesis](https://github.com/DRMacIver/minithesis) repository, which
implements this very core idea of Hypothesis.

## Implemented Challenges

|Challenge|Code|Report|
|---------|----|------|
|[binheap](/challenges/binheap.md)|[BinHeap.elm](/pbt-libraries/elm-test/src/Challenge/BinHeap.elm)|[binHeap.md](/pbt-libraries/elm-test/reports/binHeap.md)|
|[bound5](/challenges/bound5.md)|[Bound5.elm](/pbt-libraries/elm-test/src/Challenge/Bound5.elm)|[bound5.md](/pbt-libraries/elm-test/reports/bound5.md)|
|[calculator](/challenges/calculator.md)|[Calculator.elm](/pbt-libraries/elm-test/src/Challenge/Calculator.elm)|[calculator.md](/pbt-libraries/elm-test/reports/calculator.md)|
|[coupling](/challenges/coupling.md)|[Coupling.elm](/pbt-libraries/elm-test/src/Challenge/Coupling.elm)|[coupling.md](/pbt-libraries/elm-test/reports/coupling.md)|
|[deletion](/challenges/deletion.md)|[Deletion.elm](/pbt-libraries/elm-test/src/Challenge/Deletion.elm)|[deletion.md](/pbt-libraries/elm-test/reports/deletion.md)|
|[difference](/challenges/difference.md)|[Difference1.elm](/pbt-libraries/elm-test/src/Challenge/Difference1.elm)|[difference1.md](/pbt-libraries/elm-test/reports/difference1.md)|
|                                       |[Difference2.elm](/pbt-libraries/elm-test/src/Challenge/Difference2.elm)|[difference2.md](/pbt-libraries/elm-test/reports/difference2.md)|
|                                       |[Difference3.elm](/pbt-libraries/elm-test/src/Challenge/Difference3.elm)|[difference3.md](/pbt-libraries/elm-test/reports/difference3.md)|
|[distinct](/challenges/distinct.md)|[Distinct.elm](/pbt-libraries/elm-test/src/Challenge/Distinct.elm)|[distinct.md](/pbt-libraries/elm-test/reports/distinct.md)|
|[large union list](/challenges/large_union_list.md)|[LargeUnionList.elm](/pbt-libraries/elm-test/src/Challenge/LargeUnionList.elm)|[largeUnionList.md](/pbt-libraries/elm-test/reports/largeUnionList.md)|
|[length list](/challenges/lengthlist.md)|[LengthList.elm](/pbt-libraries/elm-test/src/Challenge/LengthList.elm)|[lengthlist.md](/pbt-libraries/elm-test/reports/lengthList.md)|
|[nestedlists](/challenges/nestedlists.md)|[NestedLists.elm](/pbt-libraries/elm-test/src/Challenge/NestedLists.elm)|[nestedlists.md](/pbt-libraries/elm-test/reports/nestedLists.md)|
|[reverse](/challenges/reverse.md)|[Reverse.elm](/pbt-libraries/elm-test/src/Challenge/Reverse.elm)|[reverse.md](/pbt-libraries/elm-test/reports/reverse.md)|

## Running examples

You need `node` and one of `npm` or `yarn`. With these, run `yarn` and `yarn start`.

Alternatively, you need `elm` and `elm-esm` on the PATH. With these, run `./run.sh`.
