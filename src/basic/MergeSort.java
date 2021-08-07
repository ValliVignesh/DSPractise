package basic;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MergeSort {
	/**
	 * ) Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
	 * one sorted array. The number of elements initialized in nums1 and nums2 are m
	 * and n respectively. You may assume that nums1 has enough space (size that is
	 * equal to m + n) to hold additional elements from nums2.
	 * 
	 * Example 1: Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
	 * Output: [1,2,2,3,5,6]
	 * 
	 * Example 2: Input: nums1 = [1], m = 1, nums2 = [], n = 0 Output: [1]
	 */

	@Test
	public void test1() {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		Assert.assertTrue(Arrays.equals(new int[] { 1, 2, 2, 3, 5, 6 }, merSortBruteForce(nums1, nums2)));

	}

	@Test
	public void test2() {
		int[] nums1 = { 5, 13, 13, 14, 15, 0, 0, 0, 0 };
		int[] nums2 = { 8, 9, 10, 10 };
		Assert.assertTrue(
				Arrays.equals(new int[] { 5, 8, 9, 10, 10, 13, 13, 14, 15 }, merSortBruteForce(nums1, nums2)));
	}

	@Test
	public void test3() {
		int[] nums1 = { -1, 0, 0, 3, 3, 3, 0, 0, 0 };
		int[] nums2 = { 1, 2, 2 };
		Assert.assertTrue(
				Arrays.equals(new int[] { -1,0,0,1,2,2,3,3,3}, merSortBruteForce(nums1, nums2)));

	}

	private int[] merSortBruteForce(int[] nums1, int[] nums2) {
		// TODO Auto-generated method stub
		int index = 0;
		for (int i = nums1.length - 1; i >= 0; i--) {
			if (nums1[i] == 0 && i<=nums2.length)
				nums1[i] = nums2[index++];
		}
		Arrays.sort(nums1);
		System.out.println(Arrays.toString(nums1));

		return nums1;
	}

	private Integer[] merSort(int[] nums1, int[] nums2) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = 0;
		Integer[] output = new Integer[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			if (right != nums2.length) {
				if (nums1[left] != 0) {
					if (nums1[left] >= nums2[right])
						output[i] = nums2[right++];
					else
						output[i] = nums1[left++];
				} else {
					output[i] = nums2[right++];
				}
			} else {
				output[i] = nums1[left++];
			}

		}
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}

		return output;
	}
}
