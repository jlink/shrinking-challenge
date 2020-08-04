package challenges.bound5;

import java.util.*;

import challenges.CountEvaluations;
import net.jqwik.api.*;
import net.jqwik.api.arbitraries.ListArbitrary;
import net.jqwik.api.lifecycle.AddLifecycleHook;

import static org.assertj.core.api.Assertions.*;

@Label("Bound 5")
@AddLifecycleHook(CountEvaluations.class)
class Bound5Properties {

	@Property(tries = 100, afterFailure = AfterFailureMode.RANDOM_SEED, shrinking = ShrinkingMode.FULL)
	boolean test(@ForAll("boundedListTuples") List<List<Short>> p) {
		short sum = (short) p.stream()
				.flatMap(Collection::stream)
				.mapToInt(i -> i)
				.sum();
		return sum < 5 * 256;
	}

	@Provide
	ListArbitrary<List<Short>> boundedListTuples() {
		return Arbitraries.shorts()
				.list().ofMaxSize(20) // Unrestricted list size can lead to very long shrinking times
				.filter(x -> x.stream().mapToInt(s -> s).sum() < 256)
				.list().ofSize(5);
	}

}

// The relevant python code:
//
//bounded_lists = st.lists(int16s, max_size=1).filter(lambda x: sum(x) < 256)
//
//
//		problems = st.tuples(
//		bounded_lists,
//		bounded_lists,
//		bounded_lists,
//		bounded_lists,
//		bounded_lists,
//		)
//
//
//		if __name__ == '__main__':
//@eval_given(problems)
//    def test(p):
//			assert sum([x for sub in p for x in sub], np.int16(0)) < 5 * 256
