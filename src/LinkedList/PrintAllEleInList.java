package LinkedList;

import org.junit.Test;

public class PrintAllEleInList {
	public class Node {
		int value;
		Node next;

		Node(int key) {
			this.value = key;
			next = null;
		}
	}

	public Node addNode(int key) {
		return new Node(key);
	}

	public void printAllNodes(Node node) {
		while (node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}

	@Test
	public void test1() {
		Node head = addNode(10);
		head.next = addNode(11);
		head.next.next = addNode(12);
		printAllNodes(head);
	}

}
