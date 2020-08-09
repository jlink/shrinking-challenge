package challenges.lengthlist;

import java.util.*;

import challenges.*;
import org.assertj.core.api.*;

import net.jqwik.api.*;
import net.jqwik.api.lifecycle.*;

@AddLifecycleHook(ShrinkingStatistics.class)
public class LengthListProperties {

	@Label("lengthlist")
	@Property(shrinking = ShrinkingMode.FULL, afterFailure = AfterFailureMode.RANDOM_SEED)
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