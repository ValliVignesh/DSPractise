package paloaltonetworks;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import junit.framework.Assert;

public class DigitSum {

	@Test
	public void test1() {
		int[] A = { 51, 71, 17, 42 };
		Assert.assertEquals(93, solution3(A));
	}

	@Test
	public void test2() {
		int[] A = { 01, 10, 02, 20, 11 };
		Assert.assertEquals(31, solution3(A));
	}

	@Test
	public void test3() {
		int[] A = { 51, 32, 36 };
		Assert.assertEquals(-1, solution3(A));
	}

	public int solution1(int[] A) {
		Map<Integer, Integer> sumMap = new HashMap<>();
		int maxSum = -1;
		for (int eachNum : A) {
			int sum = digitSum(eachNum);
			if (sumMap.containsKey(sum)) {
				maxSum = Math.max(maxSum, sumMap.get(sum) + eachNum);
				if (eachNum > sumMap.get(sum)) {
					sumMap.put(sum, eachNum);
				}
			} else {
				sumMap.put(sum, eachNum);
			}
		}
		return maxSum;
	}

	public int digitSum(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num = num / 10;
		}
		return sum;
	}

	public int solution2(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int len = A.length;
		int res = -1;
		HashMap<Integer, List<Integer>> sum2list = new HashMap<>();
		for (int i = 0; i < len; i++) {
			int curnum = A[i];
			int curSum = 0;
			while (curnum != 0) {
				curSum += curnum % 10;
				curnum /= 10;
			}
			if (sum2list.containsKey(curSum)) {
				List<Integer> curId = sum2list.get(curSum);
				for (Integer j : curId) {
					int num = A[j];
					res = Math.max(res, num + A[i]);
				}
				sum2list.get(curSum).add(i);
			} else {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(i);
				sum2list.put(curSum, tmp);
			}
		}
		return res;
	}

	private int solution3(int[] arr) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			int sum = 0, n = arr[i];
			List<Integer> list = new ArrayList<Integer>();
			while (n > 0) {
				sum += n % 10;
				n = n / 10;
			}
			if (map.containsKey(sum)) {
				list.addAll(map.get(sum));
				list.add(arr[i]);
				map.put(sum, list);
			} else {
				list.add(arr[i]);
				map.put(sum, list);
			}
		}
		int max = -1;
		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = new ArrayList<Integer>();
			list.addAll(entry.getValue());
			if (list.size() > 1) {
				Collections.sort(list);
				max = Math.max(max, list.get(list.size() - 1) + list.get(list.size() - 2));
			}
		}
		return max;
	}

}
