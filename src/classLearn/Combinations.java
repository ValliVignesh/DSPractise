package classLearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class Combinations {
	/**
	 * Given an array of distinct integers candidates and a target integer target,
	 * return a list of all unique combinations of candidates where the chosen
	 * numbers sum to target. You may return the combinations in any order.
	 * 
	 * The same number may be chosen from candidates an unlimited number of times.
	 * Two combinations are unique if the frequency of at least one of the chosen
	 * numbers is different.
	 * 
	 * It is guaranteed that the number of unique combinations that sum up to target
	 * is less than 150 combinations for the given input.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: candidates = [2,3,6,7], target = 7 Output: [[2,2,3],[7]] Explanation:
	 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
	 * times. 7 is a candidate, and 7 = 7. These are the only two combinations.
	 * Example 2:
	 * 
	 * Input: candidates = [2,3,5], target = 8 Output: [[2,2,2,2],[2,3,3],[3,5]]
	 * Example 3:
	 * 
	 * Input: candidates = [2], target = 1 Output: [] Example 4:
	 * 
	 * Input: candidates = [1], target = 1 Output: [[1]] Example 5:
	 * 
	 * Input: candidates = [1], target = 2 Output: [[1,1]]
	 * 
	 * Input - int[],int Output- int[][]
	 *
	 *
	 *
	 */
	@Test
	public void test1() {
		int[] n = { 2, 3, 6, 7 };
		int k = 7;
		int[][] res = new int[][] { { 2, 2, 3 }, { 7 } };
		Assert.assertEquals(res, toFind(n, k));
	}

	@Test
	public void test2() {
		int[] n = { 2 };
		int k = 1;
		int[][] res = new int[][] { {} };
		Assert.assertEquals(res, toFind(n, k));
	}

	@Test
	public void test3() {
		int[] n = { 1 };
		int k = 2;
		int[][] res = new int[][] { { 1, 1 } };
		Assert.assertEquals(res, toFind(n, k));
	}

	@Test
	public void test4() {
		int[] n = { 1, 9 };// {7,2,1}
		int k = 10;
		int[][] res = new int[][] { { 1, 9 } };
		Assert.assertEquals(res, toFind(n, k));
	}

	@Test
	public void test5() {
		int[] n = { 1, 2, 3 };
		int k = 4;
		int[][] res = new int[][] { { 1, 1, 1, 1 }, { 1, 1, 2 }, { 1, 3 }, { 2, 2 } };
		//Assert.assertEquals(res, toFind(n, k));
		System.out.println(findSumCombinations(n,k));
	}

	/**
	 * Pseudo Code Sort the given input From array index 0 to arr.length subtract
	 * diff=target-arr[index] if diff is present in arr add it to the arraylist -->
	 * if exact number is present add to list else --> while add the self number
	 * until it matches the target
	 *
	 * return null array
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	private int[] toFind(int[] n, int k) {
		Arrays.sort(n);// 123
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
		for (int i = 0; i < n.length; i++) {
			list.add(n[i]);// 123
		}
		int diff = 0;

		if (list.contains(k)) {
			// resultList.add(k);
			int index = list.get(k);
			list.remove(index);

		} else {
			for (int i = 0; i < list.size(); i++) {
				ArrayList<Integer> outList = new ArrayList<>();
				outList.add(list.get(i));// 1
				diff = k - list.get(i);// 3
				if (list.contains(diff)) {
					outList.add(diff);
					resultList.add(outList);
					outList.clear();
				} else {
					int sum = 0;
					while (sum <= k) {
						outList.add(list.get(i));
						// k-=list.get(i);
						sum += outList.get(i);
					}
					sum = 0;
				}
			}

		}
		System.out.println(String.valueOf(resultList));

		return null;
	}

	/**
	 * Pseudocode: 1. Initialize an array list 2. Iterate through the array 3.
	 * Divide the target by current value and store in result a) add value to list
	 * result times
	 * 
	 * 
	 * 
	 * @param input
	 * @param target
	 * @return
	 */
	private Set<List<Integer>> findSumCombinations(int[] input, int target) {
		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < input.length; i++) {
			int valuesInNum = target / input[i];
			while (valuesInNum != 0) {
				int sum = 0;
				List<Integer> list = new ArrayList<>();
				int valuesToDup = valuesInNum;
				while (valuesToDup != 0) {
					sum += input[i];
					list.add(input[i]);
					valuesToDup--;
				}
				if (sum == target) {
					set.add(list);
				} else {
					for (int j = 0; j < input.length; j++) {
						if (i != j) {
							sum += input[j];
							if (sum == target) {
								list.add(input[j]);
								set.add(list);
								sum -= input[j];
							} else if (sum > target)
								sum -= input[j];
							else if (sum < target)
								list.add(input[j]);
						}
					}
				}
				valuesInNum--;
			}
		}
		return set;
	}

}
