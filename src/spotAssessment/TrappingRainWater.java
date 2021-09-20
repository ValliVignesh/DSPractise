package spotAssessment;

import org.junit.Assert;
import org.junit.Test;

public class TrappingRainWater {
	/**
	 * https://leetcode.com/problems/trapping-rain-water/
	 */

	@Test
	public void test1() {
		int n[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		Assert.assertEquals(6, findTrappingWater(n));

	}

	/**
	 * If starting index value 0 ignore --> if left >left+1 retain left index else
	 * move left+1
	 * 
	 * if ending index value is greater than the previous value retain else ignore
	 * 
	 * 
	 * iterate from index left index based on above condition move the right pointer
	 * till u find the greater than left pointer
	 * 
	 * Check the index difference between left and right >=2 *
	 * 
	 * while --> if left==right --> find minimum value and difference of each value
	 *
	 * if left<right -->
	 * 
	 * if left>right --> right++
	 * 
	 * if right+1 < right find minimum value and difference of each value
	 * 
	 * move left = right
	 * 
	 * check if
	 * 
	 * @param n
	 * @return
	 */

	private int findTrappingWater(int[] n) {
		// TODO Auto-generated method stub
		 int l=0, r=n.length-1, rightmax=0, leftmax=0;
	        int water = 0;
	        while(l<=r)
	        {
	            if(leftmax<=rightmax)
	            {
	               if(n[l]>=leftmax)
	                   leftmax=n[l];
	                else
	                    water+=(leftmax - n[l]);
	                l++;
	            }
	            else
	            {
	                if(n[r]>=rightmax)
	                   rightmax=n[r];
	                else
	                    water+=(rightmax-n[r]);
	                r--;
	            }
	        }
	        return water;
	}
}
