package Assessment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class MinDiffArray {
	@Test
	public void test1() {
		List<Integer> n = new ArrayList<Integer>();
		n.add(1);
		n.add(3);
		n.add(2);
		n.add(5);

		Assert.assertEquals(4, minDiff(n));
	}

	public int minDiff(List<Integer> n) {
		int sum = 0;
		Collections.sort(n);
		for (int i = 0; i < n.size() - 1; i++) {
			sum += Math.abs(n.get(i + 1) - n.get(i));
			System.out.println(sum);
		}
		return sum;
	}

}
