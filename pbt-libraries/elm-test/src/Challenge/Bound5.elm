module Challenge.Bound5 exposing (bound5)

import Challenge exposing (Challenge)
import Fuzz exposing (Fuzzer)
import Test exposing (Test)


bound5 : Challenge (List (List Int))
bound5 =
    { label = "bound5"
    , fuzzer = Fuzz.listOfLength 5 smallInt16ListFuzzer
    , test = \lists -> sum (List.concat lists) < (5 * 256)
    }


type Int16
    = Int16 Int


int16Fuzzer : Fuzzer Int
int16Fuzzer =
    Fuzz.intRange -32768 32767


smallInt16ListFuzzer : Fuzzer (List Int)
smallInt16ListFuzzer =
    Fuzz.list int16Fuzzer
        |> Fuzz.filter (\list -> sum list < 256)


normalize : Int -> Int
normalize n =
    n
        |> underflow
        |> overflow


fromInt : Int -> Int16
fromInt n =
    Int16 (normalize n)


toInt : Int16 -> Int
toInt (Int16 n) =
    n


sum : List Int -> Int
sum list =
    list
        |> List.map fromInt
        |> List.foldl add (Int16 0)
        |> toInt


add : Int16 -> Int16 -> Int16
add (Int16 a) (Int16 b) =
    fromInt (a + b)


overflow : Int -> Int
overflow n =
    if n > 32767 then
        overflow (n - 65536)

    else
        n


underflow : Int -> Int
underflow n =
    if n < -32768 then
        underflow (n + 65536)

    else
        n
