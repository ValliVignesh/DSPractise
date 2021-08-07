package interviewQuestions;

import org.junit.Test;

public class HighestElementInArray {

	/**
	 * Given an int array find the highest element in the array unsorted array
	 * 
	 * Time constraint<O(n)
	 * 
	 * index of the highest element
	 * 
	 * 
	 */
	@Test
	public void test1() {
		int[] n = { 7, 5, 0, 2 };
		System.out.println(finMaxIndex(n));

	}

	@Test
	public void test2() {

	}

	@Test
	public void test3() {

	}

	/**
	 * Get the
	 * 
	 */

	private int finMaxValue(int[] n) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		int tempMax, maxIndex;
		for (int i = 0; i < n.length - 1; i++) {
			tempMax = Math.max(n[i], n[i + 1]);
			max = Math.max(max, tempMax);
			maxIndex = i;
		}
		return max;
	}

	private int finMaxIndex(int[] n) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		int tempMax, maxIndex = 0;
		for (int i = 0; i < n.length - 1; i++) {
			tempMax = Math.max(n[i], n[i + 1]);
			if (max < tempMax) {
				max = tempMax;
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
