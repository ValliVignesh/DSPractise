package interviewQuestions;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ProductOfCell {

	/*
	 * 8 Given an int array find the product of all numbers except self
	 * 
	 * Eg- {2,3,4,5} output- {60,40,30,24} Without division operator
	 */

	@Test
	public void test1() {
		int n[] = { 2, 3, 4, 5 };
		Assert.assertTrue(Arrays.equals(new int[] { 60, 40, 30, 24 }, findProd(n)));
	}

	@Test
	public void test2() {
		int n[] = { -1, -2, 4, 5 };
		Assert.assertTrue(Arrays.equals(new int[] { -40, -20, 10, 8 }, findProd(n)));
	}

	@Test
	public void test3() {
		int n[] = { 0, 1, 2, 3 };
		Assert.assertTrue(Arrays.equals(new int[] { 6, 0, 0, 0 }, findProd(n)));
	}

	@Test
	public void test4() {
		int n[] = { 1, 2 }; // output - {2,1}
		Assert.assertTrue(Arrays.equals(new int[] { 2, 1 }, findProd(n)));
	}

	@Test
	public void test5() {
		int n[] = { 1, 2, 3, 4 }; // output - {2,1}
		Assert.assertTrue(Arrays.equals(new int[] { 24, 12, 8, 6 }, findProd(n)));
	}

	/**
	 * While right==left break
	 * 
	 * left =0 right=n.length until right ==left && right>=0
	 * 
	 * left - left++
	 *
	 * right
	 * 
	 * @param n
	 * @return
	 */

	private int[] findProd(int[] n) {
		// { 2, 3, 4, 5 };
		int nums = n.length;
		int ans[] = new int[nums];
		Arrays.fill(ans, 1);
		int curr = 1;
		for (int i = 0; i < nums; i++) {
			ans[i] *= curr;
			curr *= n[i];
		}
		curr = 1;
		for (int i = nums - 1; i >= 0; i--) {
			ans[i] *= curr;
			curr *= n[i];
		}
		System.out.println(Arrays.toString(ans));
		return ans;

	}

}
