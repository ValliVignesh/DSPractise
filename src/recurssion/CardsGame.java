package recurssion;

import org.junit.Test;

import junit.framework.Assert;

public class CardsGame {
	/**
	 * Cards = {1,7,3} -> P1 (1+3) -> P2 (7) -> false Cards = {1,6,23,7} -> P1
	 * (1+23) -> P2 (6+7) -> true Cards = {1,2,2,1} -> P1 (1+2) -> P2 (2+1) -> true
	 * 2 Persons are playing the open cards and Person always need to pick the first
	 * card Rules 
	 * 1) Rule 1 - The person can pick only card on the either end (0,
	 * Len-1) 
	 * 2) Second Person can pick the card only after Person 1 picks it 3)
	 * Again, Person 1 can pick only after Person 2 picks Outcome 
	 * 1) If the points taken by Person 1 => Person 2 -> return true
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

	private boolean findPlayer1Wins(int[] n) {
		// TODO Auto-generated method stub
		
		
		return false;
	}
}
