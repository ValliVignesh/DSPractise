package basic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class kArrays {
	@Test
	public void test1() {
		int k = 3;
		List<Integer> nums = new ArrayList<Integer>();

		nums.add(5);
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(1);
		System.out.println(kSub(k, nums));
	}

	public static long kSub(int k, List<Integer> nums) {
		// Write your code here
		int count = 0;
		int[] num = new int[nums.size()];
		int left = 0, right = 0;

		while (left < nums.size()) {
			int sum = num[left];
			while (right < nums.size()) {
				if (left == right) {
					if (num[right] % k == 0)
						count++;
				} else {
					sum += num[right];
					if (sum % k == 0)
						count++;
				}
				right++;
			}
			left++;
			right = left;
		}
		return count;
	}

}
