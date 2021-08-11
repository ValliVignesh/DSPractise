package interviewQuestions;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class SquareOfNums {

	/**
	 * Given a sorted array find the squares of numbers in arrayand return as sorted
	 * array
	 */

	@Test
	public void test1() {
		int n[] = { 1, 2, 3 };
		Assert.assertTrue(Arrays.equals(new int[] { 1, 4, 9 }, findSq(n)));
	}

	@Test
	public void test2() {
		int n[] = { -2, 0, 2 };
		Assert.assertTrue(Arrays.equals(new int[] { 0, 4, 4 }, findSq(n)));
	}

	@Test
	public void test3() {
		int n[] = {};
		Assert.assertTrue(Arrays.equals(new int[] {}, findSq(n)));
	}

	private int[] findSq(int[] n) {
		int[] output = new int[n.length];
		int left = 0;
		int right = n.length - 1;
		int i = 0;
		// TODO Auto-generated method stub
		while (left <= right && right < n.length) {
			if (Math.abs(n[left]) < (Math.abs(n[right]))) {
				output[i] = n[left++];
			} else if (Math.abs(n[left]) == (Math.abs(n[right]))) {
				output[i] = n[right--];
			} else
				output[i] = n[right--];
			i++;
		}
		for (int j = 0; j < n.length; j++) {
			output[j] = (int) Math.pow(output[j], 2);
		}
		System.out.println(Arrays.toString(output));
		return output;
	}
}
