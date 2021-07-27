package Assessment2;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CharacterReProgramming {

	@Test
	public void test1() {
		String s = "RRR";
		finalPosition(s);
	}

	/**
	 * Input: URDR Output: 2
	 * 
	 * 1. Declare 4 variables up, right,down and left 2. iterate through the string
	 * and depending on character, increment the variables. Eg: up to be incremented
	 * for U, down for D etc 3. Find Y - modulus of (up-down) and X - modulus of
	 * (right-left) 4. Find sum of x & y 5. Return input string length- sum of X &
	 * y.
	 * 
	 * In the above case, sum of x & y would be 2 and input len - sum would be 2 and
	 * hence the output
	 **
	 **/

	static void finalPosition(String str) {
		int l = str.length();
		int countUp = 0, countDown = 0;
		int countLeft = 0, countRight = 0;

		for (int i = 0; i < l; i++) {

			if (str.charAt(i) == 'U')
				countUp++;

			else if (str.charAt(i) == 'D')
				countDown++;

			else if (str.charAt(i) == 'L')
				countLeft++;

			else if (str.charAt(i) == 'R')
				countRight++;
		}
	

		int s = Math.abs(countRight - countLeft) + Math.abs(countUp - countDown);
		System.out.println(l - s);
	}

}
