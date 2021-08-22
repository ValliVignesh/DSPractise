package swiggy;

import java.util.ArrayDeque;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ReverseListOfInteger {

	/*
	 * Input: Integer array Output: Integer array Constraint: Test Data: Positive:
	 * {1,2,3,4,5} Output: {5,4,3,2,1} Edge: {1,1,1,1} Output: {1,1,1,1} Negative:
	 * {} Output: {}
	 *
	 * Approach:
	 *
	 * Time Complexity: Space Complexity:
	 */

	@Test
	public void test1() {
		int[] nums = { 1, 2, 3, 4, 5 };
		Assert.assertTrue(Arrays.equals(new int[] { 5, 4, 3, 2, 1 }, findReverse(nums)));
	}

	@Test
	public void test2() {
		int[] nums = { 1, 1, 1, 1 };
		Assert.assertTrue(Arrays.equals(new int[] { 1, 1, 1, 1 }, findReverse(nums)));
	}

	@Test
	public void test3() {
		int[] nums = {};
		Assert.assertTrue(Arrays.equals(new int[] {}, findReverse(nums)));
	}

	/*
	 * Pseudo code - Linear Create an output array of size length Traverse through
	 * the array from last to 0 Add each element to the array Return the array
	 */

	/*
	 * Pseudo code - 2 pointer Initialize left as 0, right as length-1 Traverse
	 * until left <= right Initialize temp variable Swap left & right using temp
	 * Increment left & right Return the array
	 */

	// Time Complexity: O(n/2)
	// Space Complexity: O(1)

	private int[] findReverse(int[] nums) {
		if (nums.length == 0)
			return nums;
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int temp = nums[left];
			nums[left++] = nums[right];
			nums[right--] = temp;
		}
		return nums;
	}

	/*
	 * Pseudo code - Using Queue - Time Complexity: O(n); Space Complexity: O(n)
	 * Create a queue Traverse through the array Add each element to the queue
	 * Traverse through the array Poll the last element in the queue and store in
	 * the array from index 0 Return the array
	 *
	 */

	private int[] reverseListUsingQueue(int[] nums) {
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		for (int i = 0; i < nums.length; i++)
			queue.offer(nums[i]);
		for (int i = 0; i < nums.length; i++)
			nums[i] = queue.pollLast();
		return nums;
	}
}
