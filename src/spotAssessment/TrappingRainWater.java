package spotAssessment;

import org.junit.Assert;
import org.junit.Test;

public class TrappingRainWater {
	/**
	 * https://leetcode.com/problems/trapping-rain-water/
	 */

	@Test
	public void test1() {
		int n[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		Assert.assertEquals(6, findTrappingWater(n));

	}

	/**
	 * If starting index value 0 ignore --> if left >left+1 retain left index else
	 * move left+1
	 * 
	 * if ending index value is greater than the previous value retain else ignore
	 * 
	 * 
	 * iterate from index left index based on above condition move the right pointer
	 * till u find the greater than left pointer
	 * 
	 * Check the index difference between left and right >=2 *
	 * 
	 * while --> if left==right --> find minimum value and difference of each value
	 *
	 * if left<right -->
	 * 
	 * if left>right --> right++
	 * 
	 * if right+1 < right find minimum value and difference of each value
	 * 
	 * move left = right
	 * 
	 * check if
	 * 
	 * @param n
	 * @return
	 */

	private int findTrappingWater(int[] n) {
		// TODO Auto-generated method stub
		int count = 0;

		int left = 0;
		int right = 1;
		int length;
		if (n[n.length] <= n[n.length - 1])
			length = n.length - 1;
		else
			length = n.length;

		while (left < length) {
			boolean isRange = false;
			if (n[left] <= n[left + 1]) {
				left++;
				right++;
			} else {
				while (right - left >= 2 && !isRange) {

					if (n[left] == n[right]) {

					} else if (n[left] > n[right]) {

						right++;
					} else {

					}
				}

			}

		}
		return count;
	}
}
