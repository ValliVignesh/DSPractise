package basic;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Temperature {
	/**
	 * 
	 * https://leetcode.com/problems/daily-temperatures/ Given an array of integers
	 * temperatures represents the daily temperatures, return an array answer such
	 * that answer[i] is the number of days you have to wait after the ith day to
	 * get a warmer temperature. If there is no future day for which this is
	 * possible, keep answer[i] == 0 instead.
	 */

	@Test
	public void test1() {
		int[] n = { 73, 74, 75, 71, 69, 72, 76, 73 };
		Assert.assertTrue(Arrays.equals(new int[] { 1, 1, 4, 2, 1, 1, 0, 0 }, dailyTemperatures(n)));
	}

	@Test
	public void test2() {
		int[] n = { 30, 40, 50, 60 };
		Assert.assertTrue(Arrays.equals(new int[] { 1, 1, 1, 0 }, dailyTemperatures(n)));
	}

	@Test
	public void test3() {
		int[] n = { 30, 60, 90 };
		Assert.assertTrue(Arrays.equals(new int[] { 1, 1, 0 }, dailyTemperatures(n)));
	}

	@Test
	public void test4() {
		int[] n = { 30, 30, 30 };
		Assert.assertTrue(Arrays.equals(new int[] { -1, -1, 0 }, dailyTemperatures(n)));
	}

	@Test
	public void test5() {
		int[] n = {};
		Assert.assertTrue(Arrays.equals(new int[] {}, dailyTemperatures(n)));
	}

	public int[] dailyTemperatures(int[] temperatures) {
		int[] n = new int[temperatures.length];

		for (int i = 0; i < temperatures.length; i++) {// O(n)
			int j = i + 1;
			while (j < temperatures.length) {// O(n)
				if (temperatures[i] < temperatures[j]) {

					n[i] = j - i;

					break;

				} else if (temperatures[i] == temperatures[j]) {
					n[i] = -1;
					j++;
				} else {
					j++;
				}

			}
		}
		System.out.println(Arrays.toString(n));
		return n;
	}
	
	/**
	 * O(n)
	 * 
	 * 
	 */

}
