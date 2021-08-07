package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindNumebrOfFactorsOfGivenNumber {
	/**
	 * Given a number n find the k number of factors i/p - 7 k=4 , o/p -1,7
	 */

	@Test
	public void test1() {
		int n = 7;
		int k = 2;
		Assert.assertEquals(7, findFactorsSpaceComplex(n, k));
	}

	@Test(expected = RuntimeException.class)
	public void test2() {
		int n = 7;
		int k = 3;
		Assert.assertEquals(-1, findFactors(n, k));
	}

	@Test(expected = RuntimeException.class)
	public void test3() {
		int n = 4;
		int k = 4;
		Assert.assertEquals(-1, findFactors(n, k));
	}

	@Test
	public void test4() {
		int n = 1000;
		int k = 3;
		Assert.assertEquals(4, findFactors(n, k));
	}

	private int findFactors(int n, int k) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				list.add(i);
				if (list.size() == k)
					return list.get(k - 1);
			}
		}
		throw new RuntimeException("There is no " + k + "Factor available for number " + n);
	}

	private int findFactorsSpaceComplex(int n, int k) {
		// TODO Auto-generated method stub
		int j = 1;
		for (int i = 1; i <= n; i++) { //O(n)
			if (n % i == 0) {

				if (j == k)
					return i; //O(1)
				j++;
			}
		}
		throw new RuntimeException("There is no " + k + "Factor available for number " + n);
	}
}
