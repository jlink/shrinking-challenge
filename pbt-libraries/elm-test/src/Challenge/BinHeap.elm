module Challenge.BinHeap exposing (binHeap)

import Challenge exposing (Challenge)
import Fuzz exposing (Fuzzer)
import Test exposing (Test)


type Heap
    = Heap Int (Maybe Heap) (Maybe Heap)


binHeap : Challenge Heap
binHeap =
    { label = "binHeap"
    , fuzzer = heapFuzzer 4
    , test =
        \heap ->
            let
                l1 =
                    toList heap

                l2 =
                    wrongToSortedList heap
            in
            (l2 == List.sort l2) && (List.sort l1 == l2)
    }


heapFuzzer : Int -> Fuzzer Heap
heapFuzzer depth =
    if depth <= 0 then
        Fuzz.map (\i -> Heap i Nothing Nothing) Fuzz.int

    else
        Fuzz.map3 Heap
            Fuzz.int
            (Fuzz.maybe (heapFuzzer (depth - 1)))
            (Fuzz.maybe (heapFuzzer (depth - 1)))


toList : Heap -> List Int
toList heap =
    let
        go : List Int -> List Heap -> List Int
        go acc stack =
            case stack of
                [] ->
                    List.reverse acc

                (Heap n left right) :: hs ->
                    go
                        (n :: acc)
                        (List.filterMap identity [ left, right ]
                            ++ hs
                        )
    in
    go [] [ heap ]


wrongToSortedList : Heap -> List Int
wrongToSortedList (Heap n left right) =
    n
        :: (mergeHeaps left right
                |> Maybe.map toList
                |> Maybe.withDefault []
           )


mergeHeaps : Maybe Heap -> Maybe Heap -> Maybe Heap
mergeHeaps left right =
    case ( left, right ) of
        ( Nothing, _ ) ->
            right

        ( _, Nothing ) ->
            left

        ( Just (Heap ln lleft lright), Just (Heap rn rleft rright) ) ->
            Just <|
                if ln <= rn then
                    Heap ln (mergeHeaps lright right) lleft

                else
                    Heap rn (mergeHeaps rright left) rleft
