package meetingProblem;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class meetingRoom {

	/**
	 * Amazon first round Input-start time HH MM End Time HH MM Output-int Minimum
	 * Number of Rooms required to conduct meeting
	 */
	@Test
	public void test1() {
		String[][] meetingTimes = { { "09 00", "09 45" }, { "09 30", "10 30" }, { "10 40", "12 00" },
				{ "11 00", "13 00" }, { "11 45", "14 00" }, { "16 00", "17 00" } };
		Assert.assertEquals(3, findMeetingRooms(meetingTimes));
	}

	private int findMeetingRooms(String[][] meetingTimes) {
		// Min rooms required by default array size
		int meetingRooms = meetingTimes.length;
		// TODO Auto-generated method stub

		int[][] meetTimes = new int[meetingTimes.length][2];
		for (int i = 0; i < meetingTimes.length; i++) {
			meetTimes[i][0] = Integer.parseInt(meetingTimes[i][0].replace(" ", ""));
			meetTimes[i][1] = Integer.parseInt(meetingTimes[i][1].replace(" ", ""));
		}

		// Sort by compartor (start and end times) so that compariosn can be done
		Arrays.sort(meetTimes, (a, b) -> {
			if (a[1] != b[1])
				return a[1] - b[1];// end times
			else
				return a[0] - b[0];// start times
		});

		// start and end
		int start = 0, end = 0;

		// Iterate over every meeting
		while (start < meetTimes.length) {
			if (meetTimes[start++][0] > meetTimes[end][1]) {
				meetingRooms--;
				end++;
			}

		}
		return meetingRooms;
	}
}
