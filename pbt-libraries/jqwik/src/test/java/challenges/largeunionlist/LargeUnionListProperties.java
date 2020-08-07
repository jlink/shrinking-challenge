package challenges.largeunionlist;

import java.util.*;

import challenges.*;

import net.jqwik.api.*;
import net.jqwik.api.lifecycle.*;

import static org.assertj.core.api.Assertions.*;

@Label("Large Union List")
@AddLifecycleHook(CountEvaluations.class)
class LargeUnionListProperties {

	@Property
	void test(@ForAll List<List<Integer>> ls) {
		Set<Integer> allElements = new HashSet<>();
		for (List<Integer> x : ls) {
			allElements.addAll(x);
		}
		assertThat(allElements.size()).isLessThan(5);
	}

}