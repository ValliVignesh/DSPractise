package interviewQuestions;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class MaximumDistanceInIntegerArray {

	@Test
	public void test1() {
		int n[] = { 5, 2, 0, 1, 7, 9 };
		Assert.assertEquals(9, findMaxDist(n));
	}

	@Test
	public void test2() {
		int n[] = { 5, 2, 0, 1, 7, 9 };
		Assert.assertEquals(true, Arrays.equals(new int[] { 0, 9 }, findMaxDistValue(n)));
	}

	@Test
	public void test3() {
		int n[] = { 5, 2, 0, 1, 7, 9 };
		Assert.assertEquals(9, findMaxDistWithSort(n));
	}

	@Test
	public void test4() {
		int n[] = { 5, 2, 0, 1, 7, 9 };
		Assert.assertEquals(true, Arrays.equals(new int[] { 2, 5 }, findMaxDistIndex(n)));
	}

	private int findMaxDistWithSort(int[] n) {
		// TODO Auto-generated method stub
		Arrays.sort(n);
		return n[n.length - 1] - n[0];
	}

	private int findMaxDist(int[] n) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n.length; i++) {
			min = Math.min(n[i], min);
			max = Math.max(n[i], max);
		}
		return max - min;
	}

	private int[] findMaxDistValue(int[] n) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n.length; i++) {
			min = Math.min(n[i], min);
			max = Math.max(n[i], max);
		}
		return new int[] { min, max };
	}

	private int[] findMaxDistIndex(int[] n) {
		// TODO Auto-generated method stub
		int minIndex = 0, maxIndex = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n.length; i++) {
			if (n[i] < min) {
				min = n[i];
				minIndex = i;
			}
			if (n[i] > max) {
				max = n[i];
				maxIndex = i;
			}
		}
		return new int[] { minIndex, maxIndex };
	}
}
