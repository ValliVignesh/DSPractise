package assessment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MaxPresentation {

	@Test
	public void example() {
		List<Integer> scheduleStart = new ArrayList<>(Arrays.asList(1, 1, 2));
		List<Integer> scheduleEnd = new ArrayList<>(Arrays.asList(3, 2, 4));

		int maxPresentations = maxPresentations(scheduleStart, scheduleEnd);
		System.out.println(maxPresentations);
	}

	@Test
	public void example1() {
		List<Integer> scheduleStart = new ArrayList<>(Arrays.asList(6, 1, 2, 4));
		List<Integer> scheduleEnd = new ArrayList<>(Arrays.asList(8, 9, 4, 7));

		int maxPresentations = maxPresentations(scheduleStart, scheduleEnd);
		System.out.println(maxPresentations);
	}

	public int maxPresentations(List<Integer> scheduleStart, List<Integer> scheduleEnd) {

		// Create 2 dimensional array to start comparision with start and end at once
		int[][] conferneceTimes = new int[scheduleStart.size()][2];

		// Push the start and end time to 2 dimensional array for sorting
		for (int i = 0; i < conferneceTimes.length; i++) {
			conferneceTimes[i][0] = scheduleStart.get(i);
			conferneceTimes[i][1] = scheduleEnd.get(i);
		}

		// Sort by compartor (start and end times) so that compariosn can be done
		Arrays.sort(conferneceTimes, (a, b) -> {
			if (a[1] != b[1])
				return a[1] - b[1];// end times
			else
				return a[0] - b[0];// start times
		});

		// Let the first small meeting be attended
		int endTime = conferneceTimes[0][1];

		// Default number of presentation can be attended is 1
		int maxPresentations = 1;

		// Iterate through every conference start and end
		for (int i = 0; i < conferneceTimes.length; i++) {
			if (conferneceTimes[i][0] >= endTime) {// If start time >end
				maxPresentations++;// increment presentations
				endTime = conferneceTimes[i][1];// reset the endTime

			}
		}
		return maxPresentations;
	}
}
