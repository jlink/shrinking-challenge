package challenges;

import challenges.binheap.*;
import challenges.bound5.*;
import challenges.calculator.*;
import challenges.coupling.*;
import challenges.deletion.*;
import challenges.difference.*;
import challenges.distinct.*;
import challenges.largeunionlist.*;
import challenges.lengthlist.*;
import challenges.nestedlists.*;
import challenges.reverse.*;
import org.junit.platform.engine.discovery.*;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.*;
import org.junit.platform.launcher.listeners.*;

import static org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.*;

public class RunChallenges {

	static final int RUNS = 100;

	static final Class<?>[] CHALLENGES = {
			BinheapProperties.class,
			Bound5Properties.class,
			CalculatorProperties.class,
			CouplingProperties.class,
			DeletionProperties.class,
			DifferenceProperties.class,
			DistinctProperties.class,
			LargeUnionListProperties.class,
			LengthListProperties.class,
			NestedListsProperties.class,
			ReverseProperties.class
	};

	public static void main(String[] args) {
		Launcher launcher = LauncherFactory.create();
		for (Class<?> challenge : CHALLENGES) {
			runChallenge(launcher, challenge);
		}
	}

	private static void runChallenge(Launcher launcher, Class<?> challengeClass) {
		LauncherDiscoveryRequest request =
				request()
						.selectors(DiscoverySelectors.selectClass(challengeClass))
						.build();

		SummaryGeneratingListener listener = new SummaryGeneratingListener() {
			boolean initialized = false;

			@Override
			public void testPlanExecutionStarted(TestPlan testPlan) {
				if (!initialized) {
					super.testPlanExecutionStarted(testPlan);
					initialized = true;
				}
			}
		};

		for (int i = 0; i < RUNS; i++) {
			launcher.execute(request, listener);
		}

		System.out.println("Challenge       : " + challengeClass.getSimpleName());
		System.out.println("Tests started   : " + listener.getSummary().getTestsStartedCount());
		System.out.println("Tests succeeded : " + listener.getSummary().getTestsSucceededCount());
		System.out.println("Tests failed    : " + listener.getSummary().getTestsFailedCount());
	}

}
