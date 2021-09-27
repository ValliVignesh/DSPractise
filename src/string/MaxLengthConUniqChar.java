package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class MaxLengthConUniqChar {
	// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

	@Test
	public void test1() {
		List<String> s = new ArrayList<String>();
		s.add("cha");
		s.add("r");
		s.add("act");
		s.add("ers");
		Assert.assertEquals(6, maxLength(s));

	}

	@Test
	public void test2() {
		List<String> s = new ArrayList<String>();
		s.add("abcdefghijlklmnopqrstuwxyz");
		Assert.assertEquals(26, maxLength(s));
	}

	@Test
	public void test3() {
		List<String> s = new ArrayList<String>();
		s.add("a");
		s.add("b");
		s.add("c");
		s.add("d");
		Assert.assertEquals(4, maxLength(s));

	}

	private int maxLength(List<String> arr) {
		// TODO Auto-generated method stub
		// Input List<String>
		// Output int
		// Push each String to Map
		// Chk previos length+currentLenght>max
		// if so replace max
		// return max

		// we need to check there is no character repeated

		int prevL = 0;
		int currL = 0;
		int max = 0;
		if (arr.size() == 1)
			return arr.get(0).length();
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> st = new ArrayList<String>();
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		StringBuilder sb = new StringBuilder();
		prevL = arr.get(0).length();
		sb.append(arr.get(0));
		for (int i = 0; i < arr.size(); i++) {
			map.put(arr.get(i), arr.get(i).length());
			st.add(arr.get(i));
			for (int j = i + 1; j < arr.size(); j++) {
				for (int k = 0; k < arr.get(j).length(); k++) {

					if (st.toString().contains(arr.get(j).charAt(k)+"")) {
						map1.clear();
						break;
					}
					if (k == arr.get(j).length() - 1) {
						map1.put(arr.get(j), arr.get(j).length());
						sb.append(arr.get(j));
						st.add(arr.get(j));
					}

				}
				currL = sb.length();
				
			}
		
			max = Math.max(max, currL);

		}
		System.out.println(sb.toString());
		return max;
	}

}
