package recurssion;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class CardsGame {
	/**
	 * Cards = {1,7,3} -> P1 (1+3) -> P2 (7) -> false Cards = {1,6,23,7} -> P1
	 * (1+23) -> P2 (6+7) -> true Cards = {1,2,2,1} -> P1 (1+2) -> P2 (2+1) -> true
	 * 2 Persons are playing the open cards and Person always need to pick the first
	 * card Rules 1) Rule 1 - The person can pick only card on the either end (0,
	 * Len-1) 2) Second Person can pick the card only after Person 1 picks it 3)
	 * Again, Person 1 can pick only after Person 2 picks Outcome 1) If the points
	 * taken by Person 1 => Person 2 -> return true
	 */
	/**
	 * Input - 1 int[] output - boolean Constraint - Recursion
	 */
	@Test
	public void test1() {
		int[] n = { 1, 7, 3 };
		Assert.assertEquals(true, findPlayer1Wins(n));
	}

	/**
	 * ArrayList of Integers
	 * 
	 * @param n
	 * @return
	 */
	int player1 = 0, player2 = 0;

	private boolean findPlayer1Wins(int[] n) {
		// TODO Auto-generated method stub

		if (n.length % 2 == 0)
			return true;
		if (n.length <= 1)
			return true;
		int[] output1 = new int[n.length - 1];
		if (n[0] >= n[n.length - 1]) {
			player1 += n[0];
			output1 = Arrays.copyOfRange(n, 1, n.length - 1);
		} else {
			player1 += n[n.length - 1];
			output1 = Arrays.copyOfRange(n, 0, n.length - 1);
		}
		int[] output2 = new int[n.length - 1];
		if (output1[0] >= output1[output1.length - 1]) {
			player2 += output1[0];
			output2 = Arrays.copyOfRange(output1, 1, output1.length - 1);
		} else {
			player2 += output1[output1.length - 1];
			output2 = Arrays.copyOfRange(output1, 0, output1.length - 1);
		}
		findPlayer1Wins(output2);
		return player1 >= player2 ? true : false;
	}
}
