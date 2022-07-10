module Challenge.LargeUnionList exposing (largeUnionList)

import Challenge exposing (Challenge)
import Fuzz
import Set
import Test exposing (Test)


largeUnionList : Challenge (List (List Int))
largeUnionList =
    { label = "largeUnionList"
    , fuzzer = Fuzz.list (Fuzz.list Fuzz.int)
    , test = \lists -> Set.size (Set.fromList (List.concat lists)) <= 4
    }
