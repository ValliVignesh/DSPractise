package queue;

import java.util.ArrayDeque;

import org.junit.Test;

import junit.framework.Assert;

public class MaxDiffLong {

	/**
	 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
	 * Input - int[] ,int
	 * 
	 * Output- int[]
	 * 
	 * Test Data Set: Positive - nums = [8,2,4,7], limit = 4 , nums =
	 * [10,1,2,4,7,2], limit = 5 Negative - nums = [4], limit = 3 Edge - nums =
	 * [110,50,35,75], limit = 1
	 */

	@Test
	public void test1() {
		int[] n = { 8, 2, 4, 7 };
		int k = 4;
		Assert.assertEquals(2, findLongMaxSubArrayQueue(n, k));
	}

	@Test
	public void test2() {
		int[] n = { 10, 1, 2, 4, 7, 2 };
		// 1 --
		// 1-2 --
		// 1,2,4 -- 3<=5 --
		// 1,2,4,7
		// 1,2,4,7,2
		int k = 5;
		Assert.assertEquals(4, findLongMaxSubArrayQueue(n, k));
	}

	@Test
	public void test3() {
		int[] n = { 4 };
		int k = 3;
		Assert.assertEquals(-1, findLongMaxSubArrayQueue(n, k));
	}

	/**
	 * Pseudo Code-
	 * 
	 * 1.Travel from 0 th index in array and find the max value in array and min
	 * value
	 * 
	 * subtract max and min and check if it is less than or equal to limit --> yes
	 * --> store the size of the array in array --> no --> do nothing increment the
	 * windowEnd
	 * 
	 * once completed the array length shift the windowStart to next element
	 * 
	 * repeat the process till windowEnd<array.length
	 * 
	 * REturn the max value in the array
	 * 
	 * 
	 */

	private int[] findLongMaxSubArray(int[] n, int k) {
		// TODO Auto-generated method stub
		int windowStart = 0, windowEnd = 0;
		int currentWindowSize = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		ArrayDeque<Integer> resultQueue = new ArrayDeque<Integer>();

		while (windowEnd < n.length) {

			if (n[windowEnd] - n[windowStart] <= k) {
				resultQueue.offer(n[windowEnd] - n[windowStart]);
			}
			windowEnd++;
		}

		return null;

	}

	/*
	 * Two Pointer Algorithm - Equi Directional Find the min and max for slow and
	 * fast pointer values if the abs difference is the less than or equal to limit
	 * -> find the longest and move right else reset the min and max with the right
	 * value -> left
	 * 
	 */

	private int findLongMaxSubArrayTwoPointer(int[] n, int k) {
		// TODO Auto-generated method stub
		int left = 0, right = 0;
		int longest = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		while (left < n.length && right < n.length) {

			min = Math.min(min, Math.min(n[left], n[right]));
			max = Math.max(max, Math.max(n[left], n[right]));

			if (Math.abs(max - min) <= k) {
				longest = Math.max(longest, right - left + 1);
				right++;

			} else {
				// 8,2,4,7

				right = ++left;
				min = n[left];
				max = n[left];
			}

		}

		return longest;
	}

	/**
	 * 
	 * 
	 */
	private int findLongMaxSubArrayQueue(int[] n, int k) {

		ArrayDeque<Integer> minQueue = new ArrayDeque<>();
		ArrayDeque<Integer> maxQueue = new ArrayDeque<>();
		int left = 0, right = 1;
		int longest = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		if (n.length == 1) {
			if (n[0] <= k)
				return 1;
			else
				return -1;

		}
		
		minQueue.offer(n[0]);
		maxQueue.offer(n[0]);
		
		while (right < n.length) {
			while (!minQueue.isEmpty() && minQueue.peekLast() > n[right]) {
				minQueue.pollLast();
			}
			minQueue.offer(n[right]);
			while (!maxQueue.isEmpty() && maxQueue.peekLast() < n[right]) {
				maxQueue.pollLast();
			}
			maxQueue.offer(n[right]);
			while (maxQueue.peekFirst() - minQueue.peekFirst() > k) {
				if (minQueue.peekFirst() == n[left])
					minQueue.removeFirst();
				if (maxQueue.peekFirst() == n[left++])
					maxQueue.removeFirst();
				
			}
			longest = Math.max(longest, right - left + 1);
			right++;
		}

		return longest;
	}
}
