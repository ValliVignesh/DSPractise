package kandaneAlgorithm;

import org.junit.Test;

import junit.framework.Assert;

public class MinSumCircularSubArray {
	// https://leetcode.com/problems/maximum-sum-circular-subarray/

	@Test
	public void test1() {
		int n[] = { 1, -2, 3, -2 };
		Assert.assertEquals(-2, minSubarraySumCircular(n));

	}

	@Test
	public void test2() {
		int n[] = { 5, -3, 5 };
		Assert.assertEquals(-3, minSubarraySumCircular(n));

	}

	@Test
	public void test3() {
		int n[] = { 3, -1, 2, -1 };
		Assert.assertEquals(-1, minSubarraySumCircular(n));

	}

	@Test
	public void test4() {
		int n[] = { 3, -2, 2, -3 };
		Assert.assertEquals(-3, minSubarraySumCircular(n));

	}

	@Test
	public void test5() {
		int n[] = { -2, -3, -1 };
		Assert.assertEquals(-6, minSubarraySumCircular(n));

	}

	public int minSubarraySumCircular(int[] array) {

		int currentSum = 0, minSum = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {

			currentSum = Math.min(currentSum + array[i], array[i]);
			minSum = Math.min(minSum, currentSum);

		}

		if (minSum < 0)
			return minSum;

		currentSum = 0;
		int maxSum = Integer.MIN_VALUE;//3,-1,2,-1
		for (int i = 0; i < array.length; i++) {

			currentSum = Math.min(currentSum + array[i], array[i]);
			maxSum = Math.min(maxSum, currentSum);

		}

		int totalSum = 0;
		for (int element : array)
			totalSum += element;

		return Math.min(minSum, totalSum - maxSum);
	}
}
