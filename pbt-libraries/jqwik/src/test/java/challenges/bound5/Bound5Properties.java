package challenges.bound5;

import java.util.*;
import java.util.stream.*;

import challenges.*;
import org.assertj.core.api.*;

import net.jqwik.api.*;
import net.jqwik.api.arbitraries.*;
import net.jqwik.api.lifecycle.*;

@AddLifecycleHook(ShrinkingStatistics.class)
public class Bound5Properties {

	@Label("bound5")
	@Property
	boolean test(@ForAll("boundedListTuples") List<List<Short>> p) {
		short sum = shortSum(p.stream()
							  .flatMap(Collection::stream)
							  .mapToInt(i -> i));
		return sum < 5 * 256;
	}

	@Provide
	ListArbitrary<List<Short>> boundedListTuples() {
		return Arbitraries.shorts()
						  .list().ofMaxSize(10)
						  .filter(x -> shortSum(x.stream().mapToInt(s -> s)) < 256)
						  .list().ofSize(5);
	}

	private short shortSum(IntStream stream) {
		return (short) stream.reduce(0, (i1, i2) -> (short) i1 + (short) i2);
	}

	// @Example
	void shortSumWorksWithOverflow() {
		List<Short> shorts = new ArrayList<>();
		shorts.add((short) -1);
		shorts.add(Short.MIN_VALUE);
		short sum = shortSum(shorts.stream().mapToInt(i -> i));
		Assertions.assertThat(sum).isEqualTo(Short.MAX_VALUE);
	}

}