package basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class SetMismatchNum {
//https://leetcode.com/problems/set-mismatch/submissio
	@Test
	public void test1() {
		int[] n= {3,2,3,4,6,5};
		Assert.assertTrue(Arrays.equals(new int[] {3,1}, findErrorNums(n)));
	}
	public int[] findErrorNums(int[] nums) {
		int[] output = new int[2];
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (s.contains(nums[i])) {
				output[0] = nums[i];
			}
			s.add(nums[i]);
		}
		for (int i = 1; i <= 10000; i++) {
			if (s.contains(i))
				continue;
			else {
				output[1] = i;
				break;
			}
		}
		return output;
	}
}
