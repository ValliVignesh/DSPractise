package Math;

import org.junit.Test;

import junit.framework.Assert;

public class gasStation {
//https://leetcode.com/problems/gas-station/

	@Test
	public void test1() {
		int gasStation[] = { 1, 2, 3, 4, 5 };
		int cost[] = { 3, 4, 5, 1, 2 };
		Assert.assertEquals(3, canCompleteCircuit(gasStation, cost));
	}

	@Test
	public void test2() {
		int gasStation[] = { 2, 3, 4 };
		int cost[] = { 3, 4, 3 };
		Assert.assertEquals(-1, canCompleteCircuit(gasStation, cost));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int totalGas = 0, totalCost = 0, startingStation = 0, currentFuel = 0;

		for (int i = 0; i < gas.length; i++) {
				totalGas += gas[i];
				totalCost += cost[i];

			currentFuel = currentFuel + gas[i] - cost[i];
			if (currentFuel < 0) {
				startingStation = i + 1;
				currentFuel = 0;
			}
		}

		return (totalGas < totalCost) ? -1 : startingStation;
	}
	
	public int canCompleteCircuit_Try(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) return 0;
        final int N = gas.length;
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) return -1;
        int tank = 0, start = 0;
        for (int i = 0; i < N; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }
}
