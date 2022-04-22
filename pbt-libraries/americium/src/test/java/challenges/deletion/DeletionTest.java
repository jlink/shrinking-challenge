package challenges.deletion;

import com.google.common.collect.ImmutableList;
import com.sageserpent.americium.java.Trials;
import com.sageserpent.americium.java.TrialsApi;
import com.sageserpent.americium.java.TrialsTest;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DeletionTest {

    private final static TrialsApi api = Trials.api();

    // NOTE: make the `Trials` DSL work for us - rather than building lists of wildly varying integers
    // and hoping for a duplicate, encourage the generation of duplicates by building a set of candidate
    // elements and then making a list from just those elements. Simply throwing together lists directly
    // from, say `api.integers()` is extremely unlikely to create duplicates unless an artificial range
    // clamp is imposed, which would cause the lists to have clustered elements, thus losing generality.
    private final static Trials<ImmutableList<Integer>> lists = api.integers().immutableSets().filter(candidateElementSet -> !candidateElementSet.isEmpty()).flatMap(choices -> api.choose(choices).immutableLists());

    private final Trials<Integer> indices = api.integers(0, 10);

    @TrialsTest(trials = {"lists", "indices"}, casesLimit = 20)
    void testThatFails(ImmutableList<Integer> list, int indexOfElementToRemoveFromList) {
        Trials.whenever(list.size() > indexOfElementToRemoveFromList, () -> {
            final List<Integer> mutable = list.stream().collect(Collectors.toList());

            final int removedItem = mutable.remove(indexOfElementToRemoveFromList);

            assertThat(mutable).doesNotContain(removedItem);
        });
    }

    @TrialsTest(trials = {"lists", "indices"}, casesLimit = 100)
    void testThatSucceeds(ImmutableList<Integer> list, int indexOfElementToRemoveFromList) {
        Trials.whenever(list.size() > indexOfElementToRemoveFromList, () -> {
            final List<Integer> mutable = list.stream().collect(Collectors.toList());

            final int removedItem = mutable.remove(indexOfElementToRemoveFromList);

            while (mutable.remove((Object) removedItem)) {
            }

            assertThat(mutable).doesNotContain(removedItem);
        });
    }
}
