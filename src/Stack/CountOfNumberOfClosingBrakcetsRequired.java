package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class CountOfNumberOfClosingBrakcetsRequired {
	/**
	 * Find out how many missing brackets to make a valid parentheses !! Input can
	 * have only open and closing brackets ( ) String st = “((((” -> 4 brackets
	 * String st = “(()))” -> 1 bracket
	 */
	/**
	 * Input- String Output- int
	 * 
	 * 
	 */

	@Test
	public void test1() {
		String str = "((((";
		Assert.assertEquals(4, findNoOfMissingBracket(str));

	}

	@Test
	public void test2() {
		String str = "(()(";
		Assert.assertEquals(2, findNoOfMissingBracket(str));

	}

	@Test
	public void test3() {
		String str = "))))";
		Assert.assertEquals(4, findNoOfMissingBracket(str));

	}

	@Test
	public void test4() {
		String str = "()";
		Assert.assertEquals(0, findNoOfMissingBracket(str));

	}

	/**
	 * String to char Array Intialise a variable count open bracket -->push in stack
	 * close bracket --> do stack pop and check if it is ( yes --> fine else -->
	 * count++ return count
	 * 
	 * @param str
	 * @return
	 */

	private int findNoOfMissingBracket(String str) {
		// TODO Auto-generated method stub
		Stack<Character> stack = new Stack<Character>();
		char[] cha = str.toCharArray();
		int count = 0;

		for (Character c : cha) {
			stack.push(c);
		}
		for (Character c : cha) {
			if (c.equals(')')) {
				if (!stack.peek().equals('('))
					count++;
			} else {
				if (!stack.peek().equals(')'))
					count++;
			}
		}
		if (!stack.isEmpty())
			return stack.size();
		else
			return count;

	}
	@Test
	public void test5() {
		String str = "RUDRL";
		Assert.assertEquals(4, getMaxDeletions(str));

	}
	
	 public static int getMaxDeletions(String s) {
		    // Write your code here
		    char[] cha=s.toCharArray();
		    Map<Character,Character> map=new HashMap<Character,Character>();
		   Stack<Character> stack=new Stack<Character>();
		    map.put('L','R');
		    map.put('D','U');
		  //  map.put('L','R');
		   // map.put('D','U');
		    int count=0;
		    for(int i=0;i<cha.length;i++){
		        if(!stack.isEmpty()){
		        if(stack.peek().equals(map.get(cha[i]))){
		            stack.pop();
		            count++;
		        }else
		    stack.push(cha[i]);  }
		    else
		    stack.push(cha[i]);       
		        
		    }    
		    
		    return count;
		    }

}