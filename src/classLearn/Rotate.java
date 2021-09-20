package classLearn;

import org.junit.Assert;
import org.junit.Test;

public class Rotate {

	/**
	 * P3) There is an integer array nums sorted in ascending order (with distinct
	 * values). Prior to being passed to your function, nums is rotated at an
	 * unknown pivot index k (0 <= k < nums.length) such that the resulting array is
	 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
	 * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
	 * and become [4,5,6,7,0,1,2].
	 * 
	 * Given the array nums after the rotation and an integer target, return the
	 * index of target if it is in nums, or -1 if it is not in nums. You must write
	 * an algorithm with O(log n) runtime complexity.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
	 * 
	 */

	@Test
	public void test1() {
		int n[] = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		Assert.assertEquals(4, searchNumberAfterRotate(n, target));
	}
	@Test
	public void test2() {
		int n[] = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 3;
		Assert.assertEquals(-1, searchNumberAfterRotate(n, target));
	}
	@Test
	public void test3() {
		int n[] = { 1};
		int target = 0;
		Assert.assertEquals(-1, searchNumberAfterRotate(n, target));
	}
	// Time complexity -O(log n)
	//Space Complexity- O(1)
	private int searchNumberAfterRotate(int[] n, int target) {
		// TODO Auto-generated method stub
		int low = 0, high = n.length - 1; //4,5,6,7,0,1,2
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;

			if (n[mid] == target) {
				System.out.println(mid);
				return mid;
			} else if (n[mid] < target) {
				if (n[high] < n[mid]) {
					low = mid + 1;

				} else {
					if (n[high] >= target) {
						low = mid + 1;

					} else
						high = mid - 1;

				}
			} else {
				if (n[high] < n[mid]) {
					if (n[mid] >= target) {
						low = mid + 1;
					} else
						high = mid - 1;
				} else
					high = mid - 1;
			}
		}
		return -1;

	}
	/**Brute Force
	 *  public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target) return i;
        }
        return -1;
    }
	 */

}
