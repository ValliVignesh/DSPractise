package string;

import org.junit.Test;

import junit.framework.Assert;

public class InterLeavingString {

	@Test
	public void test1() {
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";

		Assert.assertEquals(true, isInterleave(s1, s2, s3));
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length()) {
			return false;
		}
		boolean dp[] = new boolean[s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 && j == 0) {
					dp[j] = true;
				} else if (i == 0) {
					dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
				} else if (j == 0) {
					dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
				} else {
					dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
							|| (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
				}
			}
		}
		return dp[s2.length()];
	}
}
