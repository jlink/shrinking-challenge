package challenges.coupling;

import java.util.*;

import challenges.*;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import net.jqwik.api.lifecycle.*;

import static org.assertj.core.api.Assertions.*;

@AddLifecycleHook(ShrinkingStatistics.class)
public class CouplingProperties {

	@Label("coupling")
	@Property
	void test(@ForAll List<@IntRange(min = 0, max = 10) Integer> ls) {
		Assume.that(
				ls.stream().allMatch(v -> v < ls.size())
		);
		for (int i = 0; i < ls.size(); i++) {
			int j = ls.get(i);
			if (i != j) {
				assertThat(ls.get(j)).isNotEqualTo(i);
			}
		}
	}

}
