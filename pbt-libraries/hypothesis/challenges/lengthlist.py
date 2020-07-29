import hypothesis.strategies as st
from hypothesis import given


@given(st.integers(1, 100).flatmap(lambda n: st.lists(st.integers(0, 1000), min_size=n, max_size=n)))
def test(ls):
    assert max(ls) < 900
