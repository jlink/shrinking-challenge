module Challenge exposing (Challenge)

import Fuzz exposing (Fuzzer)


type alias Challenge a =
    { label : String
    , fuzzer : Fuzzer a
    , test : a -> Bool
    }
