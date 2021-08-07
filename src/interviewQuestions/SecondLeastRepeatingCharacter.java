package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class SecondLeastRepeatingCharacter {
	/**
	 * Given a string return the second least character in alphabetical order String
	 * s="Amazon" A-2,m-1,n-1,o-1,z-1,Output - char - n
	 * 
	 * if there is only one character what to return how about lower and upper case
	 * simple test data - aabbccde
	 */
	@Test
	public void test1() { // non-aphabeteical o
		String str = "Amazon";
		Assert.assertEquals('n', findSecLeastRepeatChar_Alpha(str));

	}

	@Test
	public void test2() {
		String str = "Wonder";// non-alphabetical r
		Assert.assertEquals('e', findSecLeastRepeatChar_Alpha(str));

	}

	/***
	 * traverse from the string and store in hash map with the letters and count
	 * 
	 * @param str
	 * @return
	 */

	private char findSecondLeastRepeatingChar_Alphabetical(String str) {
		// TODO Auto-generated method stub
		str = str.toLowerCase();
		char[] ca = str.toCharArray();
		/**
		 * Tree map insert
		 * 
		 */
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < ca.length; i++) {
			map.put(ca[i], map.getOrDefault(ca[i], 0) + 1);
		}
		int x = 0;
		for (Entry<Character, Integer> entry : map.entrySet()) {// O(n)
			if (entry.getValue() == 1) {
				x++;
				if (x == 2) {
					System.out.println(entry.getKey());
					return entry.getKey();
				}

			}
		}

		return 'a';
	}

	// NoMap - no constraint

	private char findSecLeastRepeatChar_nonAlphabetical(String str) {
		// TODO Auto-generated method stub

		int firstMin = 0;
		int secondMin = 0;

		str = str.toLowerCase();

		int[] asciiCount = new int[128];

		for (int i = 0; i < str.length(); i++) {
			asciiCount[str.charAt(i)]++;
		}

		for (int i = 0; i < 127; i++) {
			if (asciiCount[i] > asciiCount[i + 1]) {
				secondMin = firstMin;
				firstMin = i;
			} else if (asciiCount[i] > asciiCount[secondMin] && asciiCount[i] != asciiCount[firstMin]) {
				secondMin = i;
			}
		}

		return (char) secondMin;
	}

	private char findSecLeastRepeatChar_Alpha(String str) {
		// TODO Auto-generated method stub

		int firstMin = 0;
		int secondMin = 0;

		str = str.toLowerCase();

		int[] asciiCount = new int[128];
		ArrayList<Character> minArray = new ArrayList<Character>();
		ArrayList<Character> array = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			asciiCount[str.charAt(i)]++;
		}
		int j = 0;
		for (int i = 0; i < str.length(); i++) {
			if (asciiCount[str.charAt(i)] == 1) {
				minArray.add(str.charAt(i));
			}
		}

		for (Character data : minArray) {
			if (data != null) {
				array.add(data);
			}
		}
		Collections.sort(array);
		return array.get(1);

	}
}
