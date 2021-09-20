package interviewQuestions;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class LengthOfLongSubStringWithoutRepeatingChar {
	/**
	 * Given length of longest string without repeating any character
	 * 
	 * input String Output - int
	 */

	@Test
	public void test1() {
		String str = "aabaabc";
		Assert.assertEquals(3, findLongSubstringWithoutRepeatingChar(str));

	}

	@Test
	public void test2() {
		String str = "aabaabcde";
		Assert.assertEquals(5, findLongSubstringWithoutRepeatingChar(str));

	}

	@Test
	public void test3() {
		String str = "bbbbb";
		Assert.assertEquals(1, findLongSubstringWithoutRepeatingCharMap(str));

	}

	@Test
	public void test4() {
		String str = "pwwkew";
		Assert.assertEquals(3, findLongSubstringWithoutRepeatingCharMap(str));

	}

	@Test
	public void test5() {
		String str = "";
		Assert.assertEquals(-1, findLongSubstringWithoutRepeatingChar(str));

	}

	@Test
	public void test6() {
		String str = "abababc";
		Assert.assertEquals(3, findLongSubstringWithoutRepeatingChar(str));

	}

	private int findLongSubstringWithoutRepeatingCharMap(String s) {
		//https://www.youtube.com/watch?v=gHNMSeeu_4Q
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0, max = 0;
		if (s.length() == 0)
			return 0;
		for (int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			if (map.containsKey(c)) {
				if (left <= map.get(c)) {
					left = map.get(c) + 1;
				}
			}
			max = Math.max(max, right - left + 1);
			map.put(c, right);
		}
		return max;
	}

	private int findLongSubstringWithoutRepeatingChar(String str) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		int left = 0, right = 0;
		int[] ca = new int[128];
		while (right < str.length()) {// O(n) Space - O(n)
			if (ca[str.charAt(right)] == 0)
				ca[str.charAt(right++)]++;
			else {
				while (ca[str.charAt(right)] > 0) {
					// ca[str.charAt(right)]--;
					ca[str.charAt(left)]--;
					left++;
				}

			}
			max = Math.max(max, right - left);
		}
		if (max == Integer.MIN_VALUE)
			return -1;
		else
			return max;
	}
}
