package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class DictonaryWordsSegmentation {
	/**
	 * This question is asked by Amazon. Given a string s and a list of words
	 * representing a dictionary, return whether or not the entirety of s can be
	 * segmented into dictionary words. Note: You may assume all characters in s and
	 * the dictionary are lowercase.
	 * 
	 * Ex: Given the following string s and dictionary…
	 * 
	 * s = "thedailybyte", dictionary = ["the", "daily", "byte"], return true.
	 * 
	 * Ex: Given the following string s and dictionary…
	 * 
	 * s = "pizzaplanet", dictionary = ["plane", "pizza"], return false.
	 */
	/**
	 * String -->stringbuilder if dict content in stringbuilder delete in string
	 * builder dictionary array ends if there any char remaining in string builder
	 * false return true;
	 */
	@Test
	public void test1() {
		String str = "thedailybyte";
		String[] dict = { "the", "daily", "byte" };
		Assert.assertEquals(true, findDictWords(str, dict));
	}

	@Test
	public void test2() {
		String str = "pizzaplanet";
		String[] dict = { "plane", "pizza" };
		Assert.assertEquals(false, findDictWords(str, dict));
	}

	@Test
	public void test3() {
		String str = "cars";
		String[] dict = { "car", "rs", "ar" };
		Assert.assertEquals(true, findDictWords(str, dict));
	}

	private boolean findDictWords(String str, String[] dict) {
		// TODO Auto-generated method stub
		// StringBuilder sb = new StringBuilder(str);
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) { //O(n)
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}

		for (int i = 0; i < dict.length; i++) {
			char[] ca = dict[i].toCharArray();
			for (int j = 0; j < ca.length; j++) {
				map.put(ca[j], map.getOrDefault(ca[j], 0) + 1);
			}
		}

		for (Entry<Character, Integer> entrySet : map.entrySet()) {
			if (entrySet.getValue() == 1)
				return false;
		}
		return true;
	}
}
