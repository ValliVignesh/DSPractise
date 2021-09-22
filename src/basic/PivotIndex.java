package basic;

public class PivotIndex {
	
	//https://leetcode.com/problems/find-pivot-index/
	 public int pivotIndex(int[] nums) {
	     int left = 0, right = 0; 
	        for (int i = 0; i < nums.length; i++) { 
	            right += nums[i];
	        }
	        for (int index = 0; index < nums.length; index++) { 
	            if (left == right - nums[index]) { 
	                return index; 
	            } else {
	                left += nums[index]; 
	                right -= nums[index]; 
	            }
	        }
	        return -1;
	    }
}
