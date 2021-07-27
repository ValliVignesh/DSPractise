package interviewQuestions;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class MovePoistiveNumbersRight {

	@Test
	public void test1() {
		int[] n = { -3, 5, 7, 0, -1, -5 };
		Assert.assertEquals(true, Arrays.equals(new int[] { -3, -5, -1, 0, 7, 5 }, movePositiveRight(n)));
	}

	/**
	 * Assign two pointers
	 * left to 0
	 * right to n.length
	 * if left>0 move to right
	 * else leave
	 * 
	 * @param n
	 * @return
	 */
	private int[] movePositiveRight(int[] n) {
		// TODO Auto-generated method stub
		int left = 0, right = n.length;
		int temp;
		while (left <= right) {
			if (n[left] > 0) {
				temp = n[left];
				n[left] = n[right];
				n[right] = temp;

			}
			left++;
			right--;
		}
		for(int i:n) {
			System.out.println(i);
		}
		return n;
	}
}
