package challenges.distinct;

import com.google.common.collect.ImmutableList;
import com.sageserpent.americium.java.ConfiguredTrialsTest;
import com.sageserpent.americium.java.Trials;
import com.sageserpent.americium.java.TrialsScaffolding;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class DistinctTest {
    private static TrialsScaffolding.SupplyToSyntax<ImmutableList<Integer>> lists = Trials.api().integers().immutableLists().withLimit(15);

    @ConfiguredTrialsTest("lists")
    void claimThatThereShouldBeNoMoreThanTwoDistinctElementsInAList(List<Integer> sut){
        assertThat(sut.stream().collect(Collectors.toSet())).hasSizeBetween(0, 2);
    }
}
