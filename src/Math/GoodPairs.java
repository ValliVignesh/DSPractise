package Math;

import org.junit.Test;

public class GoodPairs {

	
	@Test
	public void test1() {
		int nums[]= {1,2,3,1,1,3};
	}
	@Test
	public void test2() {
		int nums[]= {1,2,3};
	}
	  public int numIdenticalPairs(int[] nums) {
	        int count=0;
	        for(int i=0;i<nums.length;i++){
	            for(int j=1;j<nums.length;j++){
	                if(nums[i]==nums[j] && i<j)
	                    count ++;
	            }
	        }
	        return count;
	    }
}
