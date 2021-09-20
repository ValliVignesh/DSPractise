package kandaneAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class MaxSumClass {
	@Test()
	public void test1() {
		int n[] = { 0, -1, -3, 5, 7, 9 };
		findMaxOfSubArray(n);

	}

	private int[] findMaxOfSubArray(int[] n) {
		// TODO Auto-generated method stub
		ArrayList<Integer> output = new ArrayList<Integer>();
		int[] result = new int[output.size()];
		int window_sum = n[0], min_sum = n[0];
		if (n.length == 0) {
			return new int[] { -1, -1 };
		}
		for (int i = 1; i < n.length; i++) {

			output.add(n[i]);
			window_sum = Math.max(window_sum + n[i], n[i]);
			min_sum = Math.max(window_sum, min_sum);
		}
		System.out.println(min_sum);
		int[] result1 = new int[output.size()];
		for (int i = 0; i < output.size(); i++) {
			result[i] = output.get(i);
		}
		return result1;
	}

}
