module Challenge.NestedLists exposing (nestedLists)

import Challenge exposing (Challenge)
import Fuzz
import Test exposing (Test)


nestedLists : Challenge (List (List Int))
nestedLists =
    { label = "nestedLists"
    , fuzzer = Fuzz.listOfLengthBetween 0 20 (Fuzz.listOfLengthBetween 0 20 Fuzz.int)
    , test = \lists -> List.sum (List.map List.length lists) <= 10
    }
