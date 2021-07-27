package Stack;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class SimplifyPath {
	/**
	 * Given a string path, which is an absolute path (starting with a slash '/') to
	 * a file or directory in a Unix-style file system, convert it to the simplified
	 * canonical path. In a Unix-style file system, a period '.' refers to the
	 * current directory, a double period '..' refers to the directory up a level,
	 * and any multiple consecutive slashes (i.e. '//') are treated as a single
	 * slash '/'. For this problem, any other format of periods such as '...' are
	 * treated as file/directory names. The canonical path should have the following
	 * format:
	 * 
	 * The path starts with a single slash '/'. Any two directories are separated by
	 * a single slash '/'. The path does not end with a trailing '/'. The path only
	 * contains the directories on the path from the root directory to the target
	 * file or directory (i.e., no period '.' or double period '..') Return the
	 * simplified canonical path.
	 * 
	 * Example 1: Input: path = "/home/" Output: "/home" Explanation: Note that
	 * there is no trailing slash after the last directory
	 * 
	 * Example 2:
	 * 
	 * Input: path = "/../" Output: "/" Explanation: Going one level up from the
	 * root directory is a no-op, as the root level is the highest level you can go.
	 * Example 3:
	 * 
	 * Input: path = "/home//foo/" Output: "/home/foo" Explanation: In the canonical
	 * path, multiple consecutive slashes are replaced by a single one.
	 * 
	 * Example 4:
	 * 
	 * Input: path = "/a/./b/../../c/"--> Output: "/c"
	 */

	/**
	 * 
	 * Input - String Output - String
	 * 
	 * PseudoCode-
	 * 
	 * pushing char from string to stack
	 * 
	 * if char is . chk previous element in array is also . if so pop until next
	 * char else if char is . no need to do anything (dont push or pop) if char is /
	 * chk if previous value in stack is / ignore it
	 * 
	 * String to Character array for each character push in stack based on below
	 * conditions: if my character is . and the character before the index is also .
	 * pop till the character else dont do anything if my char is / and the char
	 * before is also slash ignore slash if stack has last pop char / --> remove the
	 * last slash
	 * 
	 */
	@Test
	public void test1() {
		String str = "/home/";
		Assert.assertEquals("/home", simplfyPath(str));
	}

	@Test
	public void test2() {
		String str = "/../";
		Assert.assertEquals("/", simplfyPath(str));
	}

	@Test
	public void test3() {
		String str = "/home//foo/";
		Assert.assertEquals("/home/foo", simplfyPath(str));
	}

	@Test
	public void test4() {
		String str = "/a/./b/../../c/";
		Assert.assertEquals("/c", simplfyPath(str));
	}

	private String simplfyPath(String str) {
		// TODO Auto-generated method stub
		char[] ch = str.toCharArray();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < ch.length; i++) {
			if (stack.isEmpty()) {
				stack.push(ch[i]);
			} else if (stack.peek().equals('/') && stack.peek().equals('/')) {
				continue;
			}else
				stack.push(ch[i]);
		}
		return null;
	}

}
