module Challenge.Reverse exposing (reverse)

import Challenge exposing (Challenge)
import Fuzz
import Test exposing (Test)


reverse : Challenge (List Int)
reverse =
    { label = "reverse"
    , fuzzer = Fuzz.list Fuzz.int
    , test = \list -> list == List.reverse list
    }
