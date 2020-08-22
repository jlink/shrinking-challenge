package challenges.distinct;

import java.util.*;

import challenges.*;

import net.jqwik.api.*;
import net.jqwik.api.lifecycle.*;

import static org.assertj.core.api.Assertions.*;

@AddLifecycleHook(ShrinkingStatistics.class)
@PropertyDefaults(shrinking = ShrinkingMode.FULL, afterFailure = AfterFailureMode.RANDOM_SEED)
public class DistinctProperties {

	@Label("distinct")
	@Property
	void testListHasFewDistinct(@ForAll List<Integer> ls) {
		assertThat(new HashSet<>(ls)).hasSizeLessThan(3);
	}

}
