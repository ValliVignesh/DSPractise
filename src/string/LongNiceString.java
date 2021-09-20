package string;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class LongNiceString {
//https://leetcode.com/problems/longest-nice-substring

	@Test
	public void test1() {
		String s = "YazaAay";
		// Assert.assertEquals("aAa", longestNiceSubstring(s));
		Assert.assertEquals(3, longestNiceSubstring(s));
	}

	@Test
	public void test2() {
		String s = "azABaabbza";
		Assert.assertEquals(6, longestNiceSubstring(s));
	}

	@Test
	public void test3() {
		String s = "TacoCat";
		Assert.assertEquals(-1, solution(s));
	}

	@Test
	public void test4() {
		String s = "AcZCbaBz";
		Assert.assertEquals(8, longestNiceSubstring(s));
	}

	private String longString(String s) {
		Set<Character> charSet = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			charSet.add(s.charAt(i));
		}
		for (int i = 0; i < s.length(); i++) {
			if (charSet.contains(Character.toUpperCase(s.charAt(i)))
					&& charSet.contains(Character.toLowerCase(s.charAt(i)))) {
				continue;
			}
			String s1 = longString(s.substring(0, i));
			String s2 = longString(s.substring(i + 1));
			return s1.length() >= s2.length() ? s1 : s2;
		}
		return s;
	}

	public int longestNiceSubstring(String s) {
		Set<Character> charSet = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			charSet.add(s.charAt(i));
		}
		for (int i = 0; i < s.length(); i++) {
			if (charSet.contains(Character.toUpperCase(s.charAt(i)))
					&& charSet.contains(Character.toLowerCase(s.charAt(i)))) {
				continue;
			}
			int s1 = longestNiceSubstring(s.substring(0, i));
			int s2 = longestNiceSubstring(s.substring(i + 1));
			return s1 >= s2 ? s1 : s2;
		}
		if (s.length() == 0)
			return -1;
		else
			return s.length();
	}

	// Using Sliding Window

	public int solution(String S) {
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 0; j < S.length() - i + 1; j++) {
				Set<Character> lower = new HashSet<>();
				Set<Character> upper = new HashSet<>();
				String minBalanced = S.substring(j, j + i);
				char[] minChar = minBalanced.toCharArray();
				for (char ch : minChar) {
					if (Character.isLowerCase(ch))
						lower.add(ch);
					else
						upper.add(ch);
				}
				if (convertToLower(upper).containsAll(lower) && lower.containsAll(convertToLower(upper)))
					return minBalanced.length();
			}
		}
		return -1;
	}

	private Set<Character> convertToLower(Set<Character> set) {
		Set<Character> lower = new HashSet<>();
		for (Character ch : set)
			lower.add(Character.toLowerCase(ch));
		return lower;
	}
}
