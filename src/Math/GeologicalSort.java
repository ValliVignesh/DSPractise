package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class GeologicalSort {
	@Test
	public void test1() {
		int[] v = { 7000, 13400, 7000, 14000 };
		int[] nv = { 7000, 13400, 15000, 7000 };
		List<Integer> vol = new ArrayList<Integer>();
		for (int i = 0; i < v.length; i++) {
			vol.add(v[i]);
		}
		List<Integer> nonVol = new ArrayList<Integer>();
		for (int i = 0; i < nv.length; i++) {
			nonVol.add(nv[i]);
		}
		System.out.println(sortIntersect(vol, nonVol));
	}

	public List<Integer> sortIntersect(List<Integer> v, List<Integer> nv) {
		List<Integer> sorted = new ArrayList<Integer>();	
		Map<Integer,Integer> vMap=new HashMap<Integer,Integer>();
		Map<Integer,Integer> nVMap=new HashMap<Integer,Integer>();
		for (int i = 0; i < v.size(); i++) {
			vMap.put(v.get(i),vMap.getOrDefault(v.get(i),0)+1);
		}
		for(int i=0;i<nv.size();i++) {
			if(vMap.containsKey(nv.get(i))) {
				if(vMap.get(nv.get(i))>1) {
					vMap.put(nv.get(i), vMap.get(nv.get(i))-1);					
				}else {
					vMap.remove(nv.get(i));
				}
				sorted.add(nv.get(i));
			}
		}
		Collections.sort(sorted);
		Collections.reverse(sorted);
		return sorted;
	}
}
