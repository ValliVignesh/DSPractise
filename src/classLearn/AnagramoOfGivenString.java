package classLearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AnagramoOfGivenString {
	/**
	 * Given String name="valli" String k="al";
	 * 
	 * Find the anagram of the given string k in the name string
	 */
	@Test
	public void test1() {
		String name = "Valli";
		String k = "al";
		System.out.println(findAnagramIndexOptimised(name, k));
	}

	@Test
	public void test2() {
		String name = "Valli";
		String k = "alllll";
		System.out.println(findAnagramIndexOptimised(name, k));
	}

	public List<Integer> findAnagramIndex(String name, String k) {
		int[] kAscii = new int[128];

		List<Integer> retList = new ArrayList<>();
		if (k.length() > name.length()) {
			retList.add(-1);
			return retList;
		}
		for (char c : k.toCharArray()) {
			kAscii[c]++;
		}
		for (int i = 0; i < name.length() - k.length(); i++) {
			int[] inputAscii = new int[128];
			for (int j = i; j < i + k.length(); j++) {
				inputAscii[name.charAt(j)]++;
			}
			if (Arrays.equals(kAscii, inputAscii))
				retList.add(i);
		}
		return retList;
	}
	
	public List<Integer> findAnagramIndexOptimised(String name, String k) {
		int[] kAscii = new int[26];

		List<Integer> retList = new ArrayList<>();
		if (k.length() > name.length()) {
			retList.add(-1);
			return retList;
		}
		for (char c : k.toCharArray()) {
			kAscii[c-'a']++;
		}
		int left=0,right=k.length()-1;
		int[] inputAscii=new int[26];
		for(int i=0;i<k.length();i++) {
			inputAscii[name.charAt(i)-'a']++;
		}
		if(Arrays.equals(kAscii, inputAscii)) retList.add(0);
		//right=k.length();
		while(left<name.length()-k.length()) {
			inputAscii[name.charAt(left-'a')]--;
			inputAscii[name.charAt(right-'a')]++;
			left++;
			right++;
			if(Arrays.equals(kAscii, inputAscii)) retList.add(left);
		}
		return retList;
	}
}
