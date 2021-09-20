package Stack;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDupCharacters {
	/**
	 * You are given a string s and an integer k, a k duplicate removal consists of
	 * choosing k adjacent and equal letters from s and removing them, causing the
	 * left and the right side of the deleted substring to concatenate together. We
	 * repeatedly make k duplicate removals on s until we no longer can. Return the
	 * final string after all such duplicate removals have been made. It is
	 * guaranteed that the answer is unique.   Example 1: Input: s = "abcd", k = 2
	 * Output: "abcd" Explanation: There's nothing to delete. Example 2: Input: s =
	 * "deeedbbcccbdaa", k = 3 Output: "aa" Explanation: First delete "eee" and
	 * "ccc", get "ddbbbdaa" Then delete "bbb", get "dada" Finally delete "ddd", get
	 * "aa"
	 * 
	 * Input-String,int Output-String
	 * 
	 * PseudoCode: 1.Intialize two stacks 2.Push character in first stack 3.Push
	 * char count in stack2 by peeking previous character count+1 4.When char
	 * count==k pop the character till character cunt becomes 0 5.return the
	 * characters in stack
	 * 
	 * 
	 */
	@Test
	public void test1() {
		String str = "abcd";
		int k = 2;
		Assert.assertEquals("abcd", removeDupUsingArrayList(str, k));
	}

	@Test
	public void test2() {
		String str = "deeedbbcccbdaa";
		int k = 3;
		Assert.assertEquals("aa", removeDupChar(str, k));
	}

	@Test
	public void test3() {
		String str = "adeeedbbcccbdaa";
		int k = 3;
		Assert.assertEquals("", removeDupUsingArrayList(str, k));
	}

	@Test
	public void test4() {
		String str = "adeeedbbcccbdaa";
		int k = 4;
		Assert.assertEquals("adeeedbbcccbdaa", removeDupUsingArrayList(str, k));
	}

//Time complexity - O(n) Space Complexity-O(2n)-->O(n)
	private String removeDupChar(String str, int k) { // O(n)
		// TODO Auto-generated method stub
		Stack<Character> charStack = new Stack<Character>();
		Stack<Integer> intStack = new Stack<Integer>();

		for (int i = 0; i < str.length(); i++) { // O(n)

			if (!charStack.isEmpty() && charStack.peek() == str.charAt(i)) {
				int lastCount = intStack.peek();
				intStack.push(lastCount + 1);
				charStack.push(str.charAt(i));
			} else {
				intStack.push(1);
				charStack.push(str.charAt(i));
			}

			if (intStack.peek() == k) {
				int temp = k;
				while (temp > 0) { // O(k)
					charStack.pop();
					intStack.pop();
					temp--;
				}

			}

		}

		StringBuilder output = new StringBuilder();
		for (Character c : charStack) {
			output.append(c);

		}
		return output.toString();
	}

	// Using StringBuilder and ArrayList

	/**
	 * from index 0 to String length append character in String Builder Store the
	 * count of each character in arraylist if arraylist value == k delete character
	 * from StringBuilder from index to index-2 delete count from the arraylist from
	 * index to index-2 return the StringBuilder value
	 * 
	 */

	public String removeDupUsingArrayList(String str, int k) {
		StringBuilder output = new StringBuilder();
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<Character> strList = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (!strList.isEmpty() && strList.get(strList.size() - 1).equals(str.charAt(i))) {
				intList.add(intList.get(intList.size() - 1) + 1);
				strList.add(str.charAt(i));
			} else {
				intList.add(1);
				strList.add(str.charAt(i));
			}
			if (intList.get(intList.size() - 1) == k) {

				int temp = k;
				while (temp > 0) {
					strList.remove(strList.size() - 1);
					intList.remove(intList.size() - 1);
					temp--;
				}
			}

		}
		for (Character c : strList) {
			output.append(c);
		}
		return output.toString();
	}

}
