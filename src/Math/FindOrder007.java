package Math;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FindOrder007 {

	@Test
	public void test1() {
		int[] n = { 1, 2, 4, 0, 0, 7, 5 };
		Assert.assertTrue(findOrder(n));
	}

	@Test
	public void test2() {
		int[] n = { 1, 0, 2, 4, 0, 5, 7 };
		Assert.assertTrue(findOrder(n));
	}

	@Test
	public void test3() {
		int[] n = { 1, 7, 2, 0, 4, 5, 0 };
		Assert.assertFalse(findOrder(n));
	}

	@Test
	public void test5() {
		int[] n = { 0, 7, 0, 7 };
		Assert.assertFalse(findOrder(n));
	}

	private boolean findOrder(int[] n) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();
		int count = 0;
		for (int i = 0; i < n.length; i++) {
			list.add(n[i]);
			if (n[i] == 7) {
				while (i > 0) {
					if (n[i - 1] == 0) {
						count++;
					}
					i--;
				}
				if (count == 2)
					return true;
				else
					return false;
			}
		}

		return false;
	}
}
