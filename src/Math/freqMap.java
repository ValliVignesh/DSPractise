package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

public class freqMap {

	@Test
	public void test1() {
		int n[] = { 5, 4, 5, 3, 2 };
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(5);
		numList.add(4);
		numList.add(5);
		numList.add(3);
		numList.add(2);
		int[] q = { 1, 2, 3, 4, 5 };
		List<Integer> index = new ArrayList<Integer>();
		index.add(1);
		index.add(2);
		index.add(3);
		index.add(4);
		index.add(5);
		Assert.assertTrue(Arrays.equals(new int[] { 2, 1, 1, 1, 1 }, findFreqMaxValue(numList, index)));
	}

	private int[] findFreqMaxValue(List<Integer> numList, List<Integer> index) {
		// TODO Auto-generated method stub
		int[] result=new int[index.size()];
		List<Integer> outList = new ArrayList<Integer>();
		List<Integer> resultList = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		for (int i = 0; i < numList.size(); i++) {
			map.put(numList.get(i), map.getOrDefault(numList.get(i), 0) + 1);
		}	

		for (int i = 0; i < index.size(); i++) {
			int left = index.get(i)-1;
			resultList.clear();
			while (left < numList.size()) {
				map1.put(numList.get(left), map1.getOrDefault(numList.get(left), 0) + 1);
				resultList.add(numList.get(left));
				left++;
			}

			outList.add(map1.get(Collections.max(resultList)));
			map1.clear();

		}
		System.out.println(outList);
		for(int i=0;i<outList.size();i++) {
			result[i]=outList.get(i);
		}
		return result;
	}
}
