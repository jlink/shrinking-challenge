port module Main exposing (main)

import Challenge exposing (Challenge)
import Challenge.BinHeap
import Challenge.Bound5
import Challenge.Calculator
import Challenge.Coupling
import Challenge.Deletion
import Challenge.Difference1
import Challenge.Difference2
import Challenge.Difference3
import Challenge.Distinct
import Challenge.LargeUnionList
import Challenge.LengthList
import Challenge.NestedLists
import Challenge.Reverse
import Expect exposing (Expectation)
import Fuzz exposing (Fuzzer)
import Json.Encode
import Random
import Report exposing (RawReport)
import Set exposing (Set)
import Test.Runner exposing (Simplifiable)


runChallenges : Flags -> List RawReport
runChallenges flags =
    [ run flags Challenge.BinHeap.binHeap
    , run flags Challenge.Bound5.bound5
    , run flags Challenge.Calculator.calculator
    , run flags Challenge.Coupling.coupling
    , run flags Challenge.Deletion.deletion
    , run flags Challenge.Difference1.difference1
    , run flags Challenge.Difference2.difference2
    , run flags Challenge.Difference3.difference3
    , run flags Challenge.Distinct.distinct
    , run flags Challenge.LargeUnionList.largeUnionList
    , run flags Challenge.LengthList.lengthList
    , run flags Challenge.NestedLists.nestedLists
    , run flags Challenge.Reverse.reverse
    ]



---------------


main : Program Flags Model Msg
main =
    Platform.worker
        { init = init
        , update = \_ m -> ( m, Cmd.none )
        , subscriptions = \_ -> Sub.none
        }


port writeFile : { filename : String, contents : String } -> Cmd msg


type alias Flags =
    { initialSeed : Int
    , runs : Int
    }


type alias Model =
    ()


type alias Msg =
    Never



---------------


init : Flags -> ( Model, Cmd Msg )
init flags =
    let
        _ =
            Debug.log "Running with seed" flags.initialSeed
    in
    let
        reports : List RawReport
        reports =
            runChallenges flags

        outputReport : RawReport -> List (Cmd Msg)
        outputReport report =
            [ writeFile
                { filename = "reports/" ++ report.label ++ ".json"
                , contents =
                    report
                        |> Report.encode
                        |> Json.Encode.encode 2
                }
            , writeFile
                { filename = "reports/" ++ report.label ++ ".md"
                , contents =
                    report
                        |> Report.process
                        |> Report.toMarkdown report.label
                }
            ]
    in
    ( ()
    , reports
        |> List.concatMap outputReport
        |> Cmd.batch
    )



---------------


run : Flags -> Challenge a -> RawReport
run flags challenge =
    let
        _ =
            Debug.log "Running challenge" challenge.label
    in
    let
        seeds : List Int
        seeds =
            Random.step
                (Random.list flags.runs
                    (Random.int Random.minInt Random.maxInt)
                )
                (Random.initialSeed flags.initialSeed)
                |> Tuple.first
    in
    { label = challenge.label
    , runs =
        seeds
            |> List.map
                (\seed ->
                    let
                        fuzzedFailingValue : ( a, Simplifiable a )
                        fuzzedFailingValue =
                            generateUntilFail (Random.initialSeed seed) challenge

                        originalValue : a
                        originalValue =
                            Tuple.first fuzzedFailingValue

                        ( evaluations, shrunkValue ) =
                            shrink challenge fuzzedFailingValue
                    in
                    { evaluations = evaluations
                    , seed = seed
                    , originalValue = Debug.toString originalValue
                    , shrunkValue = Debug.toString shrunkValue
                    }
                )
    }


generateUntilFail : Random.Seed -> Challenge a -> ( a, Simplifiable a )
generateUntilFail seed challenge =
    let
        ( result, newSeed ) =
            Random.step (Test.Runner.fuzz challenge.fuzzer) seed
    in
    case result of
        Ok ( value, simplifiable ) ->
            if challenge.test value then
                -- yay for infinite recursion...
                generateUntilFail newSeed challenge

            else
                ( value, simplifiable )

        Err _ ->
            -- yay for infinite recursion...
            generateUntilFail newSeed challenge


shrink : Challenge a -> ( a, Simplifiable a ) -> ( Int, a )
shrink challenge ( value, simplifiable ) =
    case Test.Runner.simplify (toExpectation challenge.test) ( value, simplifiable ) of
        Nothing ->
            ( 0, value )

        Just ( newValue, _, evaluations ) ->
            ( evaluations, newValue )


toExpectation : (a -> Bool) -> (a -> Expectation)
toExpectation predicate =
    \value ->
        predicate value
            |> Expect.equal True
