package assessment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class DamDesign {

	/**
	 * Your company is designing a dam to be built across a stream to create a small
	 * lake. To reduce materials cost, it will be made of one or more concrete walls
	 * with mud packed in between them. Determine the maximum height of the mud
	 * segments in the dam with the following restrictions:
	 * 
	 * One unit width of the gap between walls will contain one segment of packed
	 * mud The height of mud in a segment cannot exceed 1 unit more than an adjacent
	 * wall or mud segment.
	 * 
	 * Given the placement of a number of walls and their heights, determine the
	 * maximum height of a mud segment that can be built. If no mud segment can be
	 * built, return 0.
	 * 
	 * Example wallPositions = [1, 2, 4, 7] wallHeights = [4, 6, 8, 11]
	 *4,5,6,9,10,11,12,13,14
	 *20,22,11,14,14,21,19,14,23
	 */
	@Test
	public void test1() {
		List<Integer> wallPositions = new ArrayList<Integer>();
		List<Integer> wallHeights = new ArrayList<Integer>();
		wallPositions.add(1);
		wallPositions.add(2);
		wallPositions.add(4);
		wallPositions.add(7);

		wallHeights.add(4);
		wallHeights.add(6);
		wallHeights.add(8);
		wallHeights.add(11);
		Assert.assertEquals(10, findMaxHeight_Haja(wallPositions, wallHeights));

	}
	//4,5,6,9,10,11,12,13,14
	 //20,22,11,14,14,21,19,14,23
	@Test
	public void test3() {
		List<Integer> wallPositions = new ArrayList<Integer>();
		List<Integer> wallHeights = new ArrayList<Integer>();
		wallPositions.add(4);
		wallPositions.add(5);
		wallPositions.add(6);
		wallPositions.add(6);
		wallPositions.add(9);
		wallPositions.add(10);
		wallPositions.add(11);
		wallPositions.add(12);
		wallPositions.add(13);
		wallPositions.add(14);

		wallHeights.add(20);
		wallHeights.add(22);
		wallHeights.add(11);
		wallHeights.add(14);
		wallHeights.add(14);
		wallHeights.add(21);
		wallHeights.add(19);
		wallHeights.add(14);
		wallHeights.add(23);
		Assert.assertEquals(10, findMaxHeight_Haja(wallPositions, wallHeights));

	}

	@Test
	public void test2() {
		List<Integer> wallPositions = new ArrayList<Integer>();
		List<Integer> wallHeights = new ArrayList<Integer>();
		wallPositions.add(1);
		wallPositions.add(10);
		wallHeights.add(1);
		wallHeights.add(5);

		Assert.assertEquals(7, findMaxHeight_Haja(wallPositions, wallHeights));

	}

	private int findMaxHeight(List<Integer> wallPositions, List<Integer> wallHeights) {

		int maxHeight = 0;
		int currentHeight = 0;
		int[] heightDifference = new int[wallPositions.size() - 1];
		int[] gapDifference = new int[wallPositions.size() - 1];

		for (int i = 1; i < wallHeights.size() - 1; i++) {
			heightDifference[i] = wallHeights.get(i + 1) - wallHeights.get(i);
			gapDifference[i] = wallPositions.get(i + 1) - wallPositions.get(i);
		}
		for (int i = 1; i < heightDifference.length - 1; i++) {
			if (gapDifference[i] <= heightDifference[i]) {
				currentHeight = heightDifference[i] - gapDifference[i] - 1;
				maxHeight = Math.max(maxHeight, currentHeight);
			} else {

			}
		}

		return maxHeight;
		// TODO Auto-generated method stub

	}

//Need to check
	private int findMudWall(List<Integer> wallPositions, List<Integer> wallHeights) {
		int n = wallPositions.size();
		int maximumheight = 0;
		for (int i = 0; i < n - 1; i++) {
			int diff = Math.abs(wallHeights.get(i + 1) - wallHeights.get(i));
			int gap = wallPositions.get(i + 1) - wallPositions.get(i) - 1;
			int max = 0;
			if (gap > diff) {
				int low = Math.max(wallHeights.get(i + 1), wallHeights.get(i) + 1);
				int length = gap - diff - 1;
				max = low + length / 2;
			} else {
				max = Math.min(wallHeights.get(i + 1), wallHeights.get(i)) + gap;
			}
			maximumheight = Math.max(maximumheight, max);
		}

		return maximumheight;
	}

	private int findMaxHeight_Haja(List<Integer> wallPositions, List<Integer> wallHeights) {
		int n = wallPositions.size();
		int result = 0;
		for (int i = 0; i < n - 1; i++) {
			int hDiff = Math.abs((wallHeights.get(i + 1) - wallHeights.get(i)));
			int gapLen = wallPositions.get(i + 1) - wallPositions.get(i) - 1;
			int localMax = 0;
			if (gapLen > hDiff) {
				int low = Math.max(wallHeights.get(i + 1), wallHeights.get(i)) + 1;
				int remGap = gapLen - hDiff - 1;
				localMax = low + remGap / 2;
			} else {
				localMax = Math.min(wallHeights.get(i + 1), wallHeights.get(i)) + gapLen;
			}
			result = Math.max(result, localMax);
		}
		return result;

	}
}
