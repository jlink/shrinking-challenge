import warnings

import numpy as np

import hypothesis.extra.numpy as nps
import hypothesis.strategies as st
from hypothesis import given

int16s = nps.from_dtype(np.dtype("int16"))


bounded_lists = st.lists(int16s, max_size=1).filter(lambda x: sum(x) < 256)


problems = st.tuples(
    bounded_lists, bounded_lists, bounded_lists, bounded_lists, bounded_lists,
)


@given(problems)
def test(p):
    with warnings.catch_warnings():
        warnings.simplefilter("ignore")
        assert sum([x for sub in p for x in sub], np.int16(0)) < 5 * 256
