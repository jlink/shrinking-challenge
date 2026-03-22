#r "nuget: Hedgehog, 2.0.3"

open Hedgehog.FSharp

let report =
  property {
    let! xs = Gen.auto<int list>

    return xs = List.rev xs
  }
  |> Property.renderBool

printfn $"%s{report}"
