package swiggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class ProductSort {
	/**
	 * Input --> int[] OutPut --> int[]
	 */

	@Test
	public void test1() {
		int[] n = { 4, 5, 6, 3, 4, 5 };
		Assert.assertTrue(Arrays.equals(new int[] { 3, 6, 4, 4, 5, 5 }, pdtSort(n)));
	}

	@Test
	public void test2() {
		int[] n = { 3, 3, 3, 4, 4, 5, 5, 1, 1, 1 };
		Assert.assertTrue(Arrays.equals(new int[] { 4, 4, 5, 5, 1, 1, 1, 3, 3, 3 }, pdtSort(n)));
	}

	@Test
	public void test3() {
		int[] n = { 3, 4, 5 };
		Assert.assertTrue(Arrays.equals(new int[] { 3, 4, 5 }, pdtSort(n)));
	}

	/**
	 * TEst data pseudo code -->5 mins
	 * Store the value in tree map --> add value and count return the keys in map
	 * 
	 * Time complexity --> O(n)+O(n log n)  --> O(n log n)
	 * Space completxity --> O(n) [map+List]
	 * @param n
	 * @return
	 * Implementation --> 30 mins
	 */
	private int[] pdtSort(int[] n) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>(); // Sorted based on key

		for (int i = 0; i < n.length; i++) { //O(n)
			map.put(n[i], map.getOrDefault(n[i], 0) + 1);
		}

		List<String> list = new ArrayList<String>();

		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
				.forEachOrdered(x -> list.add(x.getValue() + " " + x.getKey())); //O(n log n)

		int k = 0;
		for (int i = 0; i < list.size(); i++) { //O(n)
			String s = list.get(i);
			String[] c = s.split(" ");
			int j = 1;
			while (j <= Integer.valueOf(c[0])) { //O(m)
				n[k++] = Integer.valueOf(c[1]);
				j++;
			}
		}
		System.out.println(Arrays.toString(n));
		return n;
		
		//{3=1, 4=2, 5=2, 6=1} --> will try using iterator
	}
}


