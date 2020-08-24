# Report for PropEr Shrinking on "calculator"

This report was generated with PropEr's master branch on 24/8/2020
[commit](https://github.com/proper-testing/proper/commit/8bed46993a3bd908ba9631ee8699071a2c0f0aa0).

## Normalization

PropEr shrinks this example to
- ``{d,0,{d,0,1}}`` (most of the time)
- ``{d,0,{d,0,-1}}`` (often) but also to
- ``{d,0,{d,0,{d,0,-1}}}``
- ``{a,0,{d,0,{d,0,1}}}``
- ``{d,0,{a,0,0}}``
- ``{d,0,{a,-1,1}}``
- ``{d,0,{a,1,-1}}``
- ``{d,0,{a,5,-5}}``
- ``{d,0,{a,-6,6}}``
- ``{d,0,{a,3,-3}}``

where the ``a`` tag means addition and ``d`` division.

## Performance

Over 100 runs, PropEr found a counterexample after 7 to 43 tests,
and performed between 1 and 9 shrinking attempts.

See the [report of the run](calculator.report) for more information.
