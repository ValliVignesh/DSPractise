package paloaltonetworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class ShortestBalancedString {

	@Test
	public void test1() {
		String s = "azABaabza";
		Assert.assertEquals(5, solution5(s));
	}

	@Test
	public void test2() {
		String s = "TacoCat";
		Assert.assertEquals(-1, solution5(s));
	}

	@Test
	public void test3() {
		String s = "AcZCbaBz";
		Assert.assertEquals(8, solution5(s));
	}

	@Test
	public void test4() {
		String s = "aA";
		Assert.assertEquals(2, solution5(s));
	}

	@Test
	public void test5() {
		String s = "abcdefgh";
		Assert.assertEquals(-1, solution5(s));
	}

	public int solution1(String S) {
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

	private int solution2(String s) {
		int k = 2;
		String balString = "";
		while (k <= s.length()) {
			String str = "";
			for (int i = 0; i < k; i++) {
				str += s.charAt(i);
			}
			if (isBalanced(str)) {
				balString = str;
			}
			for (int j = k; j < s.length(); j++) {
				String s2 = str.substring(1);
				str = s2 + s.charAt(j);
				if (isBalanced(str)) {
					if (balString.length() < str.length()) {
						balString = str;
					}
				}
			}
			k++;
		}
		return balString.length() <= 0 ? -1 : balString.length();
	}

	private boolean isBalanced(String str) {
		for (int i = 0; i < str.length(); i++) {
			if ((Character.isLowerCase(str.charAt(i)) && !str.contains(String.valueOf(str.charAt(i)).toUpperCase()))
					|| (Character.isUpperCase(str.charAt(i))
							&& !str.contains(String.valueOf(str.charAt(i)).toLowerCase()))) {
				return false;
			}
		}
		return true;
	}

	private int solution3(String s) {
		HashSet<Character> lowerChars = new HashSet<>();
		HashSet<Character> upperChars = new HashSet<>();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (Character.isLowerCase(s.charAt(i)))
				lowerChars.add(chars[i]);
			else
				upperChars.add(chars[i]);
		}
		int left = 0, right = 0, length = -1;
		while (right < s.length()) {
			if (lowerChars.contains(Character.toLowerCase(s.charAt(right)))
					&& upperChars.contains(Character.toUpperCase(s.charAt(right)))) {
				length = Math.max(length, right - left + 1);
				right++;
			} else {
				left += 2;
				right = left;
			}
		}
		if (length == 1 || length == 0)
			return -1;
		return length;
	}

	private int solution4(String s) {
		int[] lowerChars = new int[26];
		int[] upperChars = new int[26];
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (Character.isLowerCase(s.charAt(i)))
				lowerChars[s.charAt(i) - 'a']++;
			else
				upperChars[s.charAt(i) - 'A']++;
		}
		int left = 0, right = 0, length = -1;
		while (right < s.length()) {
			if (lowerChars[Character.toLowerCase(s.charAt(right)) - 'a'] > 0
					&& upperChars[Character.toUpperCase(s.charAt(right)) - 'A'] > 0) {
				length = Math.max(length, right - left + 1);
				right++;
			} else {
				right = left += 2;
			}
		}
		return length == 1 || length == 0 ? -1 : length;
	}

	private int solution5(String s) {
		Set<Character> lower = new HashSet<>();
		Set<Character> upper = new HashSet<>();
		Set<Character> lowerTemp = new HashSet<>();
		Set<Character> upperTemp = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (Character.isUpperCase(c))
				upper.add(c);
			else
				lower.add(c);
		}
		if (lower.isEmpty() || upper.isEmpty())
			return -1;
		int left = 0, right = 0;
		while (right < s.length()) {
			char current = s.charAt(right);
			if (lower.contains(Character.toLowerCase(current)) && upper.contains(Character.toUpperCase(current))) {
				if (Character.isLowerCase(current))
					lowerTemp.add(current);
				else
					upperTemp.add(Character.toLowerCase(current));
			} else {
				while (left <= right) {
					char remove = s.charAt(left);
					if (Character.isLowerCase(remove))
						lowerTemp.remove(remove);
					else
						upperTemp.remove(Character.toLowerCase(remove));
					left++;
				}
			}
			if (!lowerTemp.isEmpty() && !upperTemp.isEmpty() && lowerTemp.equals(upperTemp))
				return right - left + 1;
			right++;
		}
		return -1;
	}
}
