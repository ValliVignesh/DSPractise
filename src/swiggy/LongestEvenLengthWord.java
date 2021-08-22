package swiggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

public class LongestEvenLengthWord {

	/**
	 * 
	 * Input - String Output - String
	 * 
	 * Split String and then chk if length is even find the max even length word
	 * return
	 */

	@Test
	public void test1() {
		String s = "Time to write great code";
		Assert.assertEquals("Time", findEvenMaxWord(s));
	}

	@Test
	public void test2() {
		String s = "to write great code";
		Assert.assertEquals("code", findEvenMaxWord(s));
	}

	@Test
	public void test3() {
		String s = "to write great codee";
		Assert.assertEquals("to", findEvenMaxWord(s));
	}
	private String findEvenMaxWord(String s) {
		// TODO Auto-generated method stub
		String[] str = s.split("\\s+"); //if more spaces are there to handle
		String cap = null;
		int max = 0;
		
		for (int i = 0; i < str.length; i++) { // O(n)
			if (str[i].length() % 2 == 0) {
				if (max < str[i].length()) {
					max = str[i].length();
					cap = str[i];
				}
			}
		}
		return cap;
	}
}
