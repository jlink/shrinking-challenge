package challenges.binheap;

import net.jqwik.api.*;

class Heap {

	final int head;
	final Heap left;
	final Heap right;

	Heap(int head, Heap left, Heap right) {
		this.head = head;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		String leftString = left == null ? "None" : left.toString();
		String rightString = right == null ? "None" : right.toString();
		Tuple.Tuple3<Integer, String, String> asTuple = Tuple.of(head, leftString, rightString);
		return asTuple.toString();
	}
}
