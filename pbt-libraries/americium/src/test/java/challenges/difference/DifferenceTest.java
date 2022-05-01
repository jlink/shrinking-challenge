package challenges.difference;

import com.google.common.collect.Maps;
import com.sageserpent.americium.java.Trials;
import com.sageserpent.americium.java.TrialsApi;
import com.sageserpent.americium.java.TrialsTest;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferenceTest {

    private final static TrialsApi api = Trials.api();

    private final static int maximumPowerOfTwo = Integer.bitCount(Integer.MAX_VALUE);

    // Have to work hard to get Americium to root out the failing cases - by default, the integers will
    // vary wildly from 0 to `Integer.MAX_VALUE`. An interesting thought experiment is to imagine what
    // would happen if the exclusion range for failures was increased from 10 to some large number...
    private final static Trials<Integer> positivesFavouringSmallerValues =
            api.alternateWithWeights(IntStream.range(1, maximumPowerOfTwo)
                    .mapToObj(power -> Maps.immutableEntry(Math.max(1, maximumPowerOfTwo - power), api.integers(0, (2 << power) - 1)))
                    .toArray(Map.Entry[]::new));

    @TrialsTest(trials = {"positivesFavouringSmallerValues", "positivesFavouringSmallerValues"}, casesLimit = 1000)
    void mustNotBeZero(int first, int second) {
        if (first < 10) {
            return;
        }
        int difference = Math.abs(first - second);
        assertThat(difference).isNotZero();
    }

    @TrialsTest(trials = {"positivesFavouringSmallerValues", "positivesFavouringSmallerValues"}, casesLimit = 150)
    void mustNotBeSmall(int first, int second) {
        if (first < 10) {
            return;
        }
        int difference = Math.abs(first - second);
        assertThat(1 > difference || difference > 4).isTrue();
    }

    // The thought experiment alluded to above...
    @Test
    void mustNotBeSmallVariationWithLargerExclusionZone() {
        final AtomicLong counter = new AtomicLong(0L);

        try {
            positivesFavouringSmallerValues.and(positivesFavouringSmallerValues).withLimit(Integer.MAX_VALUE).supplyTo((first, second) -> {
                counter.incrementAndGet();

                if (first < 76347853) {
                    return;
                }
                int difference = Math.abs(first - second);
                assertThat(1 > difference || difference > 4).isTrue();
            });
        } finally {
            System.out.println(counter.get());
        }
    }

    @TrialsTest(trials = {"positivesFavouringSmallerValues", "positivesFavouringSmallerValues"}, casesLimit = 350)
    void mustNotBeOne(int first, int second) {
        if (first < 10) {
            return;
        }
        int difference = Math.abs(first - second);
        assertThat(difference).isNotEqualTo(1);
    }

}
