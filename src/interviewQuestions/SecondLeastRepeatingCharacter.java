package interviewQuestions;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

import junit.framework.Assert;

public class SecondLeastRepeatingCharacter {
	/**
	 * Given a string return the second least character in alphabetical order String
	 * s="Amazon" A-2,m-1,n-1,z-1,o-1 Output - char - n
	 * 
	 * if there is only one character what to return
	 * how about lower and upper case simple test data - aabbccde
	 */
	@Test
	public void test1() {
		String str = "Amazon";
		Assert.assertEquals('n', findSecondLeastRepeatingChar(str));

	}

	@Test
	public void test2() {
		String str = "Wonder";

	}
	
	/***
	 * traverse from the string and store in hash map with the letters and count
	 * 
	 * @param str
	 * @return
	 */

	private char findSecondLeastRepeatingChar(String str) {
		// TODO Auto-generated method stub
		Arrays.sort(str.toCharArray());
		str = str.toLowerCase();
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<str.length();i++) {
		map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
		}

		return (Character) null;
	}

	// NoMap - no constraint

	private char findSecLeastRepeatChar(String str) {
		// TODO Auto-generated method stub
		str = str.toLowerCase();
		int[] asciiCounter = new int[26];
		for (int i = 0; i < str.length(); i++) {
			asciiCounter[str.charAt(i)]++;
		}
		for (int i = 0; i < asciiCounter.length; i++) {
			if (asciiCounter[i] < asciiCounter[i + 1]) {

			}
		}
		Arrays.sort(asciiCounter);

		return 'a';
	}
}
