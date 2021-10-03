package amazon;

import org.junit.Assert;
import org.junit.Test;

public class StrintoI {
	// https://leetcode.com/problems/string-to-integer-atoi/submissions/

	@Test
	public void test1() {
		String s = "      -11919730356x";
		Assert.assertEquals(-2147483648, myAtoi(s));
	}

	@Test
	public void test2() {
		String s = "-167";
		Assert.assertEquals(-167, myAtoi(s));
	}
	@Test
	public void test3() {
		String s = "-abc";
		Assert.assertEquals(0, myAtoi(s));
	}

	public int myAtoi(String s) {
		int min = -2147483648;
		int max = 2147483647;

		StringBuilder sb = new StringBuilder();
		s = s.trim();

		if (s.equals(""))
			return 0;
		if (s.length() == 1) {
			if (Character.isDigit(s.charAt(0)))
				return Integer.parseInt(s.charAt(0) + "");
			else
				return 0;
		}
		try {
			for (int i = 0; i < s.length(); i++) { // Time-O(n) Space - O(1)
				if (i == 0) {
					if (s.charAt(i) == '-') {
						sb.append("-");
					} else if (s.charAt(i) == '+')
						continue;
					else if (!Character.isDigit(s.charAt(i))) {
						if (sb.toString().equals("") || sb.toString().equals(null))
							return 0;
						else
							return Integer.parseInt(sb.toString());
					} else {
						sb.append(s.charAt(i));
					}
				} else {
					if (s.charAt(i) == '-') {
						if (sb.toString().equals("") || sb.toString().equals(null))
							return 0;
						else
							return Integer.parseInt(sb.toString());
					} else if (s.charAt(i) == '+') {
						if (sb.toString().equals("") || sb.toString().equals(null))
							return 0;
						else
							return Integer.parseInt(sb.toString());

					} else if (!Character.isDigit(s.charAt(i))) {
						if (sb.toString().equals("") || sb.toString().equals(null))
							return 0;
						else {

							if (Double.parseDouble(sb.toString()) > (max))
								return max;
							else if (Double.parseDouble(sb.toString()) < (min))
								return min;
							else
								return Integer.parseInt(sb.toString());

						}

					} else {
						sb.append(s.charAt(i));
					}

				}

			}
		} catch (NumberFormatException e) {
			return 0;
		}

		if (Double.parseDouble(sb.toString()) > (max))
			return max;
		else if (Double.parseDouble(sb.toString()) < (min))
			return min;
		else
			return Integer.parseInt(sb.toString());
	}
}