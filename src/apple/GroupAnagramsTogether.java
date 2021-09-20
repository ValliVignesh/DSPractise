package apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class GroupAnagramsTogether {
	/**
	 * Given an array of strings strs, group the anagrams together. You can return
	 * the answer in any order. An Anagram is a word or phrase formed by rearranging
	 * the letters of a different word or phrase, typically using all the original
	 * letters exactly once. List<List<String>>   Example 1: Input: strs =
	 * ["eat","tea","tan","ate","nat","bat"] Output:
	 * [["bat"],["nat","tan"],["ate","eat","tea"]] Example 2: Input: strs = [""]
	 * Output: [[""]] Example 3: Input: strs = ["a"] Output: [["a"]]
	 */

	@Test
	public void test1() {
		List<String> list1 = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
		findAllAnagramslist(list1);
	}

	/*
	 * create a <List<List output list , create a HashMap iterate the give string
	 * list take each string and initialize a int array add the ascii of that each
	 * character in a string arr[0] = char c- 97; pass the int array to map key and
	 * assign the string in the respective value if map.contains that ascii array,
	 * append the string value , with the exiting values else add the ascii array
	 * and corresponding string values in to the map. by using entry set getValue()
	 * from the map return the value list .
	 */
	public List<List<String>> findAllAnagramslist(List<String> list1) {
		Map<String, List<String>> mymap = new HashMap<String, List<String>>();
		for (int i = 0; i < list1.size(); i++) {
			int[] arr = new int[26];
			String temp = list1.get(i);
			StringBuilder s;
			for (int j = 0; j < temp.length(); j++) {
				arr[temp.charAt(j) - 97]++;
			}
			List<String> s1 = new ArrayList<String>();
			if (mymap.containsKey(Arrays.toString(arr))) {
				s1.addAll(mymap.get(Arrays.toString(arr)));
				s1.add(temp);
				mymap.put(Arrays.toString(arr), s1);
			} else {
				s1.add(temp);
				mymap.put(Arrays.toString(arr), s1);
			}
		}
		System.out.println(new ArrayList<>(mymap.values()));
		return new ArrayList<>(mymap.values());

	}
//https://leetcode.com/problems/group-anagrams
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> mymap = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			int[] arr = new int[26];
			String temp = strs[i];
			StringBuilder s;
			for (int j = 0; j < temp.length(); j++) {
				arr[temp.charAt(j) - 97]++;
			}
			List<String> s1 = new ArrayList<String>();
			if (mymap.containsKey(Arrays.toString(arr))) {
				s1.addAll(mymap.get(Arrays.toString(arr)));
				s1.add(temp);
				mymap.put(Arrays.toString(arr), s1);
			} else {
				s1.add(temp);
				mymap.put(Arrays.toString(arr), s1);
			}
		}
		System.out.println(new ArrayList<>(mymap.values()));
		return new ArrayList<>(mymap.values());
	}
}
