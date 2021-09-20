package classLearn;

import org.junit.Test;

import junit.framework.Assert;

public class Flip0toGet1 {
	/**
	 * Problem 3:
	 * 
	 * Given a binary array nums and an integer k, return the maximum number of
	 * consecutive 1's in the array if you can flip at most k 0's.   Example 1:
	 * 
	 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2 Output: 6
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3 Output: 10
	 * 
	 * Input=int[],int Output=int
	 * 
	 */
	@Test
	public void test1() {
		int[] n = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		int k = 2;
		Assert.assertEquals(6, findFlip(n, k));
	}

	@Test
	public void test2() {
		int[] n = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
		int k = 2;
		Assert.assertEquals(10, findFlip(n, k));
	}

	@Test
	public void test3() {
		int[] n = { 0, 0, 1, 1 };
		int k = 2;
		Assert.assertEquals(4, findFlip(n, k));
	}

	// Time Complexity ->
	// Space Complexity->
	private int findFlip(int[] nums, int k) {
		int temp = k;
		int count = 0;
		boolean isFlag = true;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {

				if (nums[j] == 0) {
					k--;
				}

				if (k == -1) {
					max = Math.max(j - i, max);
					k = temp;
					isFlag = false;
					break;
				}
			}
			if (isFlag == true) {
				max = Math.max(nums.length - i, max);

			}
			isFlag = true;
		}

		return max;

	}
}
