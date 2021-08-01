package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class StringTwoAnagraminString1 {

	/**
	 * Two string str1, str2 all start index of str2's anagram in s1 all possible
	 * matches
	 * 
	 * 
	 * S1 - abcdbac str2 -abc Output- 0,4
	 * 
	 * Input - 2 String Ouptu -Integer array
	 */
	/**
	 * 
	 * Store s2 in ascii counter array Chk if the
	 */
	@Test
	public void test1() {
		String s1 = "abcdbac";
		String s2 = "abc";
		Assert.assertTrue(Arrays.equals(new Integer[] {0,4}, findAnagram(s1,s2)));
	}

	@Test
	public void test2() {
		String s1 = "abcdbac";
		String s2 = "";
	}

	@Test
	public void test3() {
		String s1 = "acddcf";
		String s2 = "fg";
	}
	//26,52,128,256 -  if s2 can be greater than s1 || if no s2 value in s1 what should we do

	public Object[] findAnagram(String s1, String s2) {
		s1=s1.toLowerCase();
		s2=s2.toLowerCase();
		ArrayList<Integer> n=new ArrayList<Integer>();
		HashMap<Character, Integer> s2Map = new HashMap<Character, Integer>();
		HashMap<Character, Integer> s1Map = new HashMap<Character, Integer>();
		for (int i = 0; i < s2.length(); i++) {
			s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2Map.get(s2.charAt(i)), 0 + 1));
		}
		for (int i = 0; i < s2.length(); i++) {
			s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1Map.get(s2.charAt(i)), 0 + 1));
		}
		if(s2Map.equals(s1Map)) {
			n.add(0);
		}
		for (int i = 1; i < s1.length(); i++) {
			s1Map.put(s2.charAt(i), s1Map.getOrDefault(s1Map.get(s2.charAt(i)), 0 + 1));
			
			if(s2Map.equals(s1Map)) {
				n.add(i);
			}
		}
		System.out.println(n.toString());
		return n.toArray();

	}
}
