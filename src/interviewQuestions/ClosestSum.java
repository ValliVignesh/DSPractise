package interviewQuestions;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class ClosestSum {

	/**
	 * Given an integer array find the sum of two numbers close to the target
	 * 
	 * Return the indices of the matches
	 * 
	 * Int index = Arrays.asList(nums).indexOf(element);
	 * 
	
	 */
	@Test
	public void test1() {
		int n[] = { 12, 15, 20 };
		int k = 36;
		Assert.assertEquals(true, Arrays.equals(new int[] { 1, 2 }, findClosestNumber(n, k)));

	}
	@Test
	public void test2() {
		int n[] = { 12, 15, 20 };
		int k = 33;
		Assert.assertEquals(true, Arrays.equals(new int[] { 0, 1 }, findClosestNumber(n, k)));

	}@Test
	public void test3() {
		int n[] = { 12,33,17};
		int k = 46;
		Assert.assertEquals(true, Arrays.equals(new int[] { 0, 1 }, findClosestNumber(n, k)));

	}

	/**
	 * Pseudo code store value as key and index as value in map
	 * 
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	private int[] findClosestNumber(int[] n, int k) {
		// TODO Auto-generated method stub
		int[] index = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n.length; i++) {
			map.put(n[i], n[i]);
		}
		for (int i = 0; i < map.size()-1; i++) {
			int min=0;			
			min=Math.max(min, map.get(n[i]) + map.get(n[i + 1]));
			if (min<= k) {
				index[0] = i;
				index[1] = i + 1;
				System.out.println(Arrays.toString(index));
				return index;
			}
		}

		return new int[] { -1, -1 };
	}
}
