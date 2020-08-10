package challenges;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

import com.fasterxml.jackson.core.util.*;
import com.fasterxml.jackson.databind.*;

import net.jqwik.api.lifecycle.*;

public class ShrinkingStatistics implements AroundTryHook, AroundPropertyHook {

	final ObjectMapper objectMapper;
	final String reportsPath = "pbt-libraries/jqwik/reports/";

	private ShrinkingStatistics() {
		ObjectMapper mapper = new ObjectMapper();
		DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
		prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
		mapper.setDefaultPrettyPrinter(prettyPrinter);
		this.objectMapper = mapper;
	}

	@Override
	public PropertyExecutionResult aroundProperty(PropertyLifecycleContext context, PropertyExecutor property) throws IOException {

		Store<Integer> counter = Store.create("evaluations", Lifespan.PROPERTY, () -> 0);
		PropertyExecutionResult executionResult = property.execute();

		ShrinkingValues values = new ShrinkingValues(
				counter.get(),
				executionResult.seed().orElse(""),
				createSample(executionResult.falsifiedParameters(), context.targetMethod().getParameters())
		);

		appendToReport(values, context.label());

		return executionResult;
	}

	private Map<String, String> createSample(Optional<List<Object>> falsifiedParameters, Parameter[] parameters) {
		Map<String, String> sample = new HashMap<>();
		if (falsifiedParameters.isEmpty()) {
			return sample;
		}
		List<Object> actual = falsifiedParameters.get();
		if (actual.size() != parameters.length) {
			return sample;
		}
		for (int i = 0; i < parameters.length; i++) {
			String parameterName = parameters[i].getName();
			Object parameterValue = actual.get(i);
			sample.put(parameterName, parameterValue.toString());
		}
		return sample;
	}

	private void appendToReport(ShrinkingValues values, String fileName) throws IOException {
		File statsFile = new File(reportsPath, fileName + ".json");

		List<ShrinkingValues> stats;
		if (statsFile.exists()) {
			try (FileReader reader = new FileReader(statsFile)) {
				stats = objectMapper.readValue(reader, List.class);
			}
		} else {
			stats = new ArrayList<>();
		}

		stats.add(values);

		try (FileWriter writer = new FileWriter(statsFile)) {
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(writer, stats);
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.printf("WARNING: Cannot write statistics [%s]%n%n", statsFile.getAbsolutePath());
		}
	}

	@Override
	public TryExecutionResult aroundTry(TryLifecycleContext context, TryExecutor aTry, List<Object> parameters) {
		Store<Integer> counter = Store.get("evaluations");
		counter.update(i -> i + 1);
		return aTry.execute(parameters);
	}

	@Override
	public boolean appliesTo(Optional<AnnotatedElement> element) {
		return element.map(e -> e instanceof Method).orElse(false);
	}

	@Override
	public PropagationMode propagateTo() {
		return PropagationMode.ALL_DESCENDANTS;
	}
}
