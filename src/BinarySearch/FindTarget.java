package BinarySearch;

import org.junit.Assert;
import org.junit.Test;

public class FindTarget {
//https://leetcode.com/problems/search-insert-position

	@Test
	public void test1() {
		int n[] = { 1, 3, 5, 6 };
		int target = 5;
		Assert.assertEquals(2, searchInsert(n, target));
	}

	public int searchInsert(int[] nums, int target) {
		if (target > nums[nums.length - 1])
			return nums.length;

		if (target < nums[0])
			return 0;

		int left = 0, right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			else if (target < nums[mid]) {
				right = mid - 1;

			} else {
				left = mid + 1;

			}

		}
		return right + 1;
	}
}
