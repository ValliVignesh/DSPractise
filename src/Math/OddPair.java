package Math;

import java.util.HashMap;

import org.junit.Test;

public class OddPair {

	@Test
	public void test1() {
		int[] n = { 1, 2,3,4 };

	}

	static boolean canPairs(int ar[], int k) {
		// An odd length array cannot be divided into pairs
		if (ar.length % 2 == 1)
			return false;

		// Create a frequency array to count occurrences
		// of all remainders when divided by k.
		HashMap<Integer, Integer> hm = new HashMap<>();

		// Count occurrences of all remainders
		for (int i = 0; i < ar.length; i++) {
			int rem = ((ar[i] % k) + k) % k;
			if (!hm.containsKey(rem)) {
				hm.put(rem, 0);
			}
			hm.put(rem, hm.get(rem) + 1);
		}
		return true;
	}	
	
	private boolean oddPair(int ar[],int k) {
		int odd = 0, even = 0;
		for (int i = 0; i < ar.length; i++) {
		    if (ar[i] % 2 == 0) {
		        even++;
		    } else {
		        odd++;
		    }
		}
		int answer = (odd * (odd - 1) + even * (even - 1)) / 2;
		return false;
	}
	
	 public static void countPairs(int [] input){

	       // System.out.println("Given Input: " + Arrays.toString(input));

	        int evenCount=0;
	        int oddCount=0;

	        for (int i = 0; i <input.length ; i++) {
	            if(input[i]%2==0)
	                evenCount++;
	            else
	                oddCount++;
	        }

	        int evenPairs = evenCount*oddCount;
	        System.out.println("Number of odd pairs: " + evenPairs);
	    }


}
