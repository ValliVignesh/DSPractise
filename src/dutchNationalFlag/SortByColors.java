package dutchNationalFlag;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SortByColors {
	/**
	 * https://leetcode.com/problems/sort-colors
	 */

	@Test
	public void test1() {
		int[] nums = { 2, 0, 1, 2, 1, 2, 2, 1, 0 };
		Assert.assertTrue(Arrays.equals(new int[] { 0, 0, 1, 1, 1, 2, 2, 2, 2 }, sortColors(nums)));

	}

	public int[] sortColors(int[] nums) {
		// Arrays.sort(nums);
		int low = 0;
		int high = nums.length - 1;
		int mid = 0;
		while (mid <= high) {
			if (nums[mid] == 0) {
				int temp = nums[mid];
				nums[mid] = nums[low];
				nums[low] = temp;
				low++;
				mid++;
			} else if (nums[mid] == 1)
				mid++;
			else if (nums[mid] == 2) {
				int temp = nums[mid];
				nums[mid] = nums[high];
				nums[high] = temp;
				high--;
			}

		}
		return nums;
	}
}
