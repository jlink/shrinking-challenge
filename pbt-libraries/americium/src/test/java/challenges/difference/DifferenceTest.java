package challenges.difference;

import com.google.common.collect.Maps;
import com.sageserpent.americium.java.Trials;
import com.sageserpent.americium.java.TrialsApi;
import com.sageserpent.americium.java.TrialsTest;

import java.util.Map;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferenceTest {

    private final static TrialsApi api = Trials.api();

    private final static int maximumPowerOfTwo = Integer.bitCount(Integer.MAX_VALUE);

    // Have to work hard to get Americium to root out the failing cases - by default, the integers will
    // vary wildly from 0 to `Integer.MAX_VALUE`. The question arises though - is this challenge truly
    // representative of real bugs? For example, suppose the failures were provoked by integers in some
    // small range around 76467553 +/- 10? Without some insight into the potential mode of failure, how
    // could we tune the test generation to hone in on *that* range?
    private final static Trials<Integer> positivesFavouringSmallerValues =
            api.alternateWithWeights(IntStream.range(1, maximumPowerOfTwo)
                    .mapToObj(power -> Maps.immutableEntry(Math.max(1, 100 / power), api.integers(0, (2 << power) - 1)))
                    .toArray(Map.Entry[]::new));

    @TrialsTest(trials = {"positivesFavouringSmallerValues", "positivesFavouringSmallerValues"}, casesLimit = 20)
    void mustNotBeZero(int first, int second) {
        if (first < 10) {
            return;
        }
        int difference = Math.abs(first - second);
        assertThat(difference).isNotZero();
    }

    @TrialsTest(trials = {"positivesFavouringSmallerValues", "positivesFavouringSmallerValues"}, casesLimit = 20)
    void mustNotBeSmall(int first, int second) {
        if (first < 10) {
            return;
        }
        int difference = Math.abs(first - second);
        assertThat(1 > difference || difference > 4).isTrue();
    }

    @TrialsTest(trials = {"positivesFavouringSmallerValues", "positivesFavouringSmallerValues"}, casesLimit = 20)
    void mustNotBeOne(int first, int second) {
        if (first < 10) {
            return;
        }
        int difference = Math.abs(first - second);
        assertThat(difference).isNotEqualTo(1);
    }

}
