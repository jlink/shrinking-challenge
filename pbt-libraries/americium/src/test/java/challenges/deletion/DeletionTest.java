package challenges.deletion;

import com.google.common.collect.ImmutableList;
import com.sageserpent.americium.java.Trials;
import com.sageserpent.americium.java.TrialsApi;
import com.sageserpent.americium.java.TrialsTest;
import cyclops.data.tuple.Tuple2;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class DeletionTest {

    private final static TrialsApi api = Trials.api();

    // NOTE: make the `Trials` DSL work for us - rather than building lists of wildly varying integers
    // and hoping for a duplicate, encourage the generation of duplicates by building a set of candidate
    // elements and then making a list from just those elements. Simply throwing together lists directly
    // from, say `api.integers()` is extremely unlikely to create duplicates unless an artificial range
    // clamp is imposed, which would cause the lists to have clustered elements, thus losing generality.
    private final static Trials<ImmutableList<Integer>> lists = api
            .integers()
            .immutableSets()
            .filter(candidateElementSet -> !candidateElementSet.isEmpty())
            .flatMap(choices -> api.choose(choices).immutableLists());

    private final static Trials<Integer> indices = api.integers(0, 10);

    // As an alternative, copy the Scala version of this test and drive the generation of removal indices
    // based on the list size.
    private final static Trials<Tuple2<ImmutableList<Integer>, Integer>> listAndIndexPairs =
            lists.filter(list -> !list.isEmpty()).flatMap(list -> api.integers(0, list.size() - 1).map(index -> Tuple2.of(list, index)));


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

            final int itemForRemoval = mutable.get(indexOfElementToRemoveFromList);

            while (mutable.remove((Object) itemForRemoval)) {
            }

            assertThat(mutable).doesNotContain(itemForRemoval);
        });
    }

    @TrialsTest(trials = {"listAndIndexPairs"}, casesLimit = 20)
    void testThatFailsInAlternateForm(ImmutableList<Integer> list, int indexOfElementToRemoveFromList) {
        final List<Integer> mutable = list.stream().collect(Collectors.toList());

        final int removedItem = mutable.remove(indexOfElementToRemoveFromList);

        assertThat(mutable).doesNotContain(removedItem);
    }

    @TrialsTest(trials = {"listAndIndexPairs"}, casesLimit = 20)
    void testThatSucceedsInAlternateForm(ImmutableList<Integer> list, int indexOfElementToRemoveFromList) {
        final List<Integer> mutable = list.stream().collect(Collectors.toList());

        final int itemForRemoval = mutable.get(indexOfElementToRemoveFromList);

        while (mutable.remove((Object) itemForRemoval)) {
        }

        assertThat(mutable).doesNotContain(itemForRemoval);
    }
}
