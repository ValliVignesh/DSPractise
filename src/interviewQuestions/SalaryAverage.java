package interviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SalaryAverage {
	/**
	 * * Given list of Salaries find the average of the salary missing the
	 * highes(CEO)and lowest salary(Contractor) 2 decimal value Closest whole number
	 * with two decimals
	 * 
	 * int salaries[]={2000,10000,3000,7000,9000}
	 * 
	 * Salaries not equal
	 */

	@Test
	public void test1() {
		int[] salary = { 2000, 10000, 3000, 7000, 9000 };
		Assert.assertEquals(6333.33, findAvg(salary), 0.01);

	}
	// Using ArrayList - O(n logn)+ O(n)
	// Space complexity for Arrays.sort - O(n)+O(1)

	private double findAvg(int[] salary) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		float total = 0;
		

		for (int i = 0; i < salary.length; i++) { // O(n)
			min = Math.min(min, salary[i]);
			max = Math.max(max, salary[i]);
			total = total + salary[i];
		}
		System.out.println(total);
		total = total - (min + max);
		System.out.println(total);

		return total / (salary.length - 2); //O(1)
	}

}
