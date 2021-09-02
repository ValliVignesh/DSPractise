package inProgress;

import java.util.Vector;

public class IncrementMSB {
	/**
	 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/559/
	 * 
	 * Given a non-empty array of decimal digits representing a non-negative
	 * integer, increment one to the integer.
	 * 
	 * The digits are stored such that the most significant digit is at the head of
	 * the list, and each element in the array contains a single digit.
	 * 
	 * You may assume the integer does not contain any leading zero, except the
	 * number 0 itself.
	 * 
	 * Example 1:
	 * 
	 * Input: digits = [1,2,3] Output: [1,2,4] Explanation: The array represents the
	 * integer 123.
	 * 
	 * Example 2: Input: digits = [4,3,2,1] Output: [4,3,2,2] Explanation: The array
	 * represents the integer 4321.
	 * 
	 * Example 3: Input: digits = [0] Output: [1]
	 */
	static void incrementVector(Vector<Integer> a) {
		int n = a.size();

		// Add 1 to last digit and find carry
		a.set(n - 1, a.get(n - 1) + 1);
		int carry = a.get(n - 1) / 10;
		a.set(n - 1, a.get(n - 1) % 10);

		// Traverse from second last digit
		for (int i = n - 2; i >= 0; i--) {
			if (carry == 1) {
				a.set(i, a.get(i) + 1);
				carry = a.get(i) / 10;
				a.set(i, a.get(i) % 10);
			}
		}

		// If carry is 1, we need to add
		// a 1 at the beginning of vector
		if (carry == 1)
			a.add(0, 1);
	}

	// Driver code
	public static void main(String[] args) {
		Vector<Integer> vect = new Vector<Integer>();
		vect.add(1);
		vect.add(7);
		vect.add(8);
		vect.add(9);

		incrementVector(vect);

		for (int i = 0; i < vect.size(); i++)
			System.out.print(vect.get(i) + " ");
	}
}
