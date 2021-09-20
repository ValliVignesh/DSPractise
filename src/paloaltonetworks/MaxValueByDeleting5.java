package paloaltonetworks;

import org.junit.Test;

import junit.framework.Assert;

public class MaxValueByDeleting5 {

	@Test
	public void test1() {
		int n = -15657;
		Assert.assertEquals(-1567, solution5(n));
	}

	@Test
	public void test2() {
		int n = -12535;
		Assert.assertEquals(-1235, solution5(n));
	}

	private int solution1(int n) {
		boolean isNegative = false;
		if (n < 0) {
			isNegative = true;
			n *= -1;
		}
		String s = Integer.toString(n);
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '5') {
				String temp = s.substring(0, i) + s.substring(i + 1);
				int tempInt = Integer.parseInt(temp);
				if (isNegative)
					min = Math.min(tempInt, min);
				else
					max = Math.max(tempInt, max);
			}
		}
		return isNegative ? min * -1 : max;

	}

	private int solution2(int n) {
		String s = Integer.toString(n);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '5') {
				String temp = s.substring(0, i) + s.substring(i + 1);
				int tempInt = Integer.parseInt(temp);
				max = Math.max(tempInt, max);
			}
		}
		return max;
	}

	private int solution3(int n) {
		String s = Integer.toString(n);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '5') {
				StringBuilder sb = new StringBuilder(s);
				max = Math.max(Integer.parseInt(sb.deleteCharAt(i).toString()), max);
			}
		}
		return max;
	}

	private int solution4(int n) {
		String s = Integer.toString(n);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '5') {
				StringBuffer sb = new StringBuffer(s);
				max = Math.max(Integer.parseInt(sb.deleteCharAt(i).toString()), max);
			}
		}
		return max;
	}

	private int solution5_1(int n) {// try1
		int max = Integer.MIN_VALUE;
		char[] str = Integer.toString(n).toCharArray();
		StringBuffer sb = new StringBuffer(String.valueOf(str));
		for (int i = 0; i < Integer.toString(n).length(); i++) {
			if (str[i] == '5') {
				int deletedVal = Integer.parseInt(sb.deleteCharAt(i).toString());
				if (max < deletedVal) {
					max = deletedVal;
				}
			}
		}

		return max;
	}

	private int solution5(int n) {// try1
		int max = Integer.MIN_VALUE;
		char[] str = Integer.toString(n).toCharArray();
		for (int i = 0; i < Integer.toString(n).length(); i++) {
			StringBuffer sb = new StringBuffer(String.valueOf(str));
			if (str[i] == '5') {
				int deletedVal = Integer.parseInt(sb.deleteCharAt(i).toString());
				if (max < deletedVal) {
					max = deletedVal;
				}
			}
		}

		return max;
	}

}
