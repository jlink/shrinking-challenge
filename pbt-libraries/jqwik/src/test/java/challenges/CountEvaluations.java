package challenges;

import java.lang.reflect.*;
import java.util.*;

import net.jqwik.api.lifecycle.*;

public class CountEvaluations implements AroundTryHook, AroundPropertyHook {

	@Override
	public PropertyExecutionResult aroundProperty(PropertyLifecycleContext context, PropertyExecutor property) {
		Store<Integer> counter = Store.create("evaluations", Lifespan.PROPERTY, () -> 0);
		PropertyExecutionResult executionResult = property.execute();
		context.reporter().publishReport("evaluations", counter.get());
		return executionResult;
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
