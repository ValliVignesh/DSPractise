package Stack;

import java.util.Stack;

import org.junit.Test;

//	https://leetcode.com/problems/min-stack/submissions/

class MinStack {

	@Test
	public void test1() {
		String[] operations={"MinStack","push","push","push","getMin","pop","top","getMin"};
				//String[][] input= {{},{-2},{0},{-3},],[],[],[]};
	}

	/** initialize your data structure here. */
	Stack<Node> obj;

	class Node {
		int val;
		int min;

		Node(int val, int min) {
			this.val = val;
			this.min = min;
		}
	}

	public MinStack() {

		obj = new Stack<>();
	}

	public void push(int val) {
		if (obj.isEmpty()) {
			obj.push(new Node(val, val));
		} else {
			int min = Math.min(val, obj.peek().min);
			obj.push(new Node(val, min));
		}

	}

	public void pop() {
		obj.pop();
	}

	public int top() {
		return obj.peek().val;
	}

	public int getMin() {
		return obj.peek().min;
	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */