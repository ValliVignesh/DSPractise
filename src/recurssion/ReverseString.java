package recurssion;

import org.junit.Assert;
import org.junit.Test;

public class ReverseString {
	String outputString = "";

	/**
	 * Reverse given String
	 * 
	 * Input - String Output-String Constraint-Recurssive
	 */
	/**
	 * 1.Find the base point 2.Find simple test data 3.Chk logic with edge and
	 * negative data 4.Identify Pattern/logic 5.Implement
	 * 
	 */

	@Test
	public void test1() {
		String str = "abcde";
		Assert.assertEquals("edcba", reverse(str));
	}

	private String reverse(String str) {
		// TODO Auto-generated method stub
		if (str.length() == 0)
			return "";
		outputString += str.charAt(str.length() - 1);
		reverse(str.substring(0, str.length() - 1));
		return outputString;
	}

}
