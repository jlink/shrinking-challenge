module Challenge.LengthList exposing (lengthList)

import Challenge exposing (Challenge)
import Fuzz
import Test exposing (Test)


lengthList : Challenge (List Int)
lengthList =
    { label = "lengthList"
    , fuzzer =
        Fuzz.intRange 1 100
            |> Fuzz.andThen
                (\len -> Fuzz.listOfLength len (Fuzz.intRange 0 1000))
    , test =
        \list ->
            case List.maximum list of
                Nothing ->
                    Debug.todo "shouldn't have generated an empty list"

                Just max ->
                    max < 900
    }
