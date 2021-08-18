package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class FindAllAnagrams {

	/**
	 * https://leetcode.com/problems/find-all-anagrams-in-a-string/ 438. Find All
	 * Anagrams in a String Medium
	 * 
	 * 4684
	 * 
	 * 209
	 * 
	 * Add to List
	 * 
	 * Share Given two strings s and p, return an array of all the start indices of
	 * p's anagrams in s. You may return the answer in any order. Example 1:
	 * 
	 * Input: s = "cbaebabacd", p = "abc" Output: [0,6] Explanation: The substring
	 * with start index = 0 is "cba", which is an anagram of "abc". The substring
	 * with start index = 6 is "bac", which is an anagram of "abc". Example 2:
	 * 
	 * Input: s = "abab", p = "ab" Output: [0,1,2] Explanation: The substring with
	 * start index = 0 is "ab", which is an anagram of "ab". The substring with
	 * start index = 1 is "ba", which is an anagram of "ab". The substring with
	 * start index = 2 is "ab", which is an anagram of "ab".
	 * 
	 * 
	 */
	/**
	 ** Travel from array start and check if character is either of the p string if
	 * all 3 string are same yes note index else traverse to next index repeat till
	 * array length Try with ASCII or HashMap or List Hint
	 **/

	/**
	 ** Store p in ascii array slide window from 0 to p.length store in ascii array
	 * if matches get index else slide to next
	 **/

	@Test
	public void test() {
		
		String s = "cbaebabacd";
		String p = "abc";
		Assert.assertTrue(Arrays.equals(new int[] { 0, 6 }, findIndexOfAnagram(s, p)));
	}

	private int[] findIndexOfAnagram(String s, String p) {
	
		// TODO Auto-generated method stub
		
		List<Character> pca = new ArrayList<Character>();
		for (int i = 0; i < p.length(); i++) {
			pca.add(p.charAt(i));
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < s.length() - p.length(); i++) {
			for (int j = i; j < s.length(); j++) {//chk till start to end of String
				//pca size equals current string length substring/map
				//if equal
				if (pca.contains(s.charAt(j))) {
					
					if (j == p.length()-1)
						list.add(i);

				} else
					break;

			}
		}

		int[] outResult = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			outResult[i] = list.get(i);
			System.out.println(outResult[i]);
		}
		return outResult;
	}

}
