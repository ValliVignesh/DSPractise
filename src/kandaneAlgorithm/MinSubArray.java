package kandaneAlgorithm;

import org.junit.Test;

public class MinSubArray {

	@Test()
	public void test1() {
		int n[] = { 0, -1, -3, 5, 7, 9 };
		findMinOfSubArray(n);

	}
	private int findMinOfSubArray(int[] n) {
		// TODO Auto-generated method stub

		int window_sum = n[0], min_sum = n[0];
		if (n.length == 0) {
			return -1;
		}
		for (int i = 1; i < n.length; i++) {
			window_sum = Math.min(window_sum + n[i], n[i]);
			min_sum = Math.min(window_sum, min_sum);
		}
		System.out.println(min_sum);
		return min_sum;

	}

}
