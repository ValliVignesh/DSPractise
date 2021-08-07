package recurssion;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class RecurssionProb {

	/**
	 * Fibonacci Series Given index find the value in Fibonacci Series
	 * 
	 * No.of.Ocuurances of 1 - unsorted Two strings - find how many substrings in a
	 * string Test Leaf Welcomes you to TEst Leaf find Test in the sentence
	 * 
	 * 
	 * 1.Find the base point 2.Find simple test data 3.Chk logic with edge and
	 * negative data 4.Identify Pattern/logic 5.Implement
	 * 
	 */
	// 0,1,1,2,3
	@Test
	public void test1() {
		int n = 5;
		Assert.assertEquals(3, fibo(n));
	}

	/**
	 *
	 * 
	 * @param n
	 * @return
	 */

	private int fibo(int n) {
		// TODO Auto-generated method stub

		if (n == 1)
			return 0;
		if (n == 2)
			return 1;

		return fibo(n - 1) + fibo(n - 2);

	}
}
