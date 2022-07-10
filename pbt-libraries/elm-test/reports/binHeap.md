# Report for elm-test shrinking on "binHeap"

This report was generated with elm-test 2.0.0

## Normalization

elm-test currently normalizes this example to:

* ``Heap 0 (Just (Heap -1 Nothing Nothing)) Nothing``
* ``Heap 0 Nothing (Just (Heap -1 Nothing Nothing))``
* ``Heap 1 Nothing (Just (Heap 0 Nothing Nothing))``

## Performance

Over 100 runs, elm-test performed between 109 and 2265 evaluations during each run's shrinking, with a mean cost of 1187.
