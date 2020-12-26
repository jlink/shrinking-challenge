#r "nuget: FsCheck"

open FsCheck

let largeUnionList (l:array<array<int>>) =
    let s = l |> Array.map set |> Array.fold Set.union Set.empty
    Set.count s < 5

Check.Quick largeUnionList