package Stack;

public class MinRemoveToMakeValidParanthesis {
	/**
	 * 1249 https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
	 * 
	 * Given a string s of '(' , ')' and lowercase English characters.
	 * 
	 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any
	 * positions ) so that the resulting parentheses string is valid and return any
	 * valid string.
	 * 
	 * Formally, a parentheses string is valid if and only if:
	 * 
	 * It is the empty string, contains only lowercase characters, or It can be
	 * written as AB (A concatenated with B), where A and B are valid strings, or It
	 * can be written as (A), where A is a valid string.
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: s = "lee(t(c)o)de)" Output: "lee(t(c)o)de" Explanation: "lee(t(co)de)"
	 * , "lee(t(c)ode)" would also be accepted. Example 2:
	 * 
	 * Input: s = "a)b(c)d" Output: "ab(c)d" Example 3:
	 * 
	 * Input: s = "))((" Output: "" Explanation: An empty string is also valid.
	 * Example 4:
	 * 
	 * Input: s = "(a(b(c)d)" Output: "a(b(c)d)"
	 * 
	 * Input - String Output-String Constraint - Stack
	 * 
	 * 
	 **/

	public String minRemoveToMakeValid(String s) {
		int open = 0, close = 0;
		// count num of close parentheses
		for (char c : s.toCharArray()) {
			close += c == ')' ? 1 : 0;
		}
		StringBuilder ans = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				// check whether we have enough close parentheses left; if not, we should remove
				// this one.
				if (open >= close) {
					continue;
				}
				open++;
			} else if (c == ')') {
				close--;
				// not enough open parentheses
				if (open == 0) {
					continue;
				}
				open--;
			}
			ans.append(c);
		}
		return ans.toString();
	}

}
