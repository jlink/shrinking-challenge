# Report for PropEr Shrinking on "lengthlist"

This report was generated with PropEr's master branch on 24/8/2020
[commit](https://github.com/proper-testing/proper/commit/8bed46993a3bd908ba9631ee8699071a2c0f0aa0).

## Shrinking

PropEr shrinks this example to ``[900]`` (most of the time) but also to
- ``[0,900]``
- ``[900,0]``
- ``[900,0,0]``
- ``[0,900,0]``
- ``[0,0,900]``
- ``[900,0,0,0]``
- ``[0,0,0,900]``
- ``[0,900,0,0,0]``
- ``[0,0,900,0,0]``
- ``[0,0,0,900,0]``
- ``[0,900,0,0,0,0]``
- ``[0,0,0,0,0,0,900]``

## Performance

Over 100 runs, PropEr found a counterexample after 1 or 2 tests only,
and performed between 2 and 18 shrinking attempts.

See the [report of the run](lengthlist.report) for more information.
