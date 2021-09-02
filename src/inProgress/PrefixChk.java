package inProgress;

public class PrefixChk {
	/**
	 * 
	 * https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
	 * 1. Hashmap + Sliding window 2. 2 pointer 3. string.equals
	 */
	public int isPrefixOfWord(String sentence, String searchWord) {
		String[] s = sentence.split(" ");
		int k = 0;
		for (int i = 0; i < s.length; i++) {
			if (searchWord.length() <= s[i].length()) {
				if (s[i].substring(0, searchWord.length()).equals(searchWord)) {
					k = i + 1;
					break;
				}
			}
		}
		return (k > 0) ? k : -1;
	}
}
