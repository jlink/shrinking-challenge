#r "nuget: FsCheck"

open FsCheck

let reverse (l:list<int>) = List.rev l = l

Check.Quick reverse