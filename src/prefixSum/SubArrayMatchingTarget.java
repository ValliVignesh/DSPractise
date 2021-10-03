package prefixSum;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class SubArrayMatchingTarget {

	@Test
	public void test1() {
		int n[] = { 1, 2, 3, 4 };
		int k = 3;
		Assert.assertEquals(2, findCountOfSubArrayMatchingK(n, k));
	}

	private int findCountOfSubArrayMatchingK(int[] n, int k) {
		// TODO Auto-generated method stub
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		int sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum += n[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);

		}

		return count;
	}

}
