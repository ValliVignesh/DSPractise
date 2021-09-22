package string;

import org.junit.Assert;
import org.junit.Test;

public class QuestionMarks {

	@Test
	public void test1() {
		String s = "?ab??a";
		Assert.assertEquals("aabbaa", chckPalindrome(s));

	}
	@Test
	public void test2() {
		String s = "bab??a";
		Assert.assertEquals("NO", chckPalindrome(s));

	}
	private String chckPalindrome(String s) {
		// TODO Auto-generated method stub

		int n = s.length();
		char a[] = s.toCharArray();
		StringBuffer sbs=new StringBuffer();
		int flag = 0;
		for (int i = 0; i < n / 2; i++) {
			if (a[i] != '?' && a[n - 1 - i] != '?' && a[i] != a[n - 1 - i]) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			return "NO";
		} else {
			for (int i = 0; i < n; i++) {
				if (a[i] == '?') {
					if (a[n - 1 - i] == '?') {
						a[i] = 'a';
						a[n - 1 - i] = 'a';
					} else {
						a[i] = a[n - 1 - i];
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				System.out.print(a[i]);
				sbs.append(a[i]);
			}
			System.out.println();
		}
		return sbs.toString();
	}
}


