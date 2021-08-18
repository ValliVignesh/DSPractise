package string;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

import junit.framework.Assert;

public class PermutationString {
	/**
	 * https://leetcode.com/problems/permutation-in-string/
	 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
	 *  567. Permutation in
	 * String Medium
	 * 
	 * 2802
	 * 
	 * 84
	 * 
	 * Add to List
	 * 
	 * Share Given two strings s1 and s2, return true if s2 contains a permutation
	 * of s1, or false otherwise.
	 * 
	 * In other words, return true if one of s1's permutations is the substring of
	 * s2.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: s1 = "ab", s2 = "eidbaooo" Output: true Explanation: s2 contains one
	 * permutation of s1 ("ba"). Example 2:
	 * 
	 * Input: s1 = "ab", s2 = "e idboaoo" Output: false
	 */
	@Test
	public void test() {
		String s1 = "ab";
		String s2 = "eidbaooo";
		Assert.assertEquals(true, findPermuString(s1, s2));
	}

	private boolean findPermuString(String s1, String s2) {
		// TODO Auto-generated method stub
		int[] asciiTarget = new int[128];
		for (int i = 0; i < s1.length(); i++) {
			asciiTarget[s1.charAt(i)]++;
		}
		int[] asciiInput = new int[128];
		for (int i = 0; i < s2.length(); i++) {
			asciiInput[s2.charAt(i)]++;
			if (i == s1.length()-1) {
				if (Arrays.equals(asciiTarget, asciiInput))
					return true;
				else {
					for (int j = 0; j < asciiTarget.length; j++) {
						asciiInput[j] = 0;
					}
			} 

			}
		}

		/*
		 * HashMap<Character, Integer> map1 = new HashMap<Character, Integer>(); for
		 * (int i = 0; i < s1.length(); i++) { map1.put(s1.charAt(i),
		 * map1.getOrDefault(s1.charAt(i), 0) + 1); } HashMap<Character, Integer> map2 =
		 * new HashMap<Character, Integer>(); for (int i = 0; i < s2.length(); i++) {
		 * map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1); } for(int
		 * i=0;i<s1.length();i++) {
		 * if(map2.get(s1.charAt(i)).equals(map1.get(s1.charAt(i)))) return true;
		 * 
		 * }
		 **/
		return false;
	}
}
