package inProgress;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class Pb_1870_MinSpeedTrain {
	/**
	 * 
	 * Interview Questions-
	 * https://leetcode.com/discuss/interview-question/488887/Amazon-Final-Interview-Questions-or-SDE1
	 * https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
	 * https://www.youtube.com/watch?v=aYY3BzUaYU0
	 * Binary Search
	 */
	@Test
	public void test1() {
		int n[] = { 1, 3, 2 };
		double hr = 6;
		Assert.assertEquals(1, findMinSpeed(n, hr));
	}

	@Test
	public void test2() {
		int n[] = { 1, 3, 2 };
		double hr = 2.7;
		Assert.assertEquals(3, findMinSpeed(n, hr));
	}

	@Test
	public void test3() {
		int n[] = { 1, 3, 2 };
		double hr = 1.9;
		Assert.assertEquals(-1, findMinSpeed(n, hr));
	}

	/**
	 * Pseudo Code
	 * 
	 * find the max number in array try dividing the value with all the numbers
	 * round off to nearest value if the sum of rounded value is less than the
	 * expected return speed expected else return -1
	 * 
	 * @param n
	 * @param hr
	 * @return
	 */

	private int findMinSpeed(int[] n, double hr) {
		// TODO Auto-generated method stub
		  int n1 = n.length ;
	       
	        int ans=-1;
	        int min_sp = 1, max_sp = 10000000;
	        while(min_sp <= max_sp){
	            int mid = min_sp +(max_sp - min_sp)/2;
	            double h= 0;
	            for(int i=0;i<n1-1 ;i++){ // from index 0 to n-2 ,so that we can calculate the ceil value of time require when we are at a speed of mid.
	                h+=Math.ceil((double)n[i]/mid);
	            }
	            h+=((double)n[n1-1]/mid); // thats the last time require 
	            if(hr < h){min_sp = mid+1;}
	            else{ans = mid; max_sp = mid-1;}
	        }
	        // cout<<endl;
	        return ans;

	}
}
