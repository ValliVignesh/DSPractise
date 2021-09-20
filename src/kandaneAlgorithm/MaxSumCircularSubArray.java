package kandaneAlgorithm;

import org.junit.Test;

import junit.framework.Assert;

public class MaxSumCircularSubArray {
	// https://leetcode.com/problems/maximum-sum-circular-subarray/

	@Test
	public void test1() {
		int n[] = { 1, -2, 3, -2 };
		Assert.assertEquals(3, maxSubarraySumCircular(n));

	}

	@Test
	public void test2() {
		int n[] = { 5, -3, 5 };
		Assert.assertEquals(10, maxSubarraySumCircular(n));

	}

	@Test
	public void test3() {
		int n[] = { 3, -1, 2, -1 };
		Assert.assertEquals(4, maxSubarraySumCircular(n));

	}

	@Test
	public void test4() {
		int n[] = { 3, -2, 2, -3 };
		Assert.assertEquals(3, maxSubarraySumCircular(n));

	}

	@Test
	public void test5() {
		int n[] = { -2, -3, -1 };
		Assert.assertEquals(-1, maxSubarraySumCircular(n));

	}

	public int maxSubarraySumCircular(int[] array) {

		int currentSum = 0, maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {

			currentSum = Math.max(currentSum + array[i], array[i]);
			maxSum = Math.max(maxSum, currentSum);

		}

		if (maxSum < 0)
			return maxSum;

		currentSum = 0;
		int minSum = Integer.MAX_VALUE;//3,-1,2,-1
		for (int i = 0; i < array.length; i++) {

			currentSum = Math.min(currentSum + array[i], array[i]);
			minSum = Math.min(minSum, currentSum);

		}

		int totalSum = 0;
		for (int element : array)
			totalSum += element;

		return Math.max(maxSum, totalSum - minSum);
	}
}
