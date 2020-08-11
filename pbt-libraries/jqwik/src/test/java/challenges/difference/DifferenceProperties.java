package challenges.difference;

import challenges.*;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import net.jqwik.api.lifecycle.*;

import static org.assertj.core.api.Assertions.*;

@AddLifecycleHook(ShrinkingStatistics.class)
public class DifferenceProperties {

	@Property(afterFailure = AfterFailureMode.RANDOM_SEED)
	@Label("difference_must_not_be_zero")
	void mustNotBeZero(@ForAll @Positive int first, @ForAll @Positive int second) {
		if (first < 10) {
			return;
		}
		int difference = Math.abs(first - second);
		assertThat(difference).isNotZero();
	}

	@Property(afterFailure = AfterFailureMode.RANDOM_SEED)
	@Label("difference_must_not_be_small")
	void mustNotBeSmall(@ForAll @Positive int first, @ForAll @Positive int second) {
		if (first < 10) {
			return;
		}
		int difference = Math.abs(first - second);
		assertThat(1 > difference || difference > 4).isTrue();
	}

	@Label("difference_must_not_be_one")
	@Property(afterFailure = AfterFailureMode.RANDOM_SEED)
	void mustNotBeOne(@ForAll @Positive int first, @ForAll @Positive int second) {
		if (first < 10) {
			return;
		}
		int difference = Math.abs(first - second);
		assertThat(difference).isNotEqualTo(1);
	}
}
