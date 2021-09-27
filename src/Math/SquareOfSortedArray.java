package Math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class SquareOfSortedArray {
//https://leetcode.com/problems/squares-of-a-sorted-array/

	/**
	 * # 1. If a word in the string is after a comma, insert a comma before every
	 * duplicate of the same word # 2. If a word in the string is before a comma,
	 * insert a comma after every duplicate of the same word # Write a method to
	 * change text according to the rules until no more commas can be added. #
	 * Input: # pray jump spy. jump spy, jump. spy ally now ally. # Output: #
	 * pray,jump spy. jump spy, jump. spy, ally now, ally.
	 **/

	// pray jump spy. jump spy, jump. spy ally now ally.
	// pray ,jump spy. jump spy, jump. spy, ally now, ally.

	/**
	 * Input - String Output- String
	 * 
	 * Test data -
	 * 
	 * PseudoCode- SPlit the String with space
	 * 
	 * Check for the character comma and the string before and after it traverse
	 * through the string insert , before the string and after
	 * 
	 * Using Two pointer and Set
	 * 
	 * Time Complexity- O(nm)
	 * 
	 */

	@Test
	public void test1() {
		String s = "pray jump spy. jump spy, jump. spy ally now ally.";
		Assert.assertEquals("pray ,jump spy. jump spy, jump. spy, ally now, ally.", insertComma(s));

	}

	private String insertComma(String s) {
		String str = "";
		int left = 0, right = 0;
		String[] inputArr = s.split(" ");

		Set<String> dupSet = new HashSet<String>();
		Map<String, String> map = new HashMap<String, String>();

		while (right < s.length()) {
			if (inputArr[right].contains(",")) {
				dupSet.add(inputArr[right]);
				map.put(inputArr[right], "after");
				dupSet.add("," + inputArr[right + 1]);
				map.put(inputArr[right + 1], "before");
				while (left < right) {
					if ((dupSet.contains(inputArr[left])) && (!inputArr[left].contains("."))) {
						if (map.get(inputArr[left]).equals("before")) {

						}
					}
				}
			}
		}

		// TODO Auto-generated method stub
		return str;
	}

}
