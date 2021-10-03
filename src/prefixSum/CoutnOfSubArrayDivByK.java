package prefixSum;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class CoutnOfSubArrayDivByK {
	@Test
	public void test1() {
		int n[] = { 1, 2, 3, 4 };
		int k = 2;
		Assert.assertEquals(3, findCountOfSubArrayDivK(n, k));
	}

	private int findCountOfSubArrayDivK(int[] n, int k) {
		// TODO Auto-generated method stub
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		int sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum += n[i];
			int r=sum%k;
			if(r<0) r=(sum%k)+k;
			if (map.containsKey(r))
				count += map.get(r);
			map.put(r, map.getOrDefault(sum, 0) + 1);

		}

		return count;
	}

}
