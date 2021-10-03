package string;

import org.junit.Test;

import junit.framework.Assert;

public class FinalValueOfVariable {
	@Test
	public void test1() {
		String[] s={"--X"};
		Assert.assertEquals(-1, finalValueAfterOperations(s));
	}
	
	 public int finalValueAfterOperations(String[] operations) {
	        
	        int X=0;
	        
	        for(String s:operations){
	            if(s.contains("--")){
	               X--;
	            }
	            if(s.contains("++")){
	                X++;
	            }
	        }
	       return X;
	        
	    }

}
