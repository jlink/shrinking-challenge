package challenges.nestedlists;

import com.google.common.collect.ImmutableList;
import com.sageserpent.americium.java.Trials;
import com.sageserpent.americium.java.TrialsApi;
import com.sageserpent.americium.java.TrialsTest;


import static org.assertj.core.api.Assertions.assertThat;

public class NestedListsTest {
    final private static TrialsApi api = Trials.api();

    final private static Trials<ImmutableList<ImmutableList<Integer>>> nestedLists = api.only(0).immutableLists().immutableLists();

    @TrialsTest(trials = "nestedLists", casesLimit = 500)
    void sumOfLengthsMustNotExceedTen(ImmutableList<ImmutableList<Void>> nestedLists) {
        assertThat(nestedLists.stream().mapToInt(ImmutableList::size).sum()).isLessThanOrEqualTo(10);
    }
}
