# Report for elm-test shrinking on "calculator"

This report was generated with elm-test 2.0.0

## Normalization

elm-test currently normalizes this example to:

* ``Add (Int 0) (Add (Int 0) (Add (Int 0) (Div (Int 0) (Add (Int 0) (Int 0)))))``
* ``Div (Int 0) (Add (Int 0) (Int 0))``
* ``Div (Int 0) (Div (Int 0) (Int 1))``

## Performance

Over 100 runs, elm-test performed between 174 and 2399 evaluations during each run's shrinking, with a mean cost of 1286.5.
