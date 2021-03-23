package challenges;

import java.time.*;
import java.time.temporal.*;

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
			volatile boolean initialized = false;

			@Override
			public void testPlanExecutionStarted(TestPlan testPlan) {
				if (!initialized) {
					super.testPlanExecutionStarted(testPlan);
					initialized = true;
				}
			}
		};

		for (int i = 0; i < RUNS; i++) {
			LocalTime before = LocalTime.now();
			System.err.printf("%s: Started  %s (%s/%s)%n", before, challengeClass.getSimpleName(), i + 1, RUNS);
			launcher.execute(request, listener);
			LocalTime after = LocalTime.now();
			Duration duration = Duration.between(before, after).truncatedTo(ChronoUnit.MILLIS);
			System.err.printf("%s: Finished %s (%s/%s) in %s %n", after, challengeClass.getSimpleName(), i + 1, RUNS, duration);
			System.gc();
		}

		System.err.println("Challenge       : " + challengeClass.getSimpleName());
		System.err.println("Tests started   : " + listener.getSummary().getTestsStartedCount());
		System.err.println("Tests succeeded : " + listener.getSummary().getTestsSucceededCount());
		System.err.println("Tests failed    : " + listener.getSummary().getTestsFailedCount());
	}

}
