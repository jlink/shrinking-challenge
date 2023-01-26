package challenges.coupling;

import com.google.common.collect.ImmutableList;
import com.sageserpent.americium.java.*;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CouplingTest {
    private final static TrialsApi api = Trials.api();

    private static final TrialsScaffolding.SupplyToSyntax<ImmutableList<Integer>> nonNegativeIntegers =
            api.integers(0, 10).immutableLists().withStrategy(unused -> CasesLimitStrategy.timed(Duration.ofSeconds(2)), TrialsScaffolding.OptionalLimits.defaults);

    @ConfiguredTrialsTest("nonNegativeIntegers")
    void testThatAListIsWellFormed(List<Integer> sut) {
        final int size = sut.size();

        Trials.whenever(sut.stream().allMatch(value -> size > value), () -> {
            for (int index = 0; size > index; ++index){
                final int secondaryIndex = sut.get(index);
                if(index != secondaryIndex){
                    assertThat(sut.get(secondaryIndex)).isNotEqualTo(index);
                }
            }
        });
    }
}
