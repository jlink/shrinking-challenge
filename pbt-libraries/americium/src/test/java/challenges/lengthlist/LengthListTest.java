package challenges.lengthlist;

import com.google.common.collect.ImmutableList;
import com.sageserpent.americium.java.Trials;
import com.sageserpent.americium.java.TrialsApi;
import com.sageserpent.americium.java.TrialsTest;

import static org.assertj.core.api.Assertions.assertThat;

public class LengthListTest {
    final private static TrialsApi api = Trials.api();

    final private static Trials<ImmutableList<Integer>> listsOfBoundedLengthAndElementValue =
            api.integers(1, 100).flatMap(length -> api.integers(0, 1000).immutableListsOfSize(length));

    final private static int limit = 900;

    @TrialsTest(trials = "listsOfBoundedLengthAndElementValue", casesLimit = 180)
    void allElementShouldBeBelowLimit(ImmutableList<Integer> list) {
        assertThat(list).allSatisfy(element -> assertThat(element).isLessThan(limit));
    }
}
