package spotAssessment;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

public class FizzBuzz {
	/**
	 * 412. Fizz Buzz Easy
	 * 
	 * 1509
	 * 
	 * 1690
	 * 
	 * Add to List
	 * 
	 * Share Given an integer n, return a string array answer (1-indexed) where:
	 * 
	 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5. answer[i] == "Fizz" if
	 * i is divisible by 3. answer[i] == "Buzz" if i is divisible by 5. answer[i] ==
	 * i if non of the above conditions are true.
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: n = 3 Output: ["1","2","Fizz"] Example 2:
	 * 
	 * Input: n = 5 Output: ["1","2","Fizz","4","Buzz"]
	 * 
	 * Input- int ouput - String[]
	 * 
	 * Using HashMap: 2 min
	 * 
	 * Put map with i and value if i is divisible by 5 and 3 put FizzBuzz if i is
	 * divisible by 3 put as Fizz if i is divisible by 5 put as FizzBUzz return Map
	 * values as String []
	 * 
	 * Using Two Pointers : 3 min
	 * 
	 * left=1 right=n till left==right store value in string[] as if n[left] or
	 * n[right]%3==0 and %5==0 store as Fizz Buzz else if n[left] or n[right]%3==0
	 * Fizz else if n[left] or n[right]%5==0 Buzz else store as i
	 */

	@Test
	public void test1() {
		int n = 3;
		System.out.println(Arrays.toString(fizzBuzz(n)));
		System.out.println(Arrays.toString(fizzBuzzTwoPointer(n)));
	}

	@Test
	public void test2() {
		int n = 15;
		System.out.println(Arrays.toString(fizzBuzz(n)));
		System.out.println(Arrays.toString(fizzBuzzTwoPointer(n)));
	}

	@Test
	public void test3() {
		int n = 5;
		System.out.println(Arrays.toString(fizzBuzz(n)));
		System.out.println(Arrays.toString(fizzBuzzTwoPointer(n)));
	}

	private String[] fizzBuzz(int n) { // 7 mins
		// TODO Auto-generated method stub
		// Using HashMap for i=1 to n
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 1; i <= n; i++) { //O(n)
			// Put map with i and value if i is divisible by 5
			// and 3 put FizzBuzz
			if (i % 3 == 0 && i % 5 == 0)
				map.put(i, "FizzBuzz");
			// if i is divisible by 3 put as Fizz
			else if (i % 3 == 0)
				map.put(i, "Fizz");
			// if i is divisible by 5 put as FizzBUzz
			else if (i % 5 == 0)
				map.put(i, "Buzz");
			else
				map.put(i, i + "");
		}
//return Map values as String []
		String[] str = new String[n];
		for (int i = 0; i <= n - 1; i++) { //O(n)
			str[i] = map.get(i + 1);
		}
		return str;
	}

	public String[] fizzBuzzTwoPointer(int n) { // 9 mins
		String[] str = new String[n];
		int left = 1;
		int right = n;
		while (left <= right) { //O(n/2)

			if (left % 3 == 0 && left % 5 == 0)
				str[left - 1] = "FizzBuzz";
			else if (left % 3 == 0)
				str[left - 1] = "Fizz";
			else if (left % 5 == 0)
				str[left - 1] = "Buzz";
			else
				str[left - 1] = left + "";

			if (right % 3 == 0 && right % 5 == 0)
				str[right - 1] = "FizzBuzz";
			else if (right % 3 == 0)
				str[right - 1] = "Fizz";
			else if (right % 5 == 0)
				str[right - 1] = "Buzz";
			else
				str[right - 1] = right + "";

			left++;
			right--;

		}
		return str;
	}
}
