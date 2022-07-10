module Challenge.Difference1 exposing (difference1)

import Challenge exposing (Challenge)
import Fuzz
import Test exposing (Test)


difference1 : Challenge ( Int, Int )
difference1 =
    { label = "difference1"
    , fuzzer =
        Fuzz.pair
            (Fuzz.intAtLeast 0)
            (Fuzz.intAtLeast 0)
    , test = \( x, y ) -> x < 10 || x /= y
    }
