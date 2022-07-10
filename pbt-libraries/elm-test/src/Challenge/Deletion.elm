module Challenge.Deletion exposing (deletion)

import Challenge exposing (Challenge)
import Fuzz
import Test exposing (Test)


deletion : Challenge ( List Int, Int )
deletion =
    { label = "deletion"
    , fuzzer =
        Fuzz.listOfLengthBetween 1 100 Fuzz.int
            |> Fuzz.andThen
                (\list ->
                    Fuzz.pair
                        (Fuzz.constant list)
                        (Fuzz.oneOfValues list)
                )
    , test = \( list, el ) -> not (List.member el (removeFirst el list))
    }


removeFirst : a -> List a -> List a
removeFirst badX xs =
    go badX xs [] xs


go : a -> List a -> List a -> List a -> List a
go badX next prev orig =
    case next of
        [] ->
            orig

        x :: rest ->
            if x == badX then
                List.reverse prev ++ rest

            else
                go badX rest (x :: prev) orig
