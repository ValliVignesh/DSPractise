package assessment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class largestSubString {
	/**
	 * ref-https://www.geeksforgeeks.org/largest-lexicographical-string-with-at-most-k-consecutive-elements/
	 * https://leetcode.com/discuss/interview-question/724785/rearrange-original-string-and-delete-characters-java8#:~:text=Given%20a%20string%2C%20construct%20a,and%20deleting%20characters%20as%20needed.&text=The%20largest%20string%2C%20alphabetically%2C%20is,the%20answer%20is%20'ccbca'
	 */

	@Test
	public void test1() {
		String s = "baccc";
		int k = 2;
		Assert.assertEquals("ccbca", findLongString(s, k));

	}
	@Test
	public void test2() {
		String s = "zzzzza";
		int k = 2;
		System.out.println(findLongString(s, k));
		Assert.assertEquals("zzazz", findLongString(s, k));

	}
	@Test
	public void test3() {
		String s = "zzzzacccd";
		int k = 3;
		System.out.println(findLongString(s, k));
		Assert.assertEquals("zzzdzccca", findLongString(s, k));

	}

	private String findLongString(String s, int k) {
		 // Write your code here
	    StringBuilder sb = new StringBuilder();
	    char[] charr= s.toCharArray();
	    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	    for (char c : charr) {
	        map.put(c, map.getOrDefault(c,0)+1);
	    }
	    
	    Character[] keychars= new Character[map.keySet().size()];
	    map.keySet().toArray(keychars);
	    Arrays.sort(keychars); //n log n
	    int add=0;
	    for(int i=keychars.length-1;i>=0;i--){
	        add=0;
	        if(map.get(keychars[i])!=0){
	            
	            while(map.get(keychars[i])!=0){
	                if(add%k==0 && add!=0){
	                    int temp=1;
	                    while(i-temp>=0){
	                        if(map.get(keychars[i-temp])>0){
	                            sb.append(keychars[i-temp]);
	                            map.put(keychars[i-temp],map.get(keychars[i-temp])-1);
	                            break;
	                        }
	                        else{
	                            temp++;
	                        }
	                    }
	                    if(i-temp<0){
	                        map.put(keychars[i],0);
	                        break;
	                    }
	                }
	                sb.append(keychars[i]);
	                add++;
	                map.put(keychars[i],map.get(keychars[i])-1);
	            }
	        }
	    }    
	    return sb.toString();
	}
}
