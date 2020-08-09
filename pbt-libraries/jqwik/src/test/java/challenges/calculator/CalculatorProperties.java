package challenges.calculator;

import challenges.*;

import net.jqwik.api.*;
import net.jqwik.api.lifecycle.*;

import static net.jqwik.api.Tuple.*;

@Label("Calculator")
@AddLifecycleHook(ShrinkingStatistics.class)
class CalculatorProperties {

	@Label("calculator")
	@Property(shrinking = ShrinkingMode.BOUNDED, afterFailure = AfterFailureMode.RANDOM_SEED)
	void test(@ForAll("expression") Object expression) {
		Assume.that(divSubterms(expression));
		evaluate(expression);
	}

	private boolean divSubterms(final Object expression) {
		if (expression instanceof Integer) {
			return true;
		}
		@SuppressWarnings("rawtypes")
		Tuple3 tupleExpression = (Tuple3) expression;
		if (tupleExpression.get1().equals("/") && tupleExpression.get3().equals(0)) {
			return false;
		}
		return divSubterms(tupleExpression.get2()) && divSubterms(tupleExpression.get3());
	}

	@Provide
	Arbitrary<Object> expression() {
		Arbitrary<Object> lazyExpression = Arbitraries.lazy(this::expression);

		return Arbitraries.oneOf(
				// Make integers more probable to prevent stack overflow
				Arbitraries.integers(),
				Arbitraries.integers(),
				Arbitraries.integers(),
				Arbitraries.integers(),
				Combinators.combine(lazyExpression, lazyExpression)
						   .as((e1, e2) -> of("+", e1, e2)),
				Combinators.combine(lazyExpression, lazyExpression)
						   .as((e1, e2) -> of("/", e1, e2))
		);
	}

	int evaluate(Object expression) {
		if (expression instanceof Integer) {
			return (int) expression;
		}
		@SuppressWarnings("rawtypes")
		Tuple3 tupleExpression = (Tuple3) expression;
		if (tupleExpression.get1().equals("+")) {
			return evaluate(tupleExpression.get2()) + evaluate(tupleExpression.get3());
		}
		if (tupleExpression.get1().equals("/")) {
			return evaluate(tupleExpression.get2()) / evaluate(tupleExpression.get3());
		}
		throw new IllegalArgumentException(String.format("%s is not a valid expression", expression));
	}
}