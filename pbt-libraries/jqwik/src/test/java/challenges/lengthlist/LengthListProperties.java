package challenges.lengthlist;

import java.util.*;

import challenges.*;
import org.assertj.core.api.*;

import net.jqwik.api.*;
import net.jqwik.api.lifecycle.*;

import static org.assertj.core.api.Assertions.*;

@Label("LengthList")
@AddLifecycleHook(CountEvaluations.class)
class LengthListProperties {

	@Property
	@Report(Reporting.GENERATED)
	void test(@ForAll("listOfIntegers") List<Integer> ls) {
		int max = ls.stream().mapToInt(i -> i).max().orElse(0);
		Assertions.assertThat(max).isLessThan(900);
	}

	@Provide
	Arbitrary<List<Integer>> listOfIntegers() {
		return Arbitraries.integers().between(1, 100)
						  .flatMap(size -> Arbitraries.integers().between(0, 1000).list().ofSize(size));
	}

}

// import hypothesis.strategies as st
// from hypothesis import given
//
//
// @given(st.integers(1, 100).flatmap(lambda n: st.lists(st.integers(0, 1000), min_size=n, max_size=n)))
// def test(ls):
//     assert max(ls) < 900
