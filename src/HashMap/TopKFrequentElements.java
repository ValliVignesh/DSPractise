package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class TopKFrequentElements {

	@Test
	public void test1() {
		int[] n = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		Assert.assertTrue(Arrays.equals(new int[] { 1, 2 }, topKFrequent(n, k)));
	}

	@Test
	public void test2() {
		int[] n = { 4, 1, -1, 2, -1, 2, 3 };
		int k = 2;
		Assert.assertTrue(Arrays.equals(new int[] { 2, -1 }, topKFrequent(n, k)));
	}

	public int[] topKFrequent(int[] nums, int k) {
		int[] result = new int[k];
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(); // Values in descending order
		for (int i = 0; i < nums.length; i++) {

			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		int s = 0;
		List<Entry<Integer, Integer>> collect = new ArrayList<>(map.entrySet());
		Collections.sort(collect, Map.Entry.comparingByValue());
		for (Entry<Integer, Integer> ent : collect) {
			if (s == k)
				break;
			int ss = collect.size() - s;
			Entry<Integer, Integer> entry = collect.get(ss - 1);
			result[s] = entry.getKey();
			s++;
		}

		return result;

	}
}
