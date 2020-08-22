package challenges.nestedlists;

import java.util.*;

import challenges.*;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import net.jqwik.api.lifecycle.*;

import static org.assertj.core.api.Assertions.*;

@AddLifecycleHook(ShrinkingStatistics.class)
@PropertyDefaults(shrinking = ShrinkingMode.FULL, afterFailure = AfterFailureMode.RANDOM_SEED)
public class NestedListsProperties {

	@Label("nestedlists")
	@Property
	void test(@ForAll List<List<@IntRange(min = 0, max = 0) Integer>> ls) {
		int sum = ls.stream().mapToInt(List::size).sum();
		assertThat(sum).isLessThanOrEqualTo(10);
	}

}
