package basic;

import org.junit.Test;

import junit.framework.Assert;

public class ExcelColumnNumber {
	/**
	 * https://leetcode.com/problems/excel-sheet-column-number
	 */
	
	@Test
	public void test1() {
		String str="AB";
		Assert.assertEquals(28, titleToNumber(str));
	}
	
	 public int titleToNumber(String columnTitle) {
	       int sum=0;
	        for(Character c:columnTitle.toCharArray()){
	            sum=sum*26+(c-65+1);
	        }
	        return sum;
	    }
}
