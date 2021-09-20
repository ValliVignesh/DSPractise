package BinarySearch;

import org.junit.Test;

import junit.framework.Assert;

public class Trivial {
	/**
	 * Find the minimum numbers of duplicate You are given an array ?? of of
	 * integers, length ??. What is the longest ("sub") array you can generate from
	 * ??, such that there are no duplicates within distance ?? of one another. The
	 * ("sub") array must be constructed by removing values from ??, i.e., the order
	 * must be preserved, but any entry may be skipped/ignored/removed. Trivial
	 * example: For ??=1, ??=[ 1,2,1,3,2], the answer is: 5 ([1,2,1,3,2]).
	 * Non-trivial example: For ??=2, ??=[1,2,1,3,2], the answer is: 4 ([2,1,3,2]).
	 * Note that in the non-trivial example, we had to skip the first element, such
	 * that we could add both 2's; else we would have had [1,2,3].
	 */

	@Test
	public void test1() {
		int[] n = { 1, 2, 1, 3, 2 };
		int distance = 1;
		Assert.assertEquals(5, findTrivialCount(n, distance));

	}

	@Test
	public void test2() {
		int[] n = { 1, 2, 1, 3, 2 };
		int distance = 2;
		Assert.assertEquals(4, findTrivialCount(n, distance));

	}

	private int findTrivialCount(int[] n, int distance) {
		// TODO Auto-generated method stub
		int count = n.length;
		if (distance >= n.length)
			return -1;
		for (int i = 0; i < n.length - 2; i++) {
			if (n[i] == n[i + distance]) {
				count = count - 1;
			}
		}

		return count;

	}
}
