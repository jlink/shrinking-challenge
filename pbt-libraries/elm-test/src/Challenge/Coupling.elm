module Challenge.Coupling exposing (coupling)

import Challenge exposing (Challenge)
import Fuzz
import Test exposing (Test)


coupling : Challenge (List Int)
coupling =
    { label = "coupling"
    , fuzzer =
        Fuzz.list (Fuzz.intRange 0 10)
            |> Fuzz.filter
                (\l ->
                    let
                        length =
                            List.length l
                    in
                    List.all (\i -> i < length) l
                )
    , test =
        \list ->
            list
                |> List.indexedMap
                    (\i x ->
                        if i /= x then
                            getAt x list /= Just i

                        else
                            True
                    )
                |> List.all identity
    }


getAt : Int -> List a -> Maybe a
getAt index list =
    if index < 0 then
        Nothing

    else
        list
            |> List.drop index
            |> List.head
