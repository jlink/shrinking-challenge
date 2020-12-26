# Report for FsCheck Shrinking on "Bound5"

Results here obtained with FsCheck 2.14.3.

## Normalization

FsCheck does not settle on a single value in every run.

Anecdotally, results similar to this are most frequent:

```fsharp
Falsifiable, after 9 tests (5 shrinks) (StdGen (456414203, 296834014)):
Original:
([||], [|DoNotSize -20856s|], [||], [|DoNotSize -20334s|], [||])
Shrunk:
([||], [|DoNotSize -12435s|], [||], [|DoNotSize -20334s|], [||])
```

Worse is possible:

```fsharp
Falsifiable, after 10 tests (102 shrinks) (StdGen (1290357258, 296834008)):
Original:
([|DoNotSize 10501s; DoNotSize -22489s; DoNotSize 11158s|],
 [|DoNotSize 6823s; DoNotSize 19736s; DoNotSize -29537s; DoNotSize -7259s;
   DoNotSize 245s|],
 [|DoNotSize -16402s; DoNotSize 19977s; DoNotSize 23313s; DoNotSize 27809s|],
 [||], [|DoNotSize -28934s; DoNotSize -23177s; DoNotSize 20261s|])
Shrunk:
([||], [|DoNotSize 19736s; DoNotSize 13032s|],
 [|DoNotSize 23313s; DoNotSize 10480s|], [||],
 [|DoNotSize -20006s; DoNotSize 20261s|])
 ```

 As well as:

```fsharp
 Falsifiable, after 9 tests (49 shrinks) (StdGen (1612284002, 296834009)):
Original:
([|DoNotSize -28612s; DoNotSize 12555s|], [||], [||], [|DoNotSize -4070s|],
 [|DoNotSize 28873s; DoNotSize 22507s|])
Shrunk:
([||], [||], [||], [|DoNotSize -1s|], [|DoNotSize 28873s; DoNotSize 3895s|])
```
