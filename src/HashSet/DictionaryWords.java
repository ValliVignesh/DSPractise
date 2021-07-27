package HashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class DictionaryWords {
	/**
	 * 2)Given a string s and a dictionary of strings wordDict, return true if s can
	 * be segmented into a space-separated sequence of one or more dictionary words.
	 * Note that the same word in the dictionary may be reused multiple times in the
	 * segmentation.   Example 1: Input: s = "leetcode", wordDict = ["leet","code"]
	 * Output: true Explanation: Return true because "leetcode" can be segmented as
	 * "leet code". Example 2: Input: s = "applepenapple", wordDict =
	 * ["apple","pen"] Output: true Explanation: Return true because "applepenapple"
	 * can be segmented as "apple pen apple". Note that you are allowed to reuse a
	 * dictionary word. Example 3: Input: s = "catsandog", wordDict =
	 * ["cats","dog","sand","and","cat"] Output: false --HashSet
	 */

	@Test
	public void test1() {
		String s = "leetcode";
		List<String> dict = new ArrayList<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(wordBreak(s, dict));

	}
	@Test
	public void test2() {
		String s = "catsandog";
		List<String> dict = new ArrayList<String>();
		dict.add("cats");
		dict.add("dog");
		dict.add("sand");
		dict.add("and");
		dict.add("cat");
		System.out.println(wordBreak(s, dict));

	}
	@Test
	public void test3() {
		String s = "leetcode";
		List<String> dict = new ArrayList<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(wordBreak(s, dict));

	}

	public boolean wordBreak(String s, List<String> wordList) {
		boolean[] dp = new boolean[s.length() + 1];
		Set<String> set = new HashSet<>();
		for (String word : wordList) {
			set.add(word);
		}
		dp[0] = true;
		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && set.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
