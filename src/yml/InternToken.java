package yml;

import org.junit.Test;

import junit.framework.Assert;

public class InternToken {

	
	@Test
	public void test1() {
		int n=2;
		int reg=5000;
		Assert.assertEquals(1, findIntern(n,reg));
	}
	
	@Test
	public void test2() {
		int n=10;
		int reg=25003;
		Assert.assertEquals(3, findIntern(n,reg));
	}
	@Test
	public void test3() {
		int n=1;
		int reg=5000;
		Assert.assertEquals(49, findIntern(n,reg));
	}

	private int getToken(int n, int reg) {
		// TODO Auto-generated method stub
		for(int i=0;i<49;i++) {
			
		}
		if(n<=1) return 0;
		
		int label=reg+n+getToken(n-1,reg);
		
		return label;
	}
	private int findIntern(int n, int p) {
		int rem = p%5000;
		p -= rem;
		for(int i = 1; i < rem; i++)
			p -= 5000;
		return p/5000;
	}
}
