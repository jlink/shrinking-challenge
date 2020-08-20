package challenges.binheap;

class Heap {

	final int head;
	final Heap left;
	final Heap right;

	Heap(int head, Heap left, Heap right) {
		this.head = head;
		this.left = left;
		this.right = right;
	}
}
