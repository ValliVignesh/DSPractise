package recurssion;

import java.util.HashSet;

import org.junit.Test;

//Condensed List

public class RemoveTargetNode {
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

	Node findRemoveDup(Node node) {

		Node outputNode = new Node();
		Node temp = outputNode;
		HashSet<Integer> set = new HashSet<Integer>();

		while (node != null) {
			if (set.contains(node.value)) {
				node = node.next;
				temp.next = null;
			} else {
				set.add(node.value);
				temp.next = node;
				node = node.next;
				temp = temp.next;
			}
		}
		return outputNode;
	}
	Node findRemoveDupRecursion(Node node, int target) {
		if (node == null)//10 
			return node;
		if (node.value != target) {
			Node temp = findRemoveDupRecursion(node.next, target);
			node.next = temp;
		} else {//10
			Node temp = findRemoveDupRecursion(node.next, target);
			return temp;
		}
		return node;
	}

	@Test
	public void test1() {
		Node head = addNode(10);
		head.next = addNode(11);
		head.next.next = addNode(12);
		head.next.next.next = addNode(11);

		System.out.println("Linked List before removing target : \n ");
		printAllNodes(head);		
		System.out.println("");
		System.out.println("Linked List after removing target : \n ");
		printAllNodes(findRemoveDupRecursion(head,10));

	}

}
