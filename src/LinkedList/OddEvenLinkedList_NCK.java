package LinkedList;

import org.junit.Test;

public class OddEvenLinkedList_NCK {
	/**
	 * https://leetcode.com/problems/odd-even-linked-list/
	 */
	public class Node {
		int value;
		Node next;

		Node() {
			next = null;
		}

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

	public Node mergeNodes1(Node node1, Node node2) {
		// create a new node (merged), current node
		Node merged = new Node();
		Node current = merged;
		while (node1 != null && node2 != null) {
			if (node1.value < node2.value) {
				current.next = node1;
				node1 = node1.next;
			} else {
				current.next = node2;
				node2 = node2.next;
			}
			current = current.next;
		}
		current.next = node1 == null ? node2 : node1;
		return merged.next;
	}

	public Node oddEvenNodes(Node node1) {
		if (node1 == null)
			return null;
		if (node1.next == null) // break point
			return node1;

		Node oddHead = node1;

		Node evenHead = node1.next;
		Node evenRef = evenHead;

		while (evenRef.next != null && evenRef != null) {

			oddHead.next = evenHead.next;
			oddHead = oddHead.next;

			evenHead.next = oddHead.next;
			evenHead = evenHead.next;

		}
		oddHead.next = evenRef;
		return node1;
	}

	@Test
	public void test1() {
		Node head1 = addNode(1);
		head1.next = addNode(2);
		head1.next.next = addNode(3);
		head1.next.next.next = addNode(4);
		head1.next.next.next.next = addNode(5);
		

		// printAllNodes(head1);
		Node diffNodes = oddEvenNodes(head1);
		printAllNodes(diffNodes);
	}
}
