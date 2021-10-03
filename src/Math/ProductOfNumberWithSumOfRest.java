package Math;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ProductOfNumberWithSumOfRest {

	@Test
	public void test1() {
		int n = 3;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(6);
	}

	private static List<Integer> findPdt(int n, List<Integer> list) {
		int pdt = 1;
		int sum = 0;
		int temp = 0;
		List<Integer> resList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);

		}
		for (int i = 0; i < list.size(); i++) {
			temp = list.get(i) * (sum - list.get(i));
			resList.add(temp);

		}

		return resList;
	}
}
