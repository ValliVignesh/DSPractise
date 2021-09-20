package meetingProblem;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class CanTwoPeopleMeet {
	/**
	 * Given the availability time slots arrays slots1 and slots2 of two people and
	 * a meeting duration duration, return the earliest time slot that works for
	 * both of them and is of duration duration. If there is no common time slot
	 * that satisfies the requirements, return an empty array. The format of a time
	 * slot is an array of two elements [start, end] representing an inclusive time
	 * range from start to end. It is guaranteed that no two availability slots of
	 * the same person intersect with each other. That is, for any two time slots
	 * [start1, end1] and [start2, end2] of the same person, either start1 > end2 or
	 * start2 > end1.
	 * 
	 * Example 1: Input: slots1 = [[10,50],[60,120],[140,210]], slots2 =
	 * [[0,15],[60,70]], duration = 8 Output: [60,68] Example 2: Input: slots1 =
	 * [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
	 * Output: []
	 */
	@Test
	public void test1() {
		int[][] slot1 = { { 10, 50 }, { 60, 120 }, { 140, 210 } };
		int[][] slot2 = { { 0, 15 }, { 60, 70 } };
		int meetTime = 8;
		Assert.assertTrue(Arrays.equals(new int[] { 60, 68 }, timeToMeetFor(slot1, slot2, meetTime)));
	}

	@Test
	public void test2() {
		int[][] slot1 = { { 10, 50 }, { 60, 120 }, { 140, 210 } };
		int[][] slot2 = { { 0, 15 }, { 60, 70 } };
		int meetTime = 12;
		Assert.assertTrue(Arrays.equals(new int[] {}, timeToMeetFor(slot1, slot2, meetTime)));
	}

	private int[] timeToMeet(int[][] slot1, int[][] slot2, int meetTime) {
		// TODO Auto-generated method stub
		int k = 0;
		for (int i = 0; i < slot1.length; i++) {
			for (int j = 0; j <= i; j++) {
				if ((k < slot1.length)) {
					int person1 = slot1[i][0];
					int person2 = slot2[i][0];

					int max = Math.max(person1, person2);
					int person11 = slot1[i][1];
					int person21 = slot2[i][1];
					int min = Math.min(person11, person21);
					int abs = Math.abs(max - min);
					int diff = max - min;
					if (Math.abs(diff) >= meetTime) {
						System.out.println(max + " " + (max + meetTime));
						return new int[] { max, max + meetTime };
					}
					k++;
				}
			}

		}
		return new int[] {};
	}

	private int[] timeToMeetFor(int[][] slot1, int[][] slot2, int meetTime) {
		// TODO Auto-generated method stub
		Arrays.sort(slot1, (a, b) -> {
			if (a[1] != b[1])
				return a[1] - b[1];
			else
				return a[0] - b[0];
		});
		Arrays.sort(slot2, (a, b) -> {
			if (a[1] != b[1])
				return a[1] - b[1];
			else
				return a[0] - b[0];
		});
		int startTime = slot1[0][0];

		for (int i = 0; i < slot2.length; i++) {
			if (startTime == slot2[i][0]) {
				if (slot2[i][1] >= startTime + meetTime) {
					return new int[] { startTime, startTime + meetTime };
				}
			}
			startTime = slot1[i+1][0];
		}

		return new int[] {};
	}

}
