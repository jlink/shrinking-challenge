module Challenge.Difference2 exposing (difference2)

import Challenge exposing (Challenge)
import Fuzz
import Test exposing (Test)


difference2 : Challenge ( Int, Int )
difference2 =
    { label = "difference2"
    , fuzzer =
        Fuzz.pair
            (Fuzz.intAtLeast 0)
            (Fuzz.intAtLeast 0)
    , test =
        \( x, y ) ->
            let
                absDiff =
                    abs (x - y)
            in
            x < 10 || absDiff < 1 || absDiff > 4
    }
