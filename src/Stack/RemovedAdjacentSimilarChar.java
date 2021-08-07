package Stack;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

public class RemovedAdjacentSimilarChar {
	/**
	 * Remove the adjacent duplicates in a string abbaaba = aba abccba = empty
	 * string
	 */

	@Test
	public void example1() {
		String s = "abbaaba";
		assertEquals(adjacent(s), "aba");
	}

	@Test
	public void example2() {
		String s = "abccba";
		assertEquals(adjacent(s), "");
	}

	@Test
	public void example3() {
		String s = "aabbaacbbc";
		assertEquals(adjacent(s), "");
	}

	/*
	 * Psuedo Code
	 * 
	 * Create Map And Stack If map not contains character Then add the character
	 * (stack) If already added Then remove it (popup) & stack Empty return
	 * remaining character
	 * 
	 * abba aba
	 */

	private String adjacent(String s) {
		Map<Character, Character> map = new HashMap<>();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		char[] cha = s.toCharArray();
		for (Character c : cha) {
			if (!map.containsKey(c)) {
				map.put(c, c);
				stack.push(c);
			} else {
				if (!stack.isEmpty()) {
					if (stack.peek().equals(c)) {
						stack.pop();
					} else {
						stack.push(c);
					}
				} else {
					stack.push(c);
				}

			}

		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
 		return sb.toString();

	}

}
