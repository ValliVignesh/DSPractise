package queue;

import java.util.ArrayDeque;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class InterLeavingProblem {
	/**
	 * int n[]= {1,3,5,7,2,4,6,8};
	 * 
	 * output - int n[]={1,2,3,4,5,6,7,8};
	 */

	@Test
	public void test1() {
		int[] n = { 1, 3, 5, 7, 2, 4, 6, 8 };
		Assert.assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, arrangArray(n)));
	}

	@Test
	public void test2() {
		int[] n = { 1, 2, 3, 4, 11, 12, 13, 14 };
		Assert.assertTrue(Arrays.equals(new int[] { 1, 11, 2, 12, 3, 13, 4, 14 }, arrangArray(n)));
	}

	// @Test
	public void test3() {
		int[] n = { 1, 3, 5 };
		Assert.assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, arrangArray(n)));
	}

	/**
	 * Pseudo COde-
	 * 
	 * is net element from index 0 to arraylength/2 in 1 queue offer remaining ele
	 * in another queue
	 * 
	 * 
	 * first que seconde que first element
	 * 
	 * 
	 * 1,3,5,7 2,4,6,8
	 * 
	 * left - in
	 * 
	 * @param n
	 * @return
	 */
	private int[] arrangArray(int[] n) {
		// TODO Auto-generated method stub
		int left = 0;
		// int right = n.length / 2;

		ArrayDeque<Integer> firstQueue = new ArrayDeque<Integer>();

		while (left < n.length / 2) {
			firstQueue.offer(n[left]); // 1
			firstQueue.offer(n[left + (n.length / 2)]);// 2
			left++;
		}

		left = 0;
//		for (int i:firstQueue) {
//			n[index++] = i;
//
//		}
		while (!firstQueue.isEmpty()) {

			n[left++] = firstQueue.poll();
		}
		System.out.println(Arrays.toString(n));
		return n;

	}

}
