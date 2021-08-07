package recurssion;

import org.junit.Test;

import junit.framework.Assert;

public class NoOfOneOccurance {
	int rem = 0;

	/**
	 * No.of.Ocuurances of 1 - unsorted sequences of number in int
	 * 
	 */
	/**
	 * 1.Find the base point 2.Find simple test data 3.Chk logic with edge and
	 * negative data 4.Identify Pattern/logic 5.Implement
	 * 
	 */
	@Test
	public void test1() {
		int n = 100;
		Assert.assertEquals(1, findNoOfOnes(n));
	}

	@Test
	public void test2() {
		int n = 110;
		Assert.assertEquals(2, findNoOfOnes(n));
	}

	@Test
	public void test3() {
		int n = 11011111;
		Assert.assertEquals(7, findNoOfOnes(n));
	}

	/**
	 * 
	 * 110%10 0
	 * 
	 * 110/10 11
	 * 
	 * 11%10 1
	 * 
	 * 
	 * 
	 * @param n
	 * @return
	 */


	private int findNoOfOnes(int input) {
		if (input == 0)
			return 0;
		return (input % 10) + findNoOfOnes(input / 10);
	}
}
