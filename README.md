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

The input data and parameters PBT library use to check a property's invariants, 
are fully or partially generated through pseudo-randomization. 
One problem that comes with random generation is the rather loose relation 
between the randomly chosen sample and the problem underlying the failing property.

That's why it is important for PBT tools to try to find a simpler or even 
“the simplest” example that fails for (hopefully) the same reason. 
This searching phase is called shrinking because it starts with the original sample 
and tries to make it smaller and check the property again. The closer the shrunk
sample is to the theoretically smallest one, the easier it is for the developer
to recognize the real reason for a failing property.

Two major difficulties in shrinking are:
- Shrinking means searching in a (very) large space of possibilities. 
  Brute-forcing through all possible samples is usually not an option.
- It is not always obvious what "smallest" means in a given domain or context.

## Different Shrinking Approaches

PBT libraries usually follow one of two approaches:
- Users must define shrinking behaviour together with defining a generator.
  This requires additional effort but also allows for domain-specific, targeted shrinking.
- Shrinking behaviour is automatically derived from a generator's specification.
  This is more convenient for users but may result in worse shrinking results in some cases. 

Another characteristic to differentiate between shrinking approaches is  
[type-based versus integrated shrinking](https://hypothesis.works/articles/integrated-shrinking/).

## Challenges

Some challenges were stolen from 
[this repository](https://github.com/mc-imperial/hypothesis-ecoop-2020-artifact/tree/master/smartcheck-benchmarks),
which contains the code and data relevant to 
[this paper](https://drmaciver.github.io/papers/reduction-via-generation-preview.pdf).

- [bound5](/challenges/bound5.md)

- [large union list](/challenges/large_union_list.md)

- [reverse](/challenges/reverse.md)

- [calculator](/challenges/calculator.md)

- [length list](/challenges/lengthlist.md)

- [difference](/challenges/difference.md)


## PBT Libraries and Frameworks

- [jqwik](/pbt-libraries/jqwik/README.md)
- [hypothesis](/pbt-libraries/hypothesis/README.md)
