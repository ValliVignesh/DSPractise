package recurssion;

import org.junit.Test;

import junit.framework.Assert;

public class SubStringCount {

	/**
	 * The input is integer and examples are 1010 … 1111 Two strings - find how many
	 * substrings in a string Test Leaf Welcomes you to TEst Leaf find Test in the
	 * sentence
	 * 
	 * 
	 * 1.Find the base point 2.Find simple test data 3.Chk logic with edge and
	 * negative data 4.Identify Pattern/logic 5.Implement
	 * 
	 * Input- String Output -int
	 * 
	 */
	@Test
	public void test1() {
		String str1 = "The Sun raises in the east";
		String str2 = "The";
		Assert.assertEquals(2, findSubStringCount(str1.toLowerCase(), str2.toLowerCase()));
	}
	@Test
	public void test2() {
		String str1 = "The Sun raises in the east";
		String str2 = "raises";
		Assert.assertEquals(1, findSubStringCount(str1.toLowerCase(), str2.toLowerCase()));
	}

	private int findSubStringCount(String str1, String str2) {
		// TODO Auto-generated method stub
		if (!str1.contains(str2))
			return 0;

		return findSubStringCount(str1.replaceFirst(str2, ""), str2) + 1;
	}

}
