package interviewQuestions;

import org.junit.Test;

import junit.framework.Assert;

public class SqrtOfGiveNumber {

	/**
	 * Given a positive integer find the square root of the given number
	 * 
	 * 
	 */
	@Test
	public void test1() {
		int n = 4;
		Assert.assertEquals(2.0, findSqrt(n));
	}
	@Test
	public void test2() {
		int n = 19;
		Assert.assertEquals(4.358, findSqrt(n),0.001);
	}

	private double findSqrt(int n) {
		// TODO Auto-generated method stub
		
		double sqrt= n/2;
		double t;
		do{
			t=sqrt;
			sqrt=(t+(n/t))/2;
			t=t-sqrt;
		}while(t!=0);  //O(n)
		
		return sqrt;
	}
}
