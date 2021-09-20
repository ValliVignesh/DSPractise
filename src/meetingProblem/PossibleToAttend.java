package meetingProblem;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class PossibleToAttend {
	/**
	 * Given an array of meeting time intervals where intervals[i] = [starti, endi],
	 * determine if a person could attend all meetings.
	 * 
	 * Example 1: Input: intervals = [[0,30],[5,10],[15,20]] Output: false Example
	 * 2: Input: intervals = [[7,10],[2,4]] Output: true
	 */
	@Test
	public void test1() {
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		Assert.assertEquals(false, findPossibleToAttend(intervals));
	}

	@Test
	public void test2() {
		int[][] intervals = { { 7, 10 }, { 2, 4 } };
		Assert.assertEquals(true, findPossibleToAttend(intervals));
	}

	private boolean findPossibleToAttend(int[][] intervals) {
		// TODO Auto-generated method stub

		// Sort by compartor (start and end times) so that compariosn can be done
		Arrays.sort(intervals, (a, b) -> {
			if (a[1] != b[1])
				return a[1] - b[1];// end times
			else
				return a[0] - b[0];// start times
		});

		// Let the first meeting be attended
		int endTime = intervals[0][1];

		// Iterate through every conference start and end
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= endTime) {// If start time >end

				endTime = intervals[i][1];// reset the endTime
				if (i == intervals.length - 1) {
					return true;
				}

			} else
				return false;
		}
		return false;
	}
}
