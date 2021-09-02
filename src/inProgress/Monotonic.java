package inProgress;

public class Monotonic {
	/**
	 * https://leetcode.com/problems/monotonic-array/solution/
	 * Given an array, return true if and only if the given array A is monotonic. An
	 * array is monotonic if it is either monotone increasing or monotone
	 * decreasing. Input: [1,2,3,3,4,4,4,4,5] Output: true Input:
	 * [1,2,5,3,4,4,4,4,5] Output: false Input: [5,4,4,2,1] Output: true 1. Math
	 * manipulation
	 * 
	 * Remove vowels Input: TestLeaf Output: Tstlf 1. StringBuffer
	 */

	public boolean isMonotonic(int[] A) {
		return increasing(A) || decreasing(A);
	}

	public boolean increasing(int[] A) {
		for (int i = 0; i < A.length - 1; ++i)
			if (A[i] > A[i + 1])
				return false;
		return true;
	}

	public boolean decreasing(int[] A) {
		for (int i = 0; i < A.length - 1; ++i)
			if (A[i] < A[i + 1])
				return false;
		return true;
	}

	public boolean isMonotonicOnePass(int[] A) {
		int store = 0;
		for (int i = 0; i < A.length - 1; ++i) {
			int c = Integer.compare(A[i], A[i + 1]);
			if (c != 0) {
				if (c != store && store != 0)
					return false;
				store = c;
			}
		}

		return true;
	}

	public boolean isMonotonicOptimized(int[] A) {
		boolean increasing = true;
		boolean decreasing = true;
		for (int i = 0; i < A.length - 1; ++i) {
			if (A[i] > A[i + 1])
				increasing = false;
			if (A[i] < A[i + 1])
				decreasing = false;
		}

		return increasing || decreasing;
	}
}
