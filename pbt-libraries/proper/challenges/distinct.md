# Report for PropEr Shrinking on "distinct"

This report was generated with PropEr's master branch on 24/8/2020
[commit](https://github.com/proper-testing/proper/commit/8bed46993a3bd908ba9631ee8699071a2c0f0aa0).

## Shrinking

PropEr shrinks this example to
- ``[-2,0,-1]``
- ``[-1,-2,0]``
- ``[-1,0,-2]``
- ``[-1,0,1]``
- ``[-1,1,0]``
- ``[0,-2,-1]``
- ``[0,-1,-2]``
- ``[0,-1,1]``
- ``[0,1,-2]``
- ``[0,1,-1]``
- ``[0,1,-1,2]`` (this is an odd one... appears once after 1 shrinking attempt)
- ``[0,1,2]``
- ``[0,2,1]``
- ``[1,-1,0]``
- ``[1,0,-1]``
- ``[1,0,2]``
- ``[1,2,0]``
- ``[2,0,1]``
- ``[2,1,0]``

## Performance

Over 100 runs, PropEr found a counterexample after 1 to 10 tests,
and performed between 0 and 4 shrinking attempts.

See the [report of the run](distinct.report) for more information.
