package classLearn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesis {
	/**
	 * 
	 * Only use 3 different brackets confirm whether given string as valid
	 * paranthesis Stack,String Builder/String Buffer
	 * 
	 * [{(
	 * 
	 * input - String output -String
	 */

	@Test
	public void test1() {
		String str = "{[()]}";
		//Assert.assertEquals("Valid", isValid(str));
		Assert.assertEquals("Valid", isValidUsingStr(str));
	}

	@Test
	public void test2() {
		String str = "{[(]}";
		//Assert.assertEquals("Invalid", isValid(str));
		Assert.assertEquals("Invalid", isValidUsingStr(str));
	}

	@Test
	public void test3() {
		String str = "{[}]";
		//Assert.assertEquals("Invalid", isValid(str));
		Assert.assertEquals("Invalid", isValidUsingStr(str));
	}

	/**
	 * Pseudo Code
	 * 
	 * Have hasmap for opening bracket key as close bracket Push the str value in
	 * Stack peek the value in Stack if it matches the value in has map pop if Stack
	 * is empty return Valid else Invalid
	 * 
	 * @param str
	 * @return
	 */
	private String isValid(String str) {
		// TODO Auto-generated method stub
		Stack<Character> charStack = new Stack<Character>();
		HashMap<Character, Character> charMap = new HashMap<Character, Character>();
		charMap.put('}', '{');
		charMap.put(')', '(');
		charMap.put(']', '[');

		for (int i = 0; i < str.length(); i++) {
			if (charStack.isEmpty()) {
				charStack.push(str.charAt(i));
			} else {
				if (charStack.peek().equals(charMap.get(str.charAt(i)))) {
					charStack.pop();
				}else
					charStack.push(str.charAt(i));
			}
		}
		if (charStack.isEmpty())
			return "Valid";
		else
			return "Invalid";
	}
	/**
	 * Using String Builder
	 * 
	 * Map the close brackets with open brackets
	 * add character to the StringBuilder
	 * if the incoming value is key of map then delete char at index i-1
	 * chk if the String Builder is empty
	 * if empty return Valid
	 * else
	 * return Invalid
	 * 
	 * First index and last index
	 */
	private String isValidUsingStr(String input) {
		StringBuilder s=new StringBuilder();
		
		HashMap<Character, Character> charMap = new HashMap<Character, Character>();
		charMap.put('}', '{');
		charMap.put(')', '(');
		charMap.put(']', '[');
		
		for(int i=0;i<input.length();i++) {
			if(s.isEmpty()) {
			s.append(input.charAt(i));
			System.out.println("Length "+s.length());
			}
			else {
				if(s.charAt(s.length())==charMap.get(s.charAt(s.length()))) {
					s.deleteCharAt(s.length());
				}else
					s.append(input.charAt(i));
			}
			
		}
		if (s.isEmpty())
			return "Valid";
		else
			return "Invalid";
	}
	
	//https://leetcode.com/problems/valid-parentheses/submissions/
	public boolean isValidLeetCode(String s) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		Stack<Character> stack = new Stack<Character>();
		char[] ch = s.toCharArray();
		System.out.println(ch);
		for (Character c : s.toCharArray()) {
			if (!stack.isEmpty()) {
				if (stack.peek().equals(map.get(c)))
					stack.pop();
				else
					stack.push(c);

			} else {
				stack.push(c);
			}
		}

		if (stack.isEmpty())
			return true;
		else
			return false;
	}
}
