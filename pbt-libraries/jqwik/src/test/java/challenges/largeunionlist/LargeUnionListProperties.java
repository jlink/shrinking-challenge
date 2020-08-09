package challenges.largeunionlist;

import java.util.*;

import challenges.*;

import net.jqwik.api.*;
import net.jqwik.api.lifecycle.*;

import static org.assertj.core.api.Assertions.*;

@AddLifecycleHook(ShrinkingStatistics.class)
public class LargeUnionListProperties {

	@Label("large_union_list")
	@Property(shrinking = ShrinkingMode.FULL, afterFailure = AfterFailureMode.RANDOM_SEED)
	void test(@ForAll List<List<Integer>> ls) {
		Set<Integer> allElements = new HashSet<>();
		for (List<Integer> x : ls) {
			allElements.addAll(x);
		}
		assertThat(allElements.size()).isLessThan(5);
	}

}