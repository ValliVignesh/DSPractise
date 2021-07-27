package LinkedList;

import org.junit.Test;

public class PrintOddNodes {

	public class Node {

		int value;
		Node next;

		Node(int key) {
			this.value = key;
			next = null;
		}

		public Node() {

		}

	}

	public Node addNode(int key) {
		return new Node(key);
	}

	public void pritallnode(Node node) {
		while (node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}

	public Node getOddNode(Node node1) {

		Node oddnode = new Node();

		Node currentnode = oddnode;

		if (node1 != null && node1.next != null && node1.next.next != null) {
			System.out.println(node1.next.value);

			System.out.println(node1.next.next.next.value);

		}

		return oddnode.next;

	}

	@Test
	public void test1() {

		Node head = addNode(10);
		head.next = addNode(13);
		head.next.next = addNode(30);
		head.next.next.next = addNode(50);

		getOddNode(head);
	}

}