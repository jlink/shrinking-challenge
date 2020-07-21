# The Shrinking Challenge

One of the major aspects in which different property-based testing libraries differ
is their approach towards shrinking. In this repository I try to collect
concrete examples (challenges) for shrinking together with implementations
in different frameworks so that one can compare and get a feel for
weaknesses and strengths.

## Contributing

If you want to contribute
- New challenges
- New framework implementations
- More information about shrinking and its different aspects

...feel free to add a pull request!


## What is Shrinking?

_tbd_

## Different Shrinking Approaches

_tbd_

## Challenges

The current challenges were stolen from 
[this repository](https://github.com/mc-imperial/hypothesis-ecoop-2020-artifact/tree/master/smartcheck-benchmarks),
which contains the code and data relevant to 
[this paper](https://drmaciver.github.io/papers/reduction-via-generation-preview.pdf).

- [bound5](/challenges/bound5.md)

- [large union list](/challenges/large_union_list.md)

- [reverse](/challenges/reverse.md)

- [calculator](/challenges/calculator.md)


## PBT Libraries and Frameworks

- [jqwik](/pbt-libraries/jqwik/README.md)
- [hypothesis](/pbt-libraries/hypothesis/README.md)
