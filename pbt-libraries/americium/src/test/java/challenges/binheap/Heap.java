package challenges.binheap;

// NOTE: adapted from the Jqwik challenge version, an invariant check in
// the spirit of the QuickCheck / Smallcheck version has been added in too.

import cyclops.data.tuple.Tuple3;

import java.util.Optional;

class Heap {

    final int head;
    final Heap left;
    final Heap right;

    Heap(int head, Heap left, Heap right) {
        this.head = head;
        this.left = left;
        this.right = right;

        checkInvariant();
    }

    void checkInvariant() {
        // No need to check the invariant recursively on any children, as they
        // should already satisfy it by prior construction; this type is immutable.

        Optional.ofNullable(left).ifPresent(content -> {
            assert head <= content.head;
        });

        Optional.ofNullable(right).ifPresent(content -> {
            assert head <= content.head;
        });
    }

    @Override
    public String toString() {
        String leftString = left == null ? "None" : left.toString();
        String rightString = right == null ? "None" : right.toString();
        Tuple3<Integer, String, String> asTuple = Tuple3.of(head, leftString, rightString);
        return asTuple.toString();
    }
}
