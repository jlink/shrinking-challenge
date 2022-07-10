module Report exposing
    ( RawReport
    , Report
    , Run
    , encode
    , process
    , toMarkdown
    )

import Json.Encode
import Set exposing (Set)


type alias RawReport =
    { label : String
    , runs : List Run
    }


type alias Run =
    { evaluations : Int
    , seed : Int
    , originalValue : String
    , shrunkValue : String
    }


type alias Report =
    { shrunkValues : Set String
    , runs : Int
    , minEvaluations : Int
    , maxEvaluations : Int
    }


process : RawReport -> Report
process rawReport =
    let
        shrunkValues : Set String
        shrunkValues =
            rawReport.runs
                |> List.map .shrunkValue
                |> Set.fromList

        evaluations : List Int
        evaluations =
            List.map .evaluations rawReport.runs

        minEvaluations : Int
        minEvaluations =
            List.minimum evaluations
                |> Maybe.withDefault 0

        maxEvaluations : Int
        maxEvaluations =
            List.maximum evaluations
                |> Maybe.withDefault 0
    in
    { shrunkValues = shrunkValues
    , runs = List.length rawReport.runs
    , minEvaluations = minEvaluations
    , maxEvaluations = maxEvaluations
    }


toMarkdown : String -> Report -> String
toMarkdown label report =
    let
        values : String
        values =
            report.shrunkValues
                |> Set.toList
                |> List.map (\val -> "* ``" ++ val ++ "``")
                |> String.join "\n"

        runs : String
        runs =
            String.fromInt report.runs

        evaluations : String
        evaluations =
            if report.minEvaluations /= report.maxEvaluations then
                "between "
                    ++ String.fromInt report.minEvaluations
                    ++ " and "
                    ++ String.fromInt report.maxEvaluations
                    ++ " evaluations during each run's shrinking, with a mean cost of "
                    ++ String.fromFloat (toFloat (report.minEvaluations + report.maxEvaluations) / 2)

            else
                String.fromInt report.minEvaluations
                    ++ " evaluations during each run's shrinking"
    in
    """# Report for elm-test shrinking on "{LABEL}"

This report was generated with elm-test 2.0.0

## Normalization

elm-test currently normalizes this example to:

{VALUES}

## Performance

Over {RUNS} runs, elm-test performed {EVALUATIONS}.
"""
        |> String.replace "{LABEL}" label
        |> String.replace "{VALUES}" values
        |> String.replace "{RUNS}" runs
        |> String.replace "{EVALUATIONS}" evaluations


encode : RawReport -> Json.Encode.Value
encode rawReport =
    Json.Encode.list encodeRun rawReport.runs


encodeRun : Run -> Json.Encode.Value
encodeRun run =
    Json.Encode.object
        [ ( "evaluations", Json.Encode.int run.evaluations )
        , ( "seed", Json.Encode.int run.seed )
        , ( "original", Json.Encode.string run.originalValue )
        , ( "shrunk", Json.Encode.string run.shrunkValue )
        ]
