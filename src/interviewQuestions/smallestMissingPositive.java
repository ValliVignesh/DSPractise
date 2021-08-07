package interviewQuestions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class smallestMissingPositive {

	@Test
	public void test1() {
		int n[] = { 3, 5, 7, 9 };
		Assert.assertEquals(1, findSmallesMissingIntMapping(n));
	}

	@Test
	public void test4() {
		int n[] = { 1, 2, 3, 6, 7, 8, 10 };
		Assert.assertEquals(4, findSmallesMissingIntMapping(n));
	}

	@Test
	public void test2() {
		int n[] = { 9, 2, 1 };
		Assert.assertEquals(3, findSmallesMissingIntMapping(n));
	}

	@Test
	public void test3() {
		int n[] = { -3, -1, 0 };
		Assert.assertEquals(1, findSmallesMissingIntMapping(n));
	}

	@Test
	public void test5() {
		int n[] = { 1, 3, 2 };
		Assert.assertEquals(4, findSmallesMissingIntMapping(n));
	}
	@Test
	public void test6() {
		int n[] = { 9, 3, 1 };
		Assert.assertEquals(2, findSmallesMissingIntMapping(n));
	}

	/**
	 * 
	 * 
	 * 
	 * @param n
	 * @return
	 */
	private int findSmallesMissingInt(int[] n) {

		List<Integer> arrlist = new ArrayList<Integer>();
		for (int i = 1; i <= n.length + 1; i++) {
			arrlist.add(i);
		}

		List<Integer> inputarrlist = new ArrayList<Integer>();
		for (int i = 0; i < n.length; i++) {
			inputarrlist.add(n[i]);
		}

		for (int i = 0; i < arrlist.size(); i++) {
			if (!inputarrlist.contains(arrlist.get(i))) {
				System.out.println(arrlist.get(i));
				return arrlist.get(i);
			}

		}
		return 1;

		// TODO Auto-generated method stub

	}

	private int findSmallesMissingIntO1(int[] n) {
		// int n[] = { 3, 5, 7, 9 };
		ArrayList<Integer> newList = new ArrayList<Integer>(); // O(n)
		for (int i : n) {
			newList.add(i);
		}
		int j = 1;

		for (int i = 0; i < n.length; i++) { // O(n)
			if (!newList.contains(j)) {
				return j;
			}
			j++;

		}
		return 1;

		// TODO Auto-generated method stub

	}

	private int findSmallesMissingIntMapping(int[] n) {
		// int n[] = { 3, 5, 7, 9 };
		boolean checkOne = false;

		for (int i = 0; i < n.length; i++) {
			if (n[i] == 1) {
				checkOne = true;
				break;
			}
		}

		if (checkOne == false)
			return 1;

		int i = 0;
		while (i < n.length) {
			if (n[i] <= 0 || n[i] > n.length) {
				n[i] = 1;

			}
			i++;
		}
		for (i = 0; i < n.length; i++) {
			int index = Math.abs(n[i]);

			if (index < n.length) {
				n[index] = -1 * Math.abs(n[index]);
			} else {
				n[0] = -1 * Math.abs(n[i]);
			}
		}

		for (i = 1; i <n.length; i++) {
			if (n[i] > 0)
				return i;
			if (n[0] > 0)
				return n.length;
		}
		return n.length + 1;

		// TODO Auto-generated method stub

	}
}