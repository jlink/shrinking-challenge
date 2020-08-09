package challenges;

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
						.build();

		TestPlan plan = launcher.discover(request);

		SummaryGeneratingListener listener = new SummaryGeneratingListener();

		for (int i = 0; i < RUNS; i++) {
			launcher.execute(plan, listener);
		}

		System.out.println("Tests started   : " + listener.getSummary().getTestsStartedCount());
		System.out.println("Tests succeeded : " + listener.getSummary().getTestsFailedCount());
		System.out.println("Tests failed    : " + listener.getSummary().getTestsFailedCount());
	}

}
