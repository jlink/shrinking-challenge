package challenges.binheap;

import com.sageserpent.americium.java.Trials;
import com.sageserpent.americium.java.TrialsApi;
import com.sageserpent.americium.java.TrialsTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

// NOTE: adapted from the Jqwik challenge version, most of the code is the same.

public class HeapTest {
    private final static TrialsApi api = Trials.api();
    // Be ambitious - allow heaps to contain negative values of large magnitude.
    private final static Trials<Heap> heaps = heaps(Integer.MIN_VALUE);

    private static Trials<Heap> heaps(int lowerBound) {
        return
                api.alternate(
                        api.only(null),
                        // Again, be ambitious - allow heaps to contain positive values of large magnitude.
                        api.integers(lowerBound, Integer.MAX_VALUE).flatMap(head ->
                                heaps(head).flatMap(left ->
                                        heaps(head).map(right -> new Heap(head, left, right)))));
    }

    // Interestingly, being parsimonious with the `caseLimit` yields a better shrinkage. This would fit in with
    // the hypothesis (ahem) that small examples are too sparse to allow a really good shrinkage to occur - less
    // choice is better, it seems.
    @TrialsTest(trials = {"heaps"}, casesLimit = 10)
    void test(Heap h) {
        List<Integer> l1 = toList(h);
        List<Integer> l2 = wrongToSortedList(h);

        assertThat(l2).isEqualTo(sorted(l2));
        assertThat(sorted(l1)).isEqualTo(l2);
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
}
