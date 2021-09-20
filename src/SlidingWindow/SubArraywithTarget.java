package SlidingWindow;

import org.junit.Test;

import junit.framework.Assert;

public class SubArraywithTarget {
	/**
	 * Given an int array [1,4,20,3,10,5] and target sum 33. If target subarray sum
	 * is found, return true else false Time : 20 Minutes - Write another 2 test
	 * data (edge and neg) - Pseudo Code for Optimised Solution - Code, Debug - Time
	 * everything - Do it yourself !!
	 * 
	 * Input - int[],int Output- Boolean
	 * 
	 * Pseudo code: --> 3 mins Sum the sub array elements starting from index 0
	 * moving the right if the sum is greater than target shif the left and move
	 * right to left and start adding( n[i[ delete] add n[i+k] if target 33 is found
	 * return true else return false
	 */
	@Test // -->5 mins
	public void test1() {
		int n[] = { 1, 4, 20, 3, 10, 5 };
		int k = 33;
		Assert.assertEquals(true, findTargetSumSlidingWindow(n, k));
	}

	@Test
	public void test2() {
		int n[] = { 1, 4, 20, 3, 10, 5 };
		int k = 20;
		Assert.assertEquals(true, findTargetSumSlidingWindow(n, k));
	}

	@Test
	public void test3() {
		int n[] = { 1, 4, 20, 3, 10, 5 };
		int k = 100;
		Assert.assertEquals(false, findTargetSumSlidingWindow(n, k));
	}

	/**
	 * Sliding window
	 */
	private boolean findTargetSumSlidingWindow(int[] n, int k) { // --> 7 mins
		int left = 0;
		int windowSum = n[0];

		for (int right = 1; right <= n.length; right++) { // O(n)

			if (windowSum > k && left < right) {
				windowSum -= n[left++];
			}

			if (windowSum == k)
				return true;

			if (windowSum < k && right < n.length) {
				windowSum += n[right];

			}
		}

		return false;
	}
}
