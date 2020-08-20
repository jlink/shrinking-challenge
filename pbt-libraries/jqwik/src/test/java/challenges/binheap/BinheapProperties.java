package challenges.binheap;

import java.util.*;

import challenges.*;

import net.jqwik.api.*;
import net.jqwik.api.arbitraries.*;
import net.jqwik.api.lifecycle.*;

import static org.assertj.core.api.Assertions.*;

@PropertyDefaults(afterFailure = AfterFailureMode.RANDOM_SEED)
@AddLifecycleHook(ShrinkingStatistics.class)
public class BinheapProperties {

	@Label("binheap")
	@Disabled("Throwing NPE when running")
	@Property
	void test(@ForAll("heap") Heap h) {
		List<Integer> l1 = toList(h);
		System.out.println(l1);
		// List<Integer> l2 = wrongToSortedList(h);
		//
		// assertThat(l2).isEqualTo(sorted(l2));
		// assertThat(sorted(l1)).isEqualTo(l2);
	}

	private List<Integer> toSortedList(Heap heap) {
		List<Integer> result = new ArrayList<>();
		while (heap != null) {
			result.add(heap.head);
			heap = mergeHeaps(heap.left, heap.right);
		}
		return result;
	}

	private Heap mergeHeaps(Heap h1, Heap h2) {
		if (h1 == null) {
			return h2;
		}
		if (h2 == null) {
			return h1;
		}
		if (h1.head <= h2.head) {

			return new Heap(h1.head, mergeHeaps(h1.right, h2), h1.left);
		} else {
			return new Heap(h2.head, mergeHeaps(h2.right, h1), h2.left);
		}
	}

	private List<Integer> wrongToSortedList(Heap heap) {
		if (heap == null) {
			return Collections.emptyList();
		} else {
			List<Integer> result = new ArrayList<>();
			result.add(heap.head);
			result.addAll(toList(mergeHeaps(heap.left, heap.right)));
			return result;
		}
	}

	private List<Integer> sorted(List<Integer> list) {
		List<Integer> sorted = new ArrayList<>(list);
		Collections.sort(sorted);
		return sorted;
	}

	private List<Integer> toList(Heap heap) {
		List<Integer> result = new ArrayList<>();
		Stack<Heap> stack = new Stack<>();
		stack.add(heap);

		while (!stack.isEmpty()) {
			Heap h = stack.pop();
			if (h == null) {
				continue;
			}
			result.add(h.head);
			stack.push(h.left);
			stack.push(h.right);
		}
		return result;
	}

	@Provide
	Arbitrary<Heap> heap() {
		IntegerArbitrary sizes = Arbitraries.integers().between(0, 20);
		return sizes.flatMap(size -> heap1(null, size));
	}

	private Arbitrary<Heap> heap1(Integer bound, int size) {
		Arbitrary<Integer> branches = Arbitraries.integers().between(1, 8);
		return Arbitraries.lazy(
				() -> branches.flatMap(branch -> {
					if (branch == 1 || size <= 0) {
						return null;
					}
					IntegerArbitrary keys = Arbitraries.integers();
					if (bound != null) {
						keys = keys.greaterOrEqual(bound);
					}
					return keys.flatMap(head -> {
						int childSize = size / 2;
						return Combinators.combine(heap1(head, childSize), heap1(head, childSize))
										  .as((left, right) -> new Heap(head, left, right));
					});

				}));
	}

}
