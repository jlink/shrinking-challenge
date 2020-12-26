#r "nuget: FsCheck"

open FsCheck

// Array.sum does checked arithmetic, so a quick hack:
let uncheckedSum = Array.fold (Operators.(+)) 0s

let bound5 (l1,l2,l3,l4,l5) =
    let arrays = [l1;l2;l3;l4;l5] |> List.map (Array.map DoNotSize.Unwrap)
    arrays |> List.forall (fun l -> uncheckedSum l < 256s) ==> ((Array.concat arrays |> uncheckedSum) < 5s * 256s)

Check.Quick bound5