module Challenge.Distinct exposing (distinct)

import Challenge exposing (Challenge)
import Fuzz
import Set
import Test exposing (Test)


distinct : Challenge (List Int)
distinct =
    { label = "distinct"
    , fuzzer = Fuzz.list Fuzz.int
    , test = \list -> Set.size (Set.fromList list) < 3
    }
