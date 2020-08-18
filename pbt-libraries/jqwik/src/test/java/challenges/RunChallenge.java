package challenges;

import challenges.calculator.*;
import org.junit.platform.engine.discovery.*;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.*;
import org.junit.platform.launcher.listeners.*;

import static org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.*;

public class RunChallenge {

	public static final int RUNS = 100;

	public static void main(String[] args) {
		Launcher launcher = LauncherFactory.create();

		LauncherDiscoveryRequest request =
				request()
						.selectors(DiscoverySelectors.selectPackage("challenges"))
						// .selectors(DiscoverySelectors.selectClass(CalculatorProperties.class))
						// .selectors(DiscoverySelectors.selectMethod(
						// 		DifferenceProperties.class,
						// 		DifferenceProperties.class.getDeclaredMethod("mustNotBeOne", int.class, int.class)
						// ))
						.build();

		TestPlan plan = launcher.discover(request);

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
			launcher.execute(plan, listener);
		}

		System.out.println("Tests started   : " + listener.getSummary().getTestsStartedCount());
		System.out.println("Tests succeeded : " + listener.getSummary().getTestsSucceededCount());
		System.out.println("Tests failed    : " + listener.getSummary().getTestsFailedCount());
	}

}
