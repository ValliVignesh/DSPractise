package LinkedList;

import java.util.HashSet;

import org.junit.Test;

//Condensed List

public class RemoveDuplicateValues {
	public class Node {
		int value;
		Node next;

		Node(int key) {
			this.value = key;
			next = null;

		}

		public Node() {
			// TODO Auto-generated constructor stub
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

	/*
	 * public Node delteDupNodes(Node node) { HashSet<Integer> newMap=new
	 * HashSet<Integer>(); while(node.next!=null){ newMap.add(node.value);
	 * node=node.next; } System.out.println(newMap.toString());
	 * 
	 * Node curr=node,nex=node.next,currRef=curr;
	 * 
	 * while(currRef!=null){ if(newMap.contains(node.value)) {
	 * currRef.next=nex.next; } else { currRef.next=nex.next; } nex=nex.next; }
	 * printAllNodes(curr); return curr; }
	 */
	void remove_duplicates(Node node) {
		Node ptr1 = null, ptr2 = null, dup = null;
		ptr1 = node;
		while (ptr1 != null && ptr1.next != null) {
			ptr2 = ptr1;

			while (ptr2.next != null) {
				if (ptr1.value == ptr2.next.value) {

					dup = ptr2.next;
					ptr2.next = ptr2.next.next;
					System.gc();
				} else {
					ptr2 = ptr2.next;
				}
			}
			ptr1 = ptr1.next;
		}
	}

	Node findRemoveDup(Node node, int target) {

		Node outputNode = new Node();
		Node temp = outputNode;
		HashSet<Integer> set = new HashSet<Integer>();

		if (node == null)
			return node;

		while (node != null) {
			if (node.value == target) {
				node = node.next;
				temp.next = null;
			} else {

				temp.next = node;
				node = node.next;
				temp = temp.next;
			}
		}
		return outputNode;
	}

	Node findRemoveDupRecursion(Node node, int target) {

		if (node == null)
			return node;
//		if (node.value == target && node.next==null)
//			return node;
//
//		if (node.value == target) {
//			node.value = node.next.value;
//			node.next = node.next.next;
//		} else {
//			if (node.next.next == null && node.next.value == target) {
//				node.next = null;
//			}
//			node = node.next;
//		}
		if (node.value != target) {
			node = node.next;
		}
		return findRemoveDupRecursion(node, target);
	}

	@Test
	public void test1() {
		Node head = addNode(10);
		 head.next = addNode(11);
		 head.next.next = addNode(12);
		 head.next.next.next = addNode(11);

		System.out.println("Linked List before removing duplicates : \n ");
		printAllNodes(head);
		findRemoveDup(head, 11);
		System.out.println("");
		System.out.println("Linked List after removing duplicates : \n ");
		printAllNodes(head);

	}

}
