package inProgress;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMax {

	public int[] maxSlidingWindow(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		LinkedList<Integer> q = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
				q.removeLast();
			}

			q.addLast(i);

			if (q.getFirst() == i - k) {
				q.removeFirst();
			}

			if (i >= k - 1) {
				res.add(nums[q.getFirst()]);
			}
		}

		return res.stream().mapToInt(i -> i).toArray();
	}
}
