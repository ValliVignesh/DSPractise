package string;

import org.junit.Test;

import junit.framework.Assert;

public class MultiplyIntAsString {

	// https://leetcode.com/problems/multiply-strings

	@Test
	public void test1() {
		String s1 = "5";
		String s2 = "15";
		Assert.assertEquals("75", multiply(s1, s2));
	}

	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		int l1 = num1.length();
		int l2 = num2.length();
		int res[] = new int[l1 + l2];
		int i = l2 - 1;
		int pf = 0;
		while (i >= 0) {
			int ival = num2.charAt(i) - '0';
			i--;

			int j = l1 - 1;
			int carry = 0;
			int k = res.length - 1 - pf;
			while (j >= 0 || carry != 0) {
				int jval = j >= 0 ? num1.charAt(j) - '0' : 0;
				j--;

				int prod = ival * jval + carry + res[k];
				res[k] = prod % 10;
				carry = prod / 10;
				k--;

			}
			pf++;
		}

		// Management of leading zeroes
		// lets find out when non-zero number starts and put flag=true when we find it
		String s = "";
		boolean flag = false;
		for (int it = 0; it < res.length; it++) {
			if (res[it] == 0 && flag == false) {
				// leading zeroes
				continue;
			} else {
				flag = true;
				s += res[it];
			}
		}
		return s;

	}
}
