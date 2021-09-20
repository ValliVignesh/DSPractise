package classLearn;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class LongestSubString {
	/**
	 * q1) Longest Substring without repeating character
	 * 
	 * 
	 * Given a string s, find the length of the longest substring without repeating
	 * characters.
	 * 	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: s = "abcabcbb" Output: 3 
	 * Explanation: The answer is "abc", with the
	 * length of 3.
	 * 
	 *  Example 2:	  
	 * Input: s = "bbbbb" Output: 1
	 *  Explanation: The answer is "b", with the length
	 * of 1.
	 *  Example 3: 
	 * Input: s = "pwwkew" Output: 3
	 *  Explanation: The answer is "wke", with the
	 * length of 3. Notice that the answer must be a substring, "pwke" is a
	 * subsequence and not a substring. 
	 * 
	 * Example 4:
	 * 
	 * Input: s = "" Output: 0
	 * 
	 * Input- String
	 * Output-int
	 * 
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
		Assert.assertEquals(1, findLongSubstringWithoutRepeatingChar(str));

	}

	@Test
	public void test4() {
		String str = "pwwkew";
		Assert.assertEquals(3, findLongSubstringWithoutRepeatingChar(str));

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

	private int findLongSubstringWithoutRepeatingCharStack(String str) {
		// TODO Auto-generated method stub

		return 0;
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
	public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, counter = 0, d = 0;

        while (end < s.length()) {
            // > 0 means repeating character
            //if(map[s.charAt(end++)]-- > 0) counter++;
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > 1) counter++;
            end++;
            
            while (counter > 0) {
                //if (map[s.charAt(begin++)]-- > 1) counter--;
                char charTemp = s.charAt(begin);
                if (map.get(charTemp) > 1) counter--;
                map.put(charTemp, map.get(charTemp)-1);
                begin++;
            }
            d = Math.max(d, end - begin);
        }
        return d;
    }
}
