module Challenge.Calculator exposing (calculator)

import Challenge exposing (Challenge)
import Fuzz exposing (Fuzzer)
import Test exposing (Test)


calculator : Challenge CalcExpr
calculator =
    { label = "calculator"
    , fuzzer = exprFuzzer 5 |> Fuzz.filter noDivisionByLiteralZero
    , test = \expr -> eval expr /= Nothing
    }


type CalcExpr
    = Int Int
    | Add CalcExpr CalcExpr
    | Div CalcExpr CalcExpr


exprFuzzer : Int -> Fuzzer CalcExpr
exprFuzzer maxDepth =
    if maxDepth <= 0 then
        Fuzz.map Int Fuzz.int

    else
        let
            subExprFuzzer =
                exprFuzzer (maxDepth - 1)
        in
        Fuzz.oneOf
            [ Fuzz.map Int Fuzz.int
            , Fuzz.map2 Add subExprFuzzer subExprFuzzer
            , Fuzz.map2 Div subExprFuzzer subExprFuzzer
            ]


noDivisionByLiteralZero : CalcExpr -> Bool
noDivisionByLiteralZero expr =
    case expr of
        Div _ (Int 0) ->
            False

        Int _ ->
            True

        Add a b ->
            noDivisionByLiteralZero a
                && noDivisionByLiteralZero b

        Div a b ->
            noDivisionByLiteralZero a
                && noDivisionByLiteralZero b


eval : CalcExpr -> Maybe Int
eval expr =
    case expr of
        Int i ->
            Just i

        Add a b ->
            Maybe.map2 (+)
                (eval a)
                (eval b)

        Div a b ->
            Maybe.map2
                (\a_ b_ ->
                    if b_ == 0 then
                        Nothing

                    else
                        Just <| a_ // b_
                )
                (eval a)
                (eval b)
                |> Maybe.andThen identity
