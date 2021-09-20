package classLearn;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class TruckToysBox {
	/**
	 * You are assigned to put some amount of boxes onto one truck. You are given a
	 * 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi,
	 * numberOfUnitsPerBoxi]:
	 * 
	 * numberOfBoxesi is the number of boxes of type i. numberOfUnitsPerBoxi is the
	 * number of units in each box of the type i. You are also given an integer
	 * truckSize, which is the maximum number of boxes that can be put on the truck.
	 * You can choose any boxes to put on the truck as long as the number of boxes
	 * does not exceed truckSize.
	 * 
	 * Return the maximum total number of units that can be put on the truck.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4 Output: 8 Explanation:
	 * There are: - 1 box of the first type that contains 3 units. - 2 boxes of the
	 * second type that contain 2 units each. - 3 boxes of the third type that
	 * contain 1 unit each. You can take all the boxes of the first and second
	 * types, and one box of the third type. The total number of units will be = (1
	 * * 3) + (2 * 2) + (1 * 1) = 8. Example 2:
	 * 
	 * Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10 Output: 91
	 * 5+3+2=10 50+27+14
	 * 
	 * Input-int[][],int Output-int
	 * 
	 * Test data:
	 * 
	 */
	@Test
	public void test1() {
		int[][] boxTypes = { { 1, 3 }, { 2, 2 }, { 3, 1 } };
		int truckSize = 4;
		Assert.assertEquals(8, findTruckCapacity(boxTypes, truckSize));
	}

	@Test
	public void test2() {
		int[][] boxTypes = { { 1, 3 }, { 2, 2 }, { 3, 4 } };
		int truckSize = 1;
		Assert.assertEquals(0, findTruckCapacity(boxTypes, truckSize));
	}

	@Test
	public void test3() {
		int[][] boxTypes = { { 1, 3 }, { 2, 2 }, { 3, 2 } };
		int truckSize = 1;
	}

	/*
	 * PseudoCode:
	 * 
	 * Iterate through each element and find the second index max value try to get
	 * all the boxes of that a)and chk if it less than truck size if so move to next
	 * max -->now chk if the diff b2n count and truck size is same or greater than
	 * item count if so add all from second max -->else add only remaning count of
	 * that item b)else return count if no unit value matches the truck size return
	 * count as 0
	 * 
	 * 
	 * Sorting the values based on b then proceed with the above logic the second
	 * max will be the second value
	 */

	private int findTruckCapacity(int[][] boxTypes, int truckSize) {
		// TODO Auto-generated method stub
		int sizeCount = 0;
		int totalCount = 0;

		Arrays.sort(boxTypes, (a, b) -> {
			if (a[1] != b[1])
				return a[1] - b[1];
			else
				return a[0] - b[0];
		});
		int diff = truckSize - sizeCount;
		for (int i = 0; i < boxTypes.length; i++) {
			for (int j = 0; j < boxTypes[0].length; j = j + 2) {
				// System.out.println(boxTypes[i][j]);
				if (sizeCount <= truckSize) {
					if (diff > boxTypes[i][j]) {
						sizeCount += boxTypes[i][j] * boxTypes[i][1];
						totalCount += boxTypes[i][j];
					} else {
						sizeCount += diff * boxTypes[i][1];
						totalCount += diff;
					}
					diff = truckSize - sizeCount;
				} else {
					continue;
				}

			}

		}
		return totalCount;
	}
}
