package Stack;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class LongValidParanthesis {
	/**
	 * Given a string containing just the characters '(' and ')', find the length of
	 * the longest valid (well-formed) parentheses substring.
	 * 
	 * Input - String Output- int
	 */
	@Test
	public void test1() {
		String str = "(()";
		Assert.assertEquals(2, findLongValid(str));
	}

	@Test
	public void test2() {
		String str = "(()))(())";
		Assert.assertEquals(4, findLongValid(str));
	}

	@Test
	public void test3() {
		String str = ")()())";
		Assert.assertEquals(4, findLongValid(str));
	}

	/**
	 * if first bracket is close ignore it if open bracket push in if close bracket
	 * check if earlier is open pop and store in que if earlier not open make stack
	 * empty if open bracket push in
	 * 
	 * @param str
	 * @return
	 */

	private int findLongValid(String str) {
		// TODO Auto-generated method stub
		int count = 0;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(0) == ')')
				continue;
			else {
				if (str.charAt(i) == ')') {
					if (stack.peek() == '(')
						stack.pop();
					count = count + 2;

				}

			}
			if (str.charAt(i) == '(')
				stack.push(str.charAt(i));
			if (str.charAt(i) == ')' && !stack.isEmpty()) {
				if (stack.peek() == '(')
					stack.pop();
				count = count + 2;

			}

		}
		return count;
	}

}
