# Hypothesis

[Hypothesis](https://hypothesis.works/) is a property-based library for Python.
It's implemented as a standalone library and can be used with most Python testing frameworks.

## Hypothesis's Shrinking Approach

Hypothesis adopts an approach called *internal test-case reduction*, which does shrinking by manipulating the behaviour of the generation process rather than attempting to modify the generated value.

This approach is described in [an ECOOP paper about the Hypothesis reducer](https://drmaciver.github.io/papers/reduction-via-generation-preview.pdf), and is a form of [integrated shrinking](https://hypothesis.works/articles/integrated-shrinking/) which ensures by construction that all constraints from value generation also hold in shrinking.

## Implemented Challenges

- [bound5](/pbt-libraries/hypothesis/challenges/bound5.py)
