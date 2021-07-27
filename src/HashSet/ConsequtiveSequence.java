package HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class ConsequtiveSequence {
	/**
	 * 3)https://leetcode.com/problems/longest-consecutive-sequence/ - Try to solve
	 * in O(n) - HashSet
	 * 
	 */

	/*
	 * Given an unsorted array of integers nums, return the length of the longest
	 * consecutive elements sequence.
	 * 
	 * You must write an algorithm that runs in O(n) time.
	 * 
	 * Input: nums = [100,4,200,1,3,2] Output: 4 Explanation: The longest
	 * consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
	 * Input: nums = [0,3,7,2,5,8,4,6,0,1] Output: 9
	 */

	/**
	 * 1) Did I understand the problem? Yes or No !! -> If No, Ask the person to
	 * provide more detail with example(s) -> If yes, go to next step !!
	 * 
	 * Yes
	 * 
	 * What is the input(s)? intarr[] What is the expected output? int length Do I
	 * have constraints to solve the problem? O(n) Do I have all informations to go
	 * to next step!! How big is your test data set will be?
	 * 
	 * 2) Test data set
	 * 
	 * Minimum of 3 data set !! Positive, Edge, Negative Validate with the
	 * interviewer if the data set is fine by his/her assumptions Positive :
	 * Negative : Edge :
	 * 
	 * 3) Do I know how to solve it?
	 * 
	 * Yes - great, is there an alternate? No - Can I break down the problem into
	 * sub problems?
	 * 
	 * 4) Ask for hint (If you do not know how to solve)
	 * 
	 * 5) Do I know alternate solutions as well?
	 * 
	 * Yes - What are those? No - That is still fine, proceed to solve by what you
	 * know !!
	 * 
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 * 
	 * Then, explain either both or the best (depends on the time)
	 * 
	 * Approach 1: Start with worst -> Improve (Optimize) -> End up with the best
	 * Approach 2: Write down the options and benefits and code the best
	 * 
	 * 7) Start always with Psuedo code
	 * 
	 * 8) Implement them in the code (editor)
	 * 
	 * 9) Test against the different data set
	 * 
	 * 10) If it fails, debug them to solve it !! /*
	 * 
	 * 
	 */

	@Test
	public void testcase1() {

		int[] intarr = { 100, 4, 200, 1, 3, 2 };
		findLongestSequence(intarr);

	}

	@Test
	public void testcase2() {
		int[] intarr = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		findLongestSequence(intarr);
	}

	@Test
	public void testcase3() {
		int[] intarr = {};
		findLongestSequence(intarr);
	}

	@Test
	public void testcase4() {
		int[] intarr = { 0, -1 };
		findLongestSequence(intarr);
	}

	@Test
	public void testcase5() {
		int[] intarr = { 1, 2, 3, 44, 55, 34, 5, 6, 7, 8 };
		findLongestSequence(intarr);
	}

	/*
	 * Add the given elements into set to remove the duplicates
	 * 
	 * Add the elements from set to Arraylist
	 * 
	 * Increment the window size .. if arraylist contains the next element .
	 * 
	 * If it does not have the next element shrink the window *
	 * 
	 * 
	 * {1,2,3,44,55,34,5,6,7,8}
	 * 
	 * 
	 * 
	 * 
	 */

	public int findLongestSequence(int[] intarr) {

		if (intarr.length == 0)
			return 0;

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < intarr.length; i++) {
			set.add(intarr[i]);
		}

		ArrayList<Integer> arrlist = new ArrayList<Integer>();

		for (Integer integer : set) {
			arrlist.add(integer);
		}

		int windowstart = 0;
		int maxlength = Integer.MIN_VALUE;

		for (int windowend = 0; windowend < arrlist.size(); windowend++) {
			int inputvalue = arrlist.get(windowend);

			while (!arrlist.contains(inputvalue + 1) && windowstart < arrlist.size()) {
				// int leftvalue = intarr[windowstart];

				maxlength = Math.max(maxlength, (windowend - windowstart) + 1);

				// arrlist.remove(leftvalue);

				windowstart++;
			}
		}
		System.out.println(maxlength);
		return maxlength;

	}

}
