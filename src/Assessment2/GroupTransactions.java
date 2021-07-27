package Assessment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class GroupTransactions {
	@Test
	public void test1() {
		List<String> dict = new ArrayList<String>();
		dict.add("notebook");
		dict.add("notebook");
		dict.add("mouse");
		dict.add("keyboard");
		dict.add("mouse");
		System.out.println(findTrans(dict));
	}

	private List<String> findTrans(List<String> dict) {
		// TODO Auto-generated method stub
		if(dict.size()==0) throw new RuntimeException("Invalid"
				+ "data");
		Map<String,Integer> map = new HashMap<String,Integer>();
		ArrayList<String> output=new ArrayList<String>();
		
		for(String s:dict) {
			map.put(s,map.getOrDefault(s, 0)+1);
		}
		
		for(Map.Entry<String, Integer> newEntry :map.entrySet()) {
			output.add(newEntry.getKey()+" "+ newEntry.getValue());
		}
		
		Collections.sort(output);
		System.out.println(output);
		return output;
	}
	

}
