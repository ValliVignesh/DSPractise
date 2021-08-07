package interviewQuestions;

import java.util.ArrayDeque;
import java.util.HashMap;
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

	private int findLongSubstringWithoutRepeatingCharStack(String str) {
		// TODO Auto-generated method stub

		return 0;
	}

	private int findLongSubstringWithoutRepeatingChar(String str) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		int left = 0, right = 0;
		char[] ca = new char[128];
		while (right < str.length()) {//O(n)
			if (ca[str.charAt(right)] == 0)
				ca[str.charAt(right++)]++;
			else {
				while (ca[str.charAt(right)] != 0) {
					ca[str.charAt(right)]--;
				}
				left++;

			}
			max=Math.max(max, right-left);
		}

		return max;
	}
}
