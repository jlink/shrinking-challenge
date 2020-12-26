# Report for FsCheck Shrinking on "LargeUnionList"

Results here obtained with FsCheck 2.14.3.

## Normalization

FsCheck does not settle on a single value in every run, since it never joins lists together.

Some example results:

```fsharp
Original:
[|[|2; 0; 0; 0; 0|]; [||]; [||]; [||]; [|-1; 1; -2; 0|]; [||]; [||]|]    
Shrunk:
[|[|2; 0|]; [|-1; 1; -2|]|]
```

```fsharp
Falsifiable, after 10 tests (3 shrinks) (StdGen (1702445285, 296834024)):
Original:
[|[|1|]; [||]; [|-1|]; [||]; [|2|]; [|0; -2|]; [|1|]|]
Shrunk:
[|[|-1|]; [|2|]; [|0; -2|]; [|1|]|]
```

```fsharp
Falsifiable, after 14 tests (16 shrinks) (StdGen (2034894721, 296834024)):
Original:
[|[||]; [||]; [||]; [|0; -1; 1; 0; -4; 0; 0; 0; 5; -1; 0; 0|]; [||]; [|-1|]|]
Shrunk:
[|[|1; 3; 2; -1; 0|]|]
```
