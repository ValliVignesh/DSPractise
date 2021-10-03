package Math;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WinnerOfCircularGame {
	@Test
	public void test1() {
		int n = 5, k = 2;
		Assert.assertEquals(3, findTheWinner(n, k));
	}

	@Test
	public void test2() {
		int n = 3, k = 1;
		Assert.assertEquals(3, findTheWinner(n, k));
	}

	@Test
	public void test3() {
		int n = 6, k = 1;
		Assert.assertEquals(6, findTheWinner(n, k));
	}
	public int findTheWinner(int n, int k) {
		int count = 0;

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		List<Integer> resultList = new ArrayList<Integer>();
		while (list.size() > 1) {
			for (int i = 0; i < list.size(); i++) {

				count++;
				resultList.add(list.get(i));
				if (k == 1) {
					if (count == k + 1) {
						resultList.remove(list.get(i));
						count = 0;
					}
				} else {
					if (count == k) {
						resultList.remove(list.get(i));
						count = 0;
					}
				}

			}
			list.clear();
			if (resultList.size() > 0) {
				for (int i = 0; i < resultList.size(); i++) {
					list.add(resultList.get(i));
				}
				resultList.clear();
			}

		}
		return list.get(0);
	}
}
