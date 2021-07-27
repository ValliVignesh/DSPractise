package SlidingWindow;

import org.junit.Test;

import junit.framework.Assert;

public class ArrayMaximumSum {
	/**
	 * https://leetcode.com/problems/partition-array-for-maximum-sum/
	 */
	@Test
	public void test1() {
		int n[] = { 1, 15, 7, 9, 2, 5, 10 };
		int k = 3;
		Assert.assertEquals(84, findarrayMaxSum(n, k));
	}

	@Test
	public void test2() {
		int n[] = { 1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3 };
		int k = 4;
		Assert.assertEquals(83, findarrayMaxSum(n, k));
	}

	@Test
	public void test3() {
		int n[] = { 1 };
		int k = 1;
		Assert.assertEquals(1, findarrayMaxSum(n, k));
	}

	/**
	 * traverse from 0 to k+1 th value and get the maximum number in array and the
	 * index in array if k is maximum value thean k+1 chagne all value in array from
	 * 0 to k as maxvalue if k+1 is max value change al vaue from 1 to k+1 as max
	 * value traverse till end of array return sum of newArray
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	private int findMaxSum(int[] n, int k) {
		// TODO Auto-generated method stub
		if (n.length == 1)
			return n[0];
		int sum = 0;
		int maxValue = 0;
		int maxIndex = 0;
		for (int i = 0; i <= k; i++) {
			if (n[i] > maxValue) {
				maxValue = n[i];
				maxIndex = i;
			}

		}
		for (int i = 0; i < k; i++) {
			if (maxIndex < k) {
				n[i] = maxValue;
			} else {
				n[maxIndex] = n[i];
				n[i] = maxValue;
			}

			sum += n[i];
		}

		int i = 0;
		if (maxIndex < k) {
			i = k;
		} else {
			i = k + 1;
		}
		int j = i;
		maxValue = 0;

		for (; i < n.length; i++) {

			if (n[i] > maxValue) {
				maxValue = n[i];
				maxIndex = i;

			}
		}

		for (; j < n.length; j++) {
			if (j < maxIndex && k - j >= k) {
				n[j] = maxValue;
			} else {
				n[maxIndex] = n[j];
				n[j] = maxValue;
			}
			System.out.println(n[j]);
			sum += n[j];
		}

		return sum;
	}
// { 1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3 };
	private int findarrayMaxSum(int[] n,int k) {
		if (n.length == 1)
			return n[0];
		int i,j,size=n.length,max;
		int[] newArr= new int[size+1];
		for(i=1;i<=size;i++) {
			max=n[i-1];
			for(j=1;j<=k && i-j>=0;++j) {
				max=Math.max(max, n[i-j]);
				newArr[i]=Math.max(newArr[i], newArr[i-j]+j*max);
			}
		}
		
		return newArr[size];

	}
}
