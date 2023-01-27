package challenges.reverse;

import com.google.common.collect.ImmutableList;
import com.sageserpent.americium.java.ConfiguredTrialsTest;
import com.sageserpent.americium.java.Trials;
import com.sageserpent.americium.java.TrialsScaffolding;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseTest {
    private static TrialsScaffolding.SupplyToSyntax<ImmutableList<Integer>> lists = Trials.api().integers().immutableLists().withLimit(15);

    @ConfiguredTrialsTest("lists")
    void claimThatAllListsArePalindromes(List<Integer> sut){
        for (int lowIndex = 0, highIndex = sut.size() - 1; lowIndex < highIndex; ++lowIndex, --highIndex){
            assertThat(sut.get(lowIndex)).isEqualTo(sut.get(highIndex));
        }
    }
}
