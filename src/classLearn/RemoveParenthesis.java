package classLearn;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class RemoveParenthesis {
	/**
	 * Problem 1:
	 * 
	 * Remove the minimum number of parentheses ( '(' or ')', in any positions ) so
	 * that the resulting parentheses string is valid and return any valid string.
	 * 
	 * Formally, a parentheses string is valid if and only if:
	 * 
	 * It is the empty string, contains only lowercase characters, or It can be
	 * written as AB (A concatenated with B), where A and B are valid strings, or It
	 * can be written as (A), where A is a valid string.   Example 1:
	 * 
	 * Input: s = “abc(a(c)e)de)" Output: “abc(a(c)e)de" Explanation: “abc(a(ce)de)"
	 * , “abc(a(c)ede)" would also be accepted.
	 */

	@Test
	public void test1() {
		String str = "abc(a(c)e)de)";
		Assert.assertEquals("abc(a(c)e)de", minDelParam(str));
	}

	@Test
	public void test2() {
		String str = "a)b(c)d";
		Assert.assertEquals("ab(c)d", minDelParam(str));
	}
	@Test
	public void test3() {
		String str = "))((";
		Assert.assertEquals("", minDelParam(str));
	}

	@Test
	public void test4() {
		String str = "(())";
		Assert.assertEquals("(())", minDelParam(str));
	}
	/**
	 * two stacks one stack
	 * 
	 * @param s
	 * @return
	 */

	public String minRemoveToMakeValid(String s) {
		StringBuilder ans = new StringBuilder();
		Stack<Character> charStack = new Stack<Character>();
		Stack<Integer> indexStack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (indexStack.isEmpty()) {
					continue;
				} else {
					charStack.push(s.charAt(i));
					charStack.remove(indexStack.peek());
					indexStack.pop();
				}
			} else {
				if (s.charAt(i) == '(')
					indexStack.push(i);
				charStack.push(s.charAt(i));
			}
		}
		while (!charStack.isEmpty()) {
			ans.append(charStack.pop());
			ans.reverse();
		}

		return ans.toString();
	}

	public String minDelParam(String s) {
		StringBuilder str = new StringBuilder(s);
		Stack<Character> charStack = new Stack<Character>();
		Stack<Integer> indexStack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				indexStack.push(i);
				charStack.push(s.charAt(i));
			} else if (s.charAt(i) == ')') {
				if (!charStack.isEmpty() && charStack.peek().equals('(')) {

					indexStack.pop();
					charStack.pop();
				}else {
					indexStack.push(i);
				}
			
			}

		}
		while (!indexStack.isEmpty()) {
			str.deleteCharAt(indexStack.pop());
		}
		return str.toString();
	}

}
