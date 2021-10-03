package Math;

import org.junit.Test;

import junit.framework.Assert;

public class LongestSubArrayOfDeletingOneChar {
	// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

	@Test
	public void test1() {
		int[] n= {1,1,0,1};
		Assert.assertEquals(3, longestSubarray(n));
	}

	public int longestSubarray(int[] nums) {
		int currCount = 0;
		int left = 0;
		int right = 0;
		int max = 0;
		while (right < nums.length) {
			if (nums[right] == 0) {
				currCount++;
			}
			while (currCount == 2) {
				if (nums[left++] == 0) {

					currCount--;
				}

			}
			right++;
			max = Math.max(max, right - left);
		}
		return max - 1;
	}
}
