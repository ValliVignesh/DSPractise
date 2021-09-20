package twoPointer;

import java.util.*;

import org.junit.Test;

public class MinDiffBetweenTwoSets {

	/*
	 * 
	 * 
	 * 1.Intialize two pointer left=0 right=arr.length-1 2.Sort the Array 3.Move the
	 * left and right pointer and put in the array list 4.once all elements are
	 * inserted into list divide the arrylistsize/2 add it to 1 set and add the
	 * remaining element to another set 5.now sum both values in set and find
	 * difference between the set1Sum-set2Sum 6.return difference
	 * 
	 */
	@Test
	public void testData00() { // Positive
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(minimumDifference(nums));
	}

	@Test
	public void testData01() { // Positive
		int[] nums = { 4, 3, 1, 2 };
		System.out.println(minimumDifference(nums));
	}

	public int minimumDifference(int[] nums) {

		int left = 0;
		int right = nums.length - 1;
		Arrays.sort(nums);
		int[] output = new int[nums.length];
		int index = 0;
		while (left <= right) {
			output[index++] = nums[left++];
			if (nums.length > index) {
				output[index++] = nums[right--];
			}
		}
		int length = nums.length / 2;
		int set1 = 0;
		int set2 = 0;
		// nums.length%2==0;
		for (int i = 0; i < output.length; i++) {
			if (nums.length % 2 == 0) {
				if (i < length) {
					set1 += output[i];
				} else {
					set2 += output[i];
				}
			} else {
				if (i <= length) {
					set1 += output[i];
				} else {
					set2 += output[i];
				}
			}

		}
		return Math.abs(set2 - set1);

	}

	public boolean canPartition(int[] nums) {
		if (nums.length == 0)
			return false;
		int totalSum = 0;
		// find sum of all array elements
		for (int num : nums) {
			totalSum += num;
		}
		// if totalSum is odd, it cannot be partitioned into equal sum subset
		if (totalSum % 2 != 0)
			return false;
		int subSetSum = totalSum / 2;
		boolean dp[] = new boolean[subSetSum + 1];
		dp[0] = true;
		for (int curr : nums) {
			for (int j = subSetSum; j >= curr; j--) {
				dp[j] |= dp[j - curr];
			}
		}
		return dp[subSetSum];
	}

}