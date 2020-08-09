package challenges.bound5;

import java.util.*;

import challenges.ShrinkingStatistics;
import net.jqwik.api.*;
import net.jqwik.api.arbitraries.ListArbitrary;
import net.jqwik.api.lifecycle.AddLifecycleHook;

@AddLifecycleHook(ShrinkingStatistics.class)
public class Bound5Properties {

	@Label("bound5")
	@Property(shrinking = ShrinkingMode.FULL, afterFailure = AfterFailureMode.RANDOM_SEED)
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