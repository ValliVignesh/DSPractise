package basic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class MinAsciiDeleteSum {//Need to check
//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/submissions/

	@Test
	public void test1() {
		String s1 = "delete";
		String s2 = "leet";
		Assert.assertEquals(403, minimumDeleteSum(s1, s2));
	}

	public int minimumDeleteSum(String s1, String s2) {
		List<Character> list1 = new ArrayList<Character>();
		int length;
		for (char c : s1.toCharArray()) {
			list1.add(c);
		}
		List<Character> list2 = new ArrayList<Character>();
		for (char c : s2.toCharArray()) {
			list2.add(c);
		}
		List<Character> commonList = new ArrayList<Character>();
		if (list1.size() > list2.size()) {
			length = list1.size();
			for (int i = 0; i < length; i++) {
				if (list2.contains(list1.get(i)))

					commonList.add(list1.get(i));

			}
		} else {
			length = list2.size();
			for (int i = 0; i < length; i++) {
				if (list1.contains(list2.get(i)))
					commonList.add(list2.get(i));

			}
		}

		for (int i = 0; i < commonList.size(); i++) {
			list1.remove(commonList.get(i));
			list2.remove(commonList.get(i));
		}
		int sum = 0;
		for (int i = 0; i < list1.size(); i++) {
			sum += (int) list1.get(i);
		}
		for (int i = 0; i < list2.size(); i++) {
			sum += (int) list2.get(i);
		}

		return sum;
	}
}