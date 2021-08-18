package spotAssessment;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class RecentQuesAbcWithNums {

	/**
	 * Input - String,int[],int Ouput- String[] with true/false
	 * 
	 * Pseudo Code: assign alphabet with int value ato z as 1 to 26 get each value
	 * from string assign value as assign in alphbetmap if map does not have value
	 * put 1 for next value incment by 1 if map contains value already add value
	 * with value if a value is already taken Map will store integer[] value if its
	 * present in list or not
	 */
	@Test
	public void test1() {
		String str = "abccabf";
		int[] n = { 4, 2, 5, 3, 7 };
		Assert.assertArrayEquals(new String[] { "false", "true", "false", "true", "false" },
				findAlphaMap(str, n, n.length));

	}
	@Test
	public void test2() {
		String str = "abbccadf";
		int[] n = { 4, 2, 5, 3, 7 };
		Assert.assertArrayEquals(new String[] { "true", "true", "false", "true", "false" },
				findAlphaMap(str, n, n.length));

	}@Test
	public void test3() {
		String str = "abbbccaadf";
		int[] n = { 4, 2, 5, 3, 7,6 };
		Assert.assertArrayEquals(new String[] { "true", "true", "false", "true", "false","true" },
				findAlphaMap(str, n, n.length));

	}

	// Equi directional - two pointer or Sliding window or Map
	// target alone to map if reqd or Hashset

	private String[] findAlphaMap(String str, int[] n, int length) {// abbccadf
		// TODO Auto-generated method stub
		HashMap<Integer, String> numMap = new HashMap<Integer, String>(); // O(n)
		HashMap<Character, Integer> alphaMap = new HashMap<Character, Integer>();
		char[] ca = str.toCharArray();

		for (int j = 1; j < ca.length-1; j++) {

			if (ca[j - 1] == ca[j]) {
				alphaMap.put(ca[j], alphaMap.get(ca[j]) + (int) ca[j] - 96);
				numMap.put(alphaMap.get(ca[j]), "true");
			} else
				alphaMap.put(ca[j], (int) ca[j] - 96);
				numMap.put(alphaMap.get(ca[j]), "true");
		}

		String[] outArr = new String[length];
		for (int i = 0; i < length; i++) {
			if (numMap.containsKey(n[i])) {
				outArr[i] = "true";
			} else
				outArr[i] = "false";
		}

		return outArr;
	}
}
