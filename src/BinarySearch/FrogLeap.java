package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class FrogLeap {

	@Test
	public void example() {
		int[] nums = { 6, 13, 10, 8, 11, 7, 3, 5, 2 };
		maxSequenceFrog(nums);
	}

	@Test
	public void example1() {
		int[] nums = { 5, 11, 18, 4, 9, 16, 12, 15, 1 };
		maxSequenceFrog(nums);
	}

	private void maxSequenceFrog(int[] nums) {
		int max = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			int count = 0;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					count++;
					nums[i] = nums[j];
				}
			}
			max = Math.max(count, max);
		}
		System.out.println(max);
	}

}
