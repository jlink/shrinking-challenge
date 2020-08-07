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

	@Property(shrinking = ShrinkingMode.FULL)
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
				.list()
				.filter(x -> x.stream().mapToInt(s -> s).sum() < 256)
				.list().ofSize(5);
	}

}