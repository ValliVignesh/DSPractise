package assessment4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ProgrammingContest {
	/**
	 * Input int[] Output - int
	 * 
	 */
	@Test
	public void test1() {
		int[] n = { 4, 2, 5, 1 };// --2,1 1,3> //count 1
		Assert.assertEquals(2, findMin(n));
	}

	/**
	 * Sorted the array ---> ascending Order 1,2,4,5 found the difference of i+1 and
	 * i iterated till the end stored the diff in count and returned
	 * 
	 * @param n
	 * @return
	 */

	private int findMin(int[] n) {
		// TODO Auto-generated method stub
		Arrays.sort(n);
		int count = 0;
		for (int i = 0; i < n.length; i++) {
			count += n[i + 1] - n[i];
		}
		return count;
	}

	// Babus
	public int minimizeBias(List<Integer> ratings) {
		Collections.sort(ratings);
		int sum = 0;
		for (int i = 0; i < ratings.size() - 1; i += 2)
			sum += ratings.get(i + 1) - ratings.get(i);
		return sum;
	}

}
