package basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class KDiffPairs {
//https://leetcode.com/problems/k-diff-pairs-in-an-array/
	// 47 passed
	// 52 passed - 15 mins

	@Test
	public void test1() {
		int n[] = { 1, 3, 1, 5, 4 };
		int k = 0;
		Assert.assertEquals(1, findPairs(n, k));
	}

	@Test
	public void test2() {
		int n[] = { 2, 9, 0, 8, 9, 6, 5, 9, 8, 1, 9, 6, 9, 2, 8, 8, 7, 5, 7, 8, 8, 3, 7, 4, 1, 1, 6, 2, 9, 9, 3, 9, 2,
				4, 6, 5, 6, 5, 1, 5, 9, 9, 8, 1, 4, 3, 2, 8, 5, 3, 5, 4, 5, 7, 0, 0, 7, 6, 4, 7, 2, 4, 9, 3, 6, 6, 5, 0,
				0, 0, 8, 9, 9, 6, 5, 4, 6, 2, 1, 3, 2, 5, 0, 1, 4, 2, 6, 9, 5, 4, 9, 6, 0, 8, 3, 8, 0, 0, 2, 1 };
		int k = 1;
		Assert.assertEquals(9, findPairsSet(n, k));
	}

	public int findPairs(int[] nums, int k) {//O(n) Space - O(n)
		int count = 0;
		if (k < 0)
			return 0;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		for (int n : map.keySet()) {
			if (k == 0) {
				if (map.get(n) >= 2)
					count++;
			} else if (map.containsKey(n + k))
				count++;

		}
		return count;
	}
	
	public int findPairsSet(int[] nums, int k) {//Need to chk
	       int count=0;
	         Set<Integer> set=new HashSet<Integer>();
	        
	        for(int i=0;i<nums.length;i++){
	            for(int j=0;j<nums.length;j++){
	            	if(j!=i) {
	                if(Math.abs(nums[i]-nums[j])==k)
	                {                  
	                    
	                    if(!(set.contains(nums[i]) && set.contains(nums[j]))){
	                        set.add(nums[i]);
	                    set.add(nums[j]);
	                        count++;
	                    
	                
	            }
	                }
	                }
	            }
	        }
	        return count;
	    }
}
