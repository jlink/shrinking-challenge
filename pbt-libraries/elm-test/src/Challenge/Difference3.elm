module Challenge.Difference3 exposing (difference3)

import Challenge exposing (Challenge)
import Fuzz
import Test exposing (Test)


difference3 : Challenge ( Int, Int )
difference3 =
    { label = "difference3"
    , fuzzer =
        Fuzz.pair
            (Fuzz.intAtLeast 0)
            (Fuzz.intAtLeast 0)
    , test = \( x, y ) -> x < 10 || abs (x - y) /= 1
    }
