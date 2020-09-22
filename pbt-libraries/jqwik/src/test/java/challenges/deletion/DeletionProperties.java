package challenges.deletion;

import java.util.*;

import challenges.*;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import net.jqwik.api.lifecycle.*;

import static org.assertj.core.api.Assertions.*;

@AddLifecycleHook(ShrinkingStatistics.class)
public class DeletionProperties {

	@Label("deletion")
	@Property
	void test(@ForAll List<Integer> ls, @ForAll @IntRange(min = 0, max = 10) int i) {
		Assume.that(i < ls.size());
		Integer x = ls.get(i);

		// jqwik reports the actual used parameters.
		// Without copy it will report the list without the removed element.
		ArrayList<Integer> copy = new ArrayList<>(ls);
		copy.remove(x);

		assertThat(copy).doesNotContain(x);
	}

}
