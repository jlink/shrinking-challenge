#r "nuget: Hedgehog, 2.0.3"

open Hedgehog.FSharp

let lists0To1000 =
  gen {
    let! length = Gen.int32 (Range.linear 1 100)

    return!
      Gen.sequenceList
        [
          for _ = 1 to length do
            Gen.int32 (Range.linear 0 1000)
        ]
  }

let report =
  property {
    let! xs = lists0To1000

    return List.sum xs < 900
  }
  |> Property.renderBool

printfn $"%s{report}"
