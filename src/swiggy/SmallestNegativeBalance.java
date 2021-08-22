package swiggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class SmallestNegativeBalance {
	/*
	 * Input: String array Output: String Constraint: Test Data: Positive:
	 * {"Alex Blake 2, Blake Alex 2, Casey Alex 5, Blake Casey 7, Alex Blake 4, Alex Casey 4"
	 * }
	 * 
	 * Output: "Casey" Edge: {"Alex Blake 4, Blake Alex 4"} Output:
	 * "Nobody has a negative balance" Negative: {"Alex Blake 4"} Output: Alex
	 *
	 * Approach:
	 *
	 * Time Complexity: Space Complexity:
	 */

	@Test
	public void test1() {
		String[] str = { "Alex Blake 2", "Blake Alex 2", "Casey Alex 5", "Blake Casey 7", "Alex Blake 4",
				"Alex Casey 4" };
		Assert.assertTrue(Arrays.equals(new String[] { "Alex", "Blake" }, findSmallestNegativeBalance(str)));
	}

	@Test
	public void test2() {
		String[] str = { "Alex Blake 4", "Blake Alex 4" };
		Assert.assertTrue(Arrays.equals(new String[] { "Nobody ", "has ", "a ", "negative ", "balance" },
				findSmallestNegativeBalance(str)));
	}

	@Test
	public void test3() {
		String[] str = { "Alex Blake 4" };
		Assert.assertTrue(Arrays.equals(new String[] { "Alex" }, findSmallestNegativeBalance(str)));
	}

	/*
	 * Pseudo code Create a tree map -> Key as string, Value as Integer Traverse
	 * through the string array Initialize the current string in temp Convert the
	 * temp to string array debt by splitting with space borrower = debt[0],lender =
	 * debt[1], amount = debt[2] If map not contains borrower, Add borrower as a key
	 * and update the value - amount Else update the value If map not contains
	 * lender, Add lender as a key and update the value + amount Else update the
	 * value Find min Create a list Traverse through the map and add the keys of min
	 * to the list Convert the list to array Return the array
	 */

	// Time Complexity: O(n)
	// Space Complexity: O(n)
	// Pseudo code - 20 min
	// Implementation-9 mins
	// Debugging - 5 mins

	private String[] findSmallestNegativeBalance(String[] str) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (int i = 0; i < str.length; i++) { // O(n)
			String temp = str[i];
			String[] debt = temp.split(" ");
			String borrower = debt[0];
			String lender = debt[1];
			int amount = Integer.parseInt(debt[2]);
			if (map.containsKey(borrower))
				map.put(borrower, map.get(borrower) - amount);
			else
				map.put(borrower, 0 - amount);
			if (map.containsKey(lender))
				map.put(lender, map.get(lender) + amount);
			else
				map.put(lender, amount);
		}
		int min = Collections.min(map.values());
		if (min >= 0)
			return new String[] { "Nobody ", "has ", "a ", "negative ", "balance" };
		List<String> list = new ArrayList<String>();
		for (Entry<String, Integer> entry : map.entrySet()) { // O(n)
			if (entry.getValue() == min)
				list.add(entry.getKey());
		}
		if (list.isEmpty())
			return new String[] { "Nobody ", "has ", "a ", "negative ", "balance" };
		String[] output = new String[list.size()];
		int index = 0;
		for (String each : list) // O(m)
			output[index++] = each;
		return output;
	}
}
