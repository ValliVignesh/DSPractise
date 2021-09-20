package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class MaxSubSequence {
	/**
	 * Find max subsequence of the given array return array not count 2,3,4,6,1,5
	 */
	@Test
	public void example() {
		int[] nums = { 2, 3, 4, 6, 1, 5 };
		maxSubSequence(nums);
	}

	private Object[] maxSubSequence(int[] nums) {
		// TODO Auto-generated method stub
		ArrayList<Integer> sub = new ArrayList<Integer>();

		sub.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (num > sub.get(sub.size() - 1)) {
				sub.add(num);
			} else {
				// Find the first element in sub that is greater than or equal to num
				int j = 0;
				while (num > sub.get(j)) {
					j += 1;
				}
				if (j == sub.size() - 1)
					sub.set(j, num);
			}
		}

		System.out.println(Arrays.toString(sub.toArray()));
		return sub.toArray();
	}
}
