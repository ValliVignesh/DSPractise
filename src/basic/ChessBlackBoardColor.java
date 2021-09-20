package basic;

import org.junit.Test;

import junit.framework.Assert;

public class ChessBlackBoardColor {

	// https://leetcode.com/problems/determine-color-of-a-chessboard-square

	@Test
	public void test1() {
		String s = "h3";
		Assert.assertEquals(true, squareIsWhite(s));
	}

	public boolean squareIsWhite(String coordinates) {
		int d;

		d = coordinates.charAt(0) - 96;
		System.out.println(d);
		if (d % 2 != 0) {
			if (((d * coordinates.charAt(1)) - 96) % 2 != 0)
				return false;
			else
				return true;

		} else {
			if (coordinates.charAt(1) % 2 == 0) {
				return false;
			} else
				return true;
		}

	}
}
