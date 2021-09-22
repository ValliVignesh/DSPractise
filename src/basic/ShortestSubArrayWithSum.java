package basic;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

import junit.framework.Assert;

public class ShortestSubArrayWithSum {

	@Test
	public void test1() {
		int n[]= {77,19,35,10,-14};
		int k=19;
		Assert.assertEquals(1, shortestSubarray(n,k));
	}
	   public int shortestSubarray(int[] ar, int k) {
		      int sum=0;
		        int n = ar.length;        
		        int min = Integer.MAX_VALUE;
		        
		        int[] p = new int[n+1];
		        for(int i=0;i<n;i++){
		            p[i+1]=ar[i]+p[i];
		        }
		        // System.out.println(Arrays.toString(p));
		        
		        
		        Deque<Integer> dq = new LinkedList<>();
		        for(int i =0;i<=n;i++){
		            while(dq.size()>0&&p[i]-p[dq.getFirst()]>=k){                
		                int idx = dq.pollFirst();
		                min=Math.min(i-idx,min);
		            }
		            while(dq.size()>0&&p[i]<=p[dq.getLast()]){
		                dq.pollLast();
		            }
		            dq.add(i);           
		            // System.out.println("i="+i+" dq="+dq);
		        }
		        return (min==Integer.MAX_VALUE)? -1 : min;
		    }
	   
}
