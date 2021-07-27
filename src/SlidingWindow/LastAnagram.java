package SlidingWindow;

import java.util.Arrays;

import org.junit.Test;

public class LastAnagram {
	@Test
	public void test1() {
		String s="";
				String target="";
	}
	
private String lastAnagram(String input, String target) {
		
		if(input.length() == 0) throw new RuntimeException("input string cannoto be empty");
		
		int[] asciiCounter = new int[128];
		int[] asciiCounterTarget = new int[128];
		String tempString = "";
		for (int i = 0; i < target.length(); i++) {
			asciiCounterTarget[target.charAt(i)]++;
		}
		
		int left = 0, right = 0;
		while(right<input.length()) {
			asciiCounter[input.charAt(right++)]++;
			if(right-left == target.length()) {
				if(Arrays.equals(asciiCounter, asciiCounterTarget)) {
					tempString = input.substring(left,right);
				}
				asciiCounter[input.charAt(left++)]--;
				
			}
		}
		
		return tempString;
	}
}
