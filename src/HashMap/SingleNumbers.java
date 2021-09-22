package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import junit.framework.Assert;

public class SingleNumbers {

	
	//https://leetcode.com/problems/single-number/submissions/
	
	@Test
	public void test() {
		int[] n= {4,1,2,1,2};
		Assert.assertEquals(4, singleNumber(n));
		
	}
	
	public int singleNumber(int[] nums) {
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
         map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Entry<Integer, Integer> m: map.entrySet()){
            if(m.getValue()==1)
            {
             return m.getKey();   
            }
        }
        
        return 1;
    }
}
