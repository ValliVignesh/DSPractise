package classLearn;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class CountOfSubArrays_Sum {
	/**
	 * Problem 2:
	 * 
	 * Given an array of integers nums and an integer k, return the total number of
	 * continuous subarrays whose sum equals to k.   Example 1:
	 * 
	 * Input: nums = [1,1,1], k = 2 Output: 2
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [1,2,3], k = 3 Output: 2
	 * 
	 * Input-int[],int Output- int
	 * 
	 */

	@Test
	public void test1() {
		int[] n = { 1, 1, 1 };
		int k = 2;
		Assert.assertEquals(2, findSubTarget(n, k));

	}

	@Test
	public void test2() {
		int[] n = { 1, 2, 3 };
		int k = 3;
		Assert.assertEquals(2, findSubTarget(n, k));

	}

	@Test
	public void test3() {
		int[] n = { 1, 1, 1 };
		int k = 4;
		Assert.assertEquals(0, findSubTarget(n, k));

	}

	@Test
	public void test4() {
		int[] n = { 1, 1, 1 };
		int k = 1;
		Assert.assertEquals(3, findSubTarget(n, k));

	}

	@Test
	public void test5() {
		int[] n = { -1, -1, 1 };
		int k = 0;
		Assert.assertEquals(1, findSubTarget(n, k));

	}

	/**
	 * * PseudoCode-
	 * 
	 * Use two pointers left and right=left+1 if their sum is target then increment
	 * count decrement left else keep moving right
	 * 
	 * @param n
	 * @param k
	 * @return 523,974,560 prefix and reminder theorem
	 */

	private int findSubArrayCountForTarget(int[] n, int k) { // Works only if n has positive numbers
		int count = 0;
		int sum = 0;
		int left = 0, right = 0;
		for (right = 0; right < n.length; right++) {
			sum += n[right];			
			while (sum >= k) {
				if (sum == k)
					count++;
				sum -= n[left];

				left++;
			}
		}

		return count;
	}

	private int findSubTarget(int[] n, int k) { // Works for both positive & negative numbers - Prefix problem
		int count = 0;
		int sum = 0;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);

		for (int i = 0; i < n.length; i++) {
			sum += n[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);

		}

		return count;
	}
}
