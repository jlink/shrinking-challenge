package challenges.largeunionlist;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.sageserpent.americium.java.ConfiguredTrialsTest;
import com.sageserpent.americium.java.Trials;
import com.sageserpent.americium.java.TrialsScaffolding;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LargeUnionListTest {
    private static final TrialsScaffolding.SupplyToSyntax<ImmutableList<ImmutableList<Integer>>> listsOfLists = Trials.api().integers().immutableLists().immutableLists().withLimit(100);

    @ConfiguredTrialsTest("listsOfLists")
    void claimThereCanBeNoMoreThanFourUniqueElementsAmongstAFlattening(List<List<Integer>> sut) {
        final ImmutableSet.Builder<Object> builder = ImmutableSet.builder();

        sut.forEach(builder::addAll);

        assertThat(builder.build()).hasSizeLessThan(5);
    }
}
