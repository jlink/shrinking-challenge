# Report for PropEr Shrinking on "distinct"

This report was generated with PropEr's master branch on 26/8/2020
[commit](https://github.com/proper-testing/proper/commit/8bed46993a3bd908ba9631ee8699071a2c0f0aa0).

## Shrinking

PropEr shrinks this example to a list containing two (more than 85% of the cases) or occasionally one or three inner lists, whose elements are in the range [-4,4].

Some actual examples of these lists are shown below:
1. ``[[2,0,1,-1,-2]]`` (shrunk from ``[[-4],[5,0,1,-3,-8]]``)
2. ``[[0,1,-1],[-2,-3]]`` (shrunk from ``[[0,2,-9],[-2,-4],[-9,-2,0]]``)
3. ``[[0,-1],[-2,1],[2]]`` (shrunk from ``[[5,-2],[-5,1],[2]]``)

### Analysis

PropEr will _never_ increase the length of a list during shrinking.
So its only chance to shrink the counterexample to a single inner list is when the counterexample that it finds to violate the property contains an inner list of length 5 or more, as in case 1 above.

How shrinking works in the other two cases can be understood by taking into consideration that positive integers shrink ("decrease") towards 0 and negative integers "grow" towards 0.
For example, in case 2 above, the first integer (``0``) is already shrunk, ``2`` tries to decrease towards 0 but that number is already taken so it stops at ``1``, ``-9`` grows to ``-1``, ``-2`` cannot grow to -1 or 0 because these numbers are taken so it remains ``-2`` and finally ``-4`` becomes ``-3``.
A similar reasoning explains the last case.

## Performance

Over 100 runs, PropEr found a counterexample after 7 to 16 tests,
and performed between 1 and 9 shrinking attempts.

See the [report of the run](distinct.report) for more information.
