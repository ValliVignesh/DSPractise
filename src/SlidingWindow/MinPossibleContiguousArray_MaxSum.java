package SlidingWindow;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MinPossibleContiguousArray_MaxSum {
	/**
	 * Given an array of integers, return the minimum possible contiguous array with
	 * maximum sum value. Examples: int[] nums = {2,4,-11,0,3,7} Output {3,7}
	 * Explanation: Sum of 3+7 is the biggest sum of all elements in the array.
	 * Though 0+3+7 gives the same value, it is expected to return the min possible
	 * contiguous array, hence it is {3,7}
	 */
	@Test
	public void test1() {
		int n[]= {2,4,-11,0,3,7};
		Assert.assertTrue(Arrays.equals(new int[] { 3, 7 }, findMaxSum(n)));
		
	}

	private int[] findMaxSum(int[] n) {
		// TODO Auto-generated method stub
		return null;
	}
}
