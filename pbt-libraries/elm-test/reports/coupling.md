# Report for elm-test shrinking on "coupling"

This report was generated with elm-test 2.0.0

## Normalization

elm-test currently normalizes this example to:

* ``[0,0,0,0,0,0,0,0,9,8]``
* ``[0,0,0,0,0,0,0,8,7]``
* ``[0,0,0,0,0,0,7,6]``
* ``[0,0,0,0,0,6,5]``
* ``[0,0,0,0,5,4]``
* ``[0,0,0,4,3]``
* ``[0,0,3,2]``
* ``[0,2,1]``
* ``[1,0]``

## Performance

Over 100 runs, elm-test performed between 71 and 1610 evaluations during each run's shrinking, with a mean cost of 840.5.
