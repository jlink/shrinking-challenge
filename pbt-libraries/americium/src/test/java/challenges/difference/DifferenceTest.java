package challenges.difference;

import com.sageserpent.americium.java.Trials;
import com.sageserpent.americium.java.TrialsApi;
import com.sageserpent.americium.java.TrialsTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferenceTest {

    private final static TrialsApi api = Trials.api();

    private final static int maximumPowerOfTwo = Integer.bitCount(Integer.MAX_VALUE);

    private static final int scaleForClusteredValues = 10000;

    private static final Trials<Integer> positivesFavouringSmallerValues = api.integers(1, 1 << (maximumPowerOfTwo / 3)).map(x -> (scaleForClusteredValues + x * x) * x / (scaleForClusteredValues + x));

    @TrialsTest(trials = {"positivesFavouringSmallerValues", "positivesFavouringSmallerValues"}, casesLimit = 850)
    void mustNotBeZero(int first, int second) {
        if (first < 10) {
            return;
        }
        int difference = Math.abs(first - second);
        assertThat(difference).isNotZero();
    }

    @TrialsTest(trials = {"positivesFavouringSmallerValues", "positivesFavouringSmallerValues"}, casesLimit = 2000)
    void mustNotBeSmall(int first, int second) {
        if (first < 10) {
            return;
        }
        int difference = Math.abs(first - second);
        assertThat(1 > difference || difference > 4).isTrue();
    }

    @TrialsTest(trials = {"positivesFavouringSmallerValues", "positivesFavouringSmallerValues"}, casesLimit = 32000)
    void mustNotBeOne(int first, int second) {
        if (first < 10) {
            return;
        }
        int difference = Math.abs(first - second);
        assertThat(difference).isNotEqualTo(1);
    }

}
