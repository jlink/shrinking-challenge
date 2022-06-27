package challenges.difference;

import com.sageserpent.americium.java.Trials;
import com.sageserpent.americium.java.TrialsApi;
import com.sageserpent.americium.java.TrialsTest;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferenceTest {

    private final static TrialsApi api = Trials.api();

    private final static int maximumPowerOfTwo = Integer.bitCount(Integer.MAX_VALUE);

    private final static Trials<Integer> positivesFavouringSmallerValues =
            api.integers(1, maximumPowerOfTwo).flatMap(power -> {
                final int basePowerOfTwo = 1 << (power - 1);
                final int offsetUpperBound = basePowerOfTwo - 1;
                return api.integers(0, offsetUpperBound).map(offset -> basePowerOfTwo + offset);
            });

    @TrialsTest(trials = {"positivesFavouringSmallerValues", "positivesFavouringSmallerValues"}, casesLimit = 2500)
    void mustNotBeZero(int first, int second) {
        if (first < 10) {
            return;
        }
        int difference = Math.abs(first - second);
        assertThat(difference).isNotZero();
    }

    @TrialsTest(trials = {"positivesFavouringSmallerValues", "positivesFavouringSmallerValues"}, casesLimit = 500)
    void mustNotBeSmall(int first, int second) {
        if (first < 10) {
            return;
        }
        int difference = Math.abs(first - second);
        assertThat(1 > difference || difference > 4).isTrue();
    }

    @TrialsTest(trials = {"positivesFavouringSmallerValues", "positivesFavouringSmallerValues"}, casesLimit = 4300)
    void mustNotBeOne(int first, int second) {
        if (first < 10) {
            return;
        }
        int difference = Math.abs(first - second);
        assertThat(difference).isNotEqualTo(1);
    }
}
