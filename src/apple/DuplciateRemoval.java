package apple;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class DuplciateRemoval {
	/**
	 * You are given a string s and an integer k, a k duplicate removal consists of
	 * choosing k adjacent and equal letters from s and removing them, causing the
	 * left and the right side of the deleted substring to concatenate together. We
	 * repeatedly make k duplicate removals on s until we no longer can. Return the
	 * final string after all such duplicate removals have been made. It is
	 * guaranteed that the answer is unique.   Example 1: Input: s = "abcd", k = 2
	 * Output: "abcd" Explanation: There's nothing to delete. Example 2: Input: s =
	 * "deeedbbcccbdaa", k = 3 Output: "aa" Explanation: First delete "eee" and
	 * "ccc", get "ddbbbdaa" Then delete "bbb", get "dddaa" Finally delete "ddd",
	 * get "aa" Example 3: Input: s = "pbbcggttciiippooaais", k = 2 Output: "ps"
	 */
	@Test
	public void testcase1() {
		String s = "abcd";
		int k = 2;
		Assert.assertEquals("abcd", removeDuplicates(s, k));
	}

	@Test
	public void testcase2() {
		String s = "deeedbbcccbdaa";
		int k = 3;
		Assert.assertEquals("aa", removeDuplicates(s, k));
	}

	@Test
	public void testcase3() {
		String s = "pbbcggttciiippooaais";
		int k = 2;
		Assert.assertEquals("ps", removeDuplicates(s, k));
	}

	/*
	 * Define character stack and integer stack if the stack is empty or peek
	 * element is not equal to the incoming character 1. push the incoming character
	 * to character stack and 2.push 1 into the integer stack
	 *
	 *
	 * If the peek element is matched with the input characcter , --> push the input
	 * charac to the stack --> increment the peak element value by one and push the
	 * incremented value to the stack ' --> if the peak element in the integer stack
	 * becomes equal to K do pop the characters from character stack and do pop the
	 * integer from Integer stack --> k times .
	 * 
	 * 
	 * 
	 * At the end of the iteration , form a string with the left out characters from
	 * the stack .
	 * 
	 */
	private String removeDuplicates(String s, int k) {
		Stack<Character> characterstack = new Stack<Character>();
		Stack<Integer> intgerstack = new Stack<Integer>();
		StringBuilder outputstr = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char inputchar = s.charAt(i);

			if (characterstack.isEmpty() || characterstack.peek() != inputchar) {
				characterstack.push(inputchar);
				intgerstack.push(1);
			} else if (characterstack.peek() == inputchar) {

				Integer peek = intgerstack.peek();
				peek++;
				characterstack.push(inputchar);
				intgerstack.push(peek);
				if (intgerstack.peek() == k) {
					for (int j = 0; j < k; j++) {
						characterstack.pop();
						intgerstack.pop();
					}
				}

			}

		}

		int size = characterstack.size();
		for (int i = 0; i < size; i++) {
			outputstr.append(characterstack.pop());
		}
		String reverse = outputstr.reverse().toString();
		System.out.println(reverse);
		return reverse;

	}
}
