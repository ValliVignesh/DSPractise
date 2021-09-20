package minimumRange;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class Uber_MinRANGE {
	/**
	 * Given heights of n towers and a value k. We have to either increase or
	 * decrease height of every tower by k (only once) where k > 0. The task is to
	 * minimise the difference between the heights of the longest and the shortest
	 * tower after modifications, and output this difference. Examples: Input :
	 * arr[] = {1, 15, 10}, k = 6 Output : Maximum difference is 5. Explanation : We
	 * change 1 to 7, 15 to 9 and 10 to 4. Maximum difference is 5 (between 4 and
	 * 9). We can't get a lower difference. Input : arr[] = {1, 5, 15, 10} k = 3
	 * Output : Maximum difference is 8 arr[] = {4, 8, 12, 7} Input : arr[] = {4, 6}
	 * k = 10 Output : Maximum difference is 2 arr[] = {14, 16} OR {-6, -4} Input :
	 * arr[] = {6, 10} k = 3 Output : Maximum difference is 2 arr[] = {9, 7} Input :
	 * arr[] = {1, 10, 14, 14, 14, 15} k = 6 Output: Maximum difference is 5 arr[] =
	 * {7, 4, 8, 8, 8, 9} Input : arr[] = {1, 2, 3} k = 2 Output: Maximum difference
	 * is 2 arr[] = {3, 4, 5}
	 */

	/**
	 * Two pointer approach
	 * 
	 * First sort the input the array Find the Number which is less than or equal to
	 * k then add to that Number and increase Left++ Find the Number which is
	 * greater than k then delete K to that Numbern and decrease right-- Find the
	 * Max and Min Value give the op = Max-Min
	 */
	@Test
	public void test1() {
		int arr[] = { 1, 15, 10 };// 1 10 15
		int k = 6;
		findMinimunDifference(arr, k);
	}

	@Test
	public void test2() {
		int arr[] = { 1, 5, 15, 10 };// 1 5 10 15
		int k = 3;
		findMinimunDifference(arr, k);
	}

	@Test
	public void test3() {
		int arr[] = { 4, 6 };// 1 5 10 15
		int k = 3;
		findMinimunDifference(arr, k);
	}

	@Test
	public void test4() {
		int arr[] = { 6, 10 };// 1 5 10 15
		int k = 3;
		findMinimunDifference(arr, k);
	}

	@Test
	public void test5() {
		int arr[] = { 1, 10, 14, 14, 14, 15 };// 1 5 10 15
		int k = 3;
		findMinimunDifference(arr, k);
	}

	@Test
	public void test6() {
		int arr[] = { 1, 2, 3 };// 1 5 10 15
		int k = 3;
		findMinimunDifference(arr, k);
	}

	@Test
	public void test7() {
		int arr[] = { 1, 4, 12 }; // 7 10 6
		int k = 6;
		findMinimunDifference(arr, k);
	}

	@Test
	public void test8() {
		int arr[] = { 2, -3, -2, 8 }; // 6 1 2 4
		int k = 4;
		findMinimunDifference(arr, k);
	}

	private int findMinimunDifference(int[] arr, int k) {
		// TODO Auto-generated method stub
		int max = 0, min = Integer.MAX_VALUE, mindiff, newdiff = 0;
		Arrays.sort(arr);
		max = arr[arr.length - 1];
		min = arr[0];
		mindiff = max - min;

		// Handle corner elements
		int small = arr[0] + k;
		int big = arr[arr.length - 1] - k;
		int temp = 0;

		if (small > big) {
			temp = small;
			small = big;
			big = temp;
		}

		for (int i = 1; i < arr.length - 1; i++) {
			int subtract = arr[i] - k;
			int add = arr[i] + k;
			// If both subtraction and addition
			// do not change diff
			if (subtract >= small || add <= big)
				continue;

			if (big - subtract <= add - small)
				small = subtract;
			else
				big = add;
		}

		System.out.println(Math.min(mindiff, big - small));
		return Math.min(mindiff, big - small);

	}
}
