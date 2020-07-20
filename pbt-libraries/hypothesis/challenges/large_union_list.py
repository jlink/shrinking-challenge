from hypothesis import given
from hypothesis import strategies as st


@given(st.lists(st.lists(st.integers())))
def test(ls):
    all_elements = set()
    for x in ls:
        all_elements.update(x)

    assert len(all_elements) < 5
