package basic;

import org.junit.Assert;
import org.junit.Test;

public class SignOfArrayOfPdt {
	/**
	 * https://leetcode.com/problems/sign-of-the-product-of-an-array/submissions/
	 */
	
	@Test
	public void test1() {
		int[] nums = {41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41};
		Assert.assertEquals(arraySign(nums), -1);
	}
	// Time Complexity - O(n) Space -  O(1)

	private int arraySign(int[] nums) {
		double pdt = 1; // as some inputs in leet code goes beyond the int range we are declaring as double
		for (int i = 0; i < nums.length; i++) {
			pdt *= nums[i];
		}
		System.out.println(pdt);
		if (pdt <= -1)
			return -1;

		else if (pdt >= 1)
			return 1;
		else
			return 0;
	}

}
