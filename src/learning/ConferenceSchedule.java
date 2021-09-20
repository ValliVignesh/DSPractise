package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ConferenceSchedule {
	

		@Test
		public void example() {
			List<Integer> scheduleStart = new ArrayList<>(Arrays.asList(1, 1, 2));
			List<Integer> scheduleEnd = new ArrayList<>(Arrays.asList( 3, 2, 4));

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

			int pnt = 0;
			int sind = pnt + 1;
			int eind = pnt;
			int max = scheduleEnd.get(eind);
			int maxpres = 0;
			int cnt = 1;
			boolean eqflag = false;

			while (pnt < scheduleStart.size() - 1 && (scheduleStart.size() - pnt - 1) >= maxpres) {

				if (sind == scheduleStart.size()) {
					maxpres = Math.max(maxpres, cnt);
					pnt++;
					sind = pnt + 1;
					eind = sind - 1;
					max = scheduleEnd.get(eind);
					cnt = 1;
					eqflag = false;
					continue;
				} else if (scheduleStart.get(sind) > max) {
					cnt++;
					eind = sind;
					max = scheduleEnd.get(eind);
					eqflag = false;

				} else if (scheduleStart.get(sind) == max && !eqflag) {
					cnt++;
					eind = sind;
					if (scheduleEnd.get(eind) == max)
						eqflag = true;
					else
						max = scheduleEnd.get(eind);
				} else {
					sind++;
				}
			}

			return maxpres;

		}
}
