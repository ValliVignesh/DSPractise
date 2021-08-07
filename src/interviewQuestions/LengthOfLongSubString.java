package interviewQuestions;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class LengthOfLongSubString {

	/**
	 * Given a string of Paranthesis {} find the longest valid substring of
	 * paranthesis
	 * 
	 * input String Ouput -int String str="{{{}}}" o/p- 4 int str="{{}{}{" o/p-4
	 * 
	 * Stack
	 * 
	 * https://leetcode.com/problems/longest-valid-parentheses/
	 */

	@Test
	public void test1() {
		String str = "{{}}}";
		Assert.assertEquals(4, findValidLongValidSubString(str));
	}

	@Test
	public void test2() {
		String str = "}}}";
		Assert.assertEquals(0, findValidLongValidSubString(str));
	}

	@Test
	public void test3() {
		String str = "{{";
		Assert.assertEquals(0, findValidLongValidSubString(str));
	}
	@Test
	public void test4() {
		String str = "{{}";
		Assert.assertEquals(2, findValidLongValidSubString(str));
	}
	@Test
	public void test5() {
		String str = "{{{}}{}{{";
		Assert.assertEquals(6, findValidLongValidSubString(str));
	}


	/**
	 * Change Str to char array if value is { put it in map if value is } and
	 * previous value is { pop and count increment else if value is push to array
	 * 
	 * 
	 * @param str
	 * @return
	 */

	private int findValidLongValidSubString(String str) {
		// TODO Auto-generated method stub
		HashMap<Character, Character> map = new HashMap<Character, Character>();

		Stack<Character> stack = new Stack<Character>();
		char[] cha = str.toCharArray();
		int i = 0, count = 0;
		while (i < str.length()) { //O(n)
			if (cha[i] == '{') {
				// map.put(cha[i], cha[i]);
				stack.push(str.charAt(i));
			} else {
				if (!stack.isEmpty()) {
					if (stack.peek() == '{' && cha[i] == '}') {
						stack.pop();
						count = count + 2;
					} else {
						stack.push(cha[i]);
					}
				} else {
					stack.push(cha[i]);
				}

			}

			i++;
		}
		return count;
	}
}
