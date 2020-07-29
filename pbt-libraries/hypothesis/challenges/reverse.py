import hypothesis.strategies as st
from hypothesis import given


@given(st.lists(st.integers()))
def test(ls):
    rev = list(reversed(ls))
    assert ls == rev
