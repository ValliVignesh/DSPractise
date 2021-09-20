package paloaltonetworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

public class MaxSumArrayWithDigits {

	@Test
	public void test1() {
		int n[] = { 51, 17, 71, 42 };
		Assert.assertEquals(93, MaximumSum(n));

	}

	private int findMaxSumIfDigitsEqual(int[] n) { //BAbu
		// TODO Auto-generated method stub
// 51, 17, 71, 42 
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int exptSum = -1;
		for (int i = 0; i < n.length; i++) {
			int sum = isDigitSum(n[i]);
			if (map.containsKey(sum)) {
				exptSum = Math.max(exptSum, map.get(sum) + n[i]);
				if (map.get(sum) < n[i]) {
					map.put(sum, n[i]);
				}
			} else
				map.put(sum, n[i]);
		}
		return exptSum;
	}

	public int isDigitSum(int num) {
		int temp = num;
		int sum = 0;
		while (temp != 0) {
			sum += temp % 10;
			temp = temp / 10;
		}
		return sum;
	}

	private int findMaxSumIfDigitsEqualLint(int[] A) { //lint
		// write your code here
		if (A == null || A.length == 0) {
			return -1;
		}
		int len = A.length;
		int[] digitSum = new int[len];
		int res = -1;
		HashMap<Integer, List<Integer>> sum2list = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < len; i++) {
			int curnum = A[i];
			int curSum = 0;
			while (curnum != 0) {
				curSum += curnum % 10;
				curnum /= 10;
			}
			if (sum2list.containsKey(curSum)) {
				List<Integer> curId = sum2list.get(curSum);
				for (Integer j : curId) {
					int num = A[j];
					res = Math.max(res, num + A[i]);
				}
				sum2list.get(curSum).add(i);
			} else {
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i);
				sum2list.put(curSum, tmp);
			}
		}
		return res;
	}
	
	public int findMax (int[] num) { //Kishore
	     int[] values = new int[num.length];
	     for(int i = 0; i < num.length;i++) {
	         values[i] = addNums(num[i]);
	     }
	     int max = Integer.MIN_VALUE;
	     for(int i = 0; i<values.length-1; i++) {
	         for(int j = i+1; j < values.length; j++) {
	             if(values[i] == values[j]) {
	                 max = Math.max(max, num[i]+num[j]);
	             }
	         }
	     }
	     return max;
	     
	    }
	    public int addNums(int n) {
	        int retVal = 0;
	        while(n!=0){
	            retVal += n%10;
	            n /= 10;
	        }
	        return retVal;
	        
	    }
	    


    private int digitSum(int n) { //Priority Queue
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    
    private Map<Integer, Queue<Integer>> buildMapC(int[] A) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int n : A) {
        	 int sumOfDigits = 0;
             while (n > 0) {
            	 sumOfDigits += n % 10;
                 n /= 10;
             }
           
            map.putIfAbsent(sumOfDigits, new PriorityQueue<Integer>());
            Queue<Integer> q = map.get(sumOfDigits);
            q.offer(n);
            if (q.size() > 2) {
                q.poll();
            }
        }
        return map;
    }
    public int MaximumSum(int[] A) {
        int maxSum = -1;
        Map<Integer, Queue<Integer>> map = buildMap(A);
        for (Queue<Integer> q : map.values()) {
            if (q.size() < 2) {
                continue;
            }
            maxSum = Math.max(maxSum, q.poll() + q.poll());
        }
        return maxSum;
    }
    

    
    private Map<Integer, Queue<Integer>> buildMap(int[] A) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int n : A) {
            int digitSum = digitSum(n);
            map.putIfAbsent(digitSum, new PriorityQueue<Integer>());
            Queue<Integer> q = map.get(digitSum);
            q.offer(n);
            if (q.size() > 2) {
                q.poll();
            }
        }
        return map;
    }
//https://www.linkedin.com/jobs/collections/recommended/?currentJobId=2711508826&start=24

}