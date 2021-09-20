package string;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class MaxVowelsInGivenString {
//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

	@Test
	public void test1() {
		String s = "abciiidef";
		int k = 3;
		Assert.assertEquals(3, maxVowels(s, k));
	}

	@Test
	public void test2() {
		String s = "tryhard";
		int k = 4;
		Assert.assertEquals(1, maxVowels(s, k));
	}

	@Test
	public void test3() {
		String s = "weallloveyou";
		int k = 7;
		Assert.assertEquals(4, maxVowels(s, k));
	}

	private int maxVowels(String s, int k) {
		// TODO Auto-generated method stub
		List<Character> c = new ArrayList<Character>();
		c.add('a');
		c.add('e');
		c.add('i');
		c.add('o');
		c.add('u');

		int windowCount = 0;

		int maxCount = 0;
		if (k > s.length())
			return -1;
		for (int i = 0; i < k; i++) {
			if (c.contains(s.charAt(i))) {
				windowCount++;

			}
		}
		maxCount = windowCount;

		for (int i = 1; i <= s.length() - k; i++) {
			if (c.contains(s.charAt(i - 1))) {
				windowCount--;

			}
			if (c.contains(s.charAt(i + k - 1))) {
				windowCount++;

			}
			maxCount = Math.max(maxCount, windowCount);

		}

		return maxCount;

	}
}
