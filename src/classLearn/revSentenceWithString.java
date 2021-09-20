package classLearn;

import org.junit.Test;

import junit.framework.Assert;

public class revSentenceWithString {

	/**
	 * Reverse the given sentence by its word
	 * input -> today is a beautiful day
	 * output-> day beautiful a is today
	 * 
	 * Do it in less than O(n)
	 * Input - String
	 * Output-String
	 * 
	 * Swiggy 4th Round
	 */
	@Test
	public void test1() {
		String input="today is a beautiful day";
		Assert.assertEquals("day beautiful a is today", findRev(input));
	}
	@Test
	public void test2() {
		String input="day day is a ";
		Assert.assertEquals("a is day day", findRev(input));
	}
	@Test
	public void test3() {
		String input="day";
		Assert.assertEquals("day", findRev(input));
	}


	/**
	 * Pseudo Code
	 * 
	 * Time Complexity -O(n) Space Complexity-O(n)
	 * Split the String with space
	 * store the string from index end to 0 in String Builder
	 * return StringBuilder
	 * 
	 * @param input
	 * @return
	 */
	private String findRev(String input) {
		// TODO Auto-generated method stub
		String[] str=input.split("\\s+");
		if(str.length==1)
			return input;
		StringBuilder output=new StringBuilder();
		for(int i=str.length-1;i>=0;i--) {
			output.append(str[i]+" ");
		}
		return output.toString().trim();
	}
	
	/**
	 * 
	 * Less than O(n)
	 * Find mid value of splitted array
	 * mid,right=arr.length-1
	 * Append string from mid to 0
	 * append String from right to mid+1
	 * concatenate both and return
	 * 
	 */
	private String findRevTP(String input) {
		String[] str=input.split("\\s+");
		int mid;
		String output1="";
		StringBuilder output2=new StringBuilder();
		if(str.length==1)
			return input;
		else
			mid=str.length/2;
		int right=str.length-1;
		while(mid<=0 && right<mid) {
		output1=str[mid]+str[mid-1];
		mid--;
		
		}
		
		StringBuilder output=output2.append(output1);
		return output.toString().trim();
		
	}
	/**
	 * Space Complexity-O(1)
	 * Time complexity-anything fine
	 * 
	 * Split String
	 * swap first and last index
	 * swap second and third index go till mid
	 */
	private String revWithOneVariable(String input) {
		String[] str=input.split("\\s+");
		
		return input;
		
	}
	
}

