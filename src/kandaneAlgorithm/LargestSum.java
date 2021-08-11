package kandaneAlgorithm;

import org.junit.Test;

public class LargestSum {
	/**
	 * Given an integer array nums, find the contiguous subarray (containing at
	 * least one number) which has the largest sum and return its sum.
	 * 
	 * A subarray is a contiguous part of an array.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: [4,-1,2,1] has
	 * the largest sum = 6. Example 2:
	 * 
	 * Input: nums = [1] Output: 1
	 */
	/**
	 * /*Kadanes algorithm iterate the array and find the sum of the array for each
	 * i values and get the maximumsum for each iterations when negative integers
	 * occurs in nums[i] because of which sum values falls in negative then max sum
	 * value to =0 start iterating from next value from array and continue to get
	 * the maximum sub array sum
	 *
	 *
	 */
	@Test
	public void test1() {
		int n[] = { 4, 6, 11, 3, 0, 2 };
		System.out.println(Maximumsubarrayofthenums(n));
	}

	public int Maximumsubarrayofthenums(int[] nums) {
		int sum = 0;
		int maximumsum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			maximumsum = Math.max(sum, maximumsum);
			if (sum < 0) {
				sum = 0;
			} else
				continue;
		}
		return maximumsum;
	}

}
