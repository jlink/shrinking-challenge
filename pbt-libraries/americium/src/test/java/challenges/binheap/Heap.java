package challenges.binheap;

// NOTE: adapted from the Jqwik challenge version, an invariant check in
// the spirit of the QuickCheck / Smallcheck version has been added in too.

import cyclops.data.tuple.Tuple3;

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
        if (null != left) {
            assert head <= left.head;

            left.checkInvariant();
        }

        if (null != right) {
            assert head <= right.head;

            right.checkInvariant();
        }
    }

    @Override
    public String toString() {
        String leftString = left == null ? "None" : left.toString();
        String rightString = right == null ? "None" : right.toString();
        Tuple3<Integer, String, String> asTuple = Tuple3.of(head, leftString, rightString);
        return asTuple.toString();
    }
}
