package basic;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class Aug6_HW {
	/**
	 * Problem 1) Alex and Lee play a game with piles of stones. There are an even
	 * number of piles arranged in a row, and each pile has a positive integer
	 * number of stones piles[i].
	 * 
	 * The objective of the game is to end with the most stones. The total number of
	 * stones is odd, so there are no ties.
	 * 
	 * Alex and Lee take turns, with Alex starting first. Each turn, a player takes
	 * the entire pile of stones from either the beginning or the end of the row.
	 * This continues until there are no more piles left, at which point the person
	 * with the most stones wins.
	 * 
	 * Assuming Alex and Lee play optimally, return True if and only if Alex wins
	 * the game.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: piles = [5,3,4,5] Output: true Explanation: Alex starts first, and can
	 * only take the first 5 or the last 5. Say he takes the first 5, so that the
	 * row becomes [3, 4, 5]. If Lee takes 3, then the board is [4, 5], and Alex
	 * takes 5 to win with 10 points. If Lee takes the last 5, then the board is [3,
	 * 4], and Alex takes 4 to win with 9 points. This demonstrated that taking the
	 * first 5 was a winning move for Alex, so we return true.
	 * 
	 * Input - int[] Output- Boolean
	 */
	@Test
	public void test1() {
		int n[] = { 5, 3, 4, 5 };
		Assert.assertEquals(true, ifAlexWins(n));
	}

	@Test
	public void test2() {
		int n[] = { 2, 3, 1, 1 };
		Assert.assertEquals(false, ifAlexWins(n));
	}

	@Test
	public void test3() {
		int n[] = { 2, 3, 1, 1, 3, 1, 1, 1 };
		Assert.assertEquals(true, ifAlexWins(n));
	}

	/**
	 * Integer to ARrayList Chck if 0 and n.length-1 value is greater assign it to
	 * alex reduce size to 1 chk if 0 to n.length-1 value is greater assign to Lee
	 * redice size to 1 cotninue till all elements are done find maximum value
	 *
	 *
	 *
	 *
	 * 
	 * @param n
	 * @return
	 */

	private boolean ifAlexWins(int[] n) {
		// TODO Auto-generated method stub
		int alexCount = 0; // int n[] = { 3, 1, 1,1};
		int leeCount = 0;
		int turn = 1;
		int tempCount = 0;
		int max = Integer.MIN_VALUE;

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n.length; i++) { // O(n)
			list.add(n[i]);
		}
		for (int i = 0; i < n.length; i++) { // O(n)
			if (list.get(0) >= list.get(list.size() - 1)) {
				tempCount = list.get(0);
				list.remove(0);
			} else {
				tempCount = list.get(list.size() - 1);
				list.remove(list.size() - 1);
			}

			if (turn % 2 != 0) {
				alexCount += tempCount;
			} else
				leeCount += tempCount;

			turn++;

		}
		System.out.println("Alex Count"+alexCount);
		System.out.println("Lee Count"+leeCount);
		max = Math.max(alexCount, leeCount); // O(1)
		if (max == alexCount)
			return true;

		return false;
	}
	
	/*Intilialize count =0 and left as starting index and right as length-1
	 * when count is 0 let alexa to pic the greater number from left or right
	 * if left is greater  right then increment the left 
	 * else right is greater than left decrement  the right
	 * sum the alexa values
	 * when count is 1 then let Lee to pick the greater value from left or right 
	 * continue same 
	 *sum the lee values
	 *if alexa is greater than lee then return true else return false	
	 */
}
