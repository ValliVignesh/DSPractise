package assessment5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class FindDuplicate {
@Test
public void test1() {
	List<String> name = new ArrayList<String>();
	List<Integer> price = new ArrayList<Integer>();
	List<Integer> weight = new ArrayList<Integer>();
	name.add("ball");
	price.add(2);
	weight.add(4);
	name.add("bat");
	price.add(2);
	weight.add(4);
	name.add("ball");
	price.add(1);
	weight.add(4);
	name.add("glove");
	price.add(2);
	weight.add(3);
	name.add("ball");
	price.add(2);
	weight.add(4);
	

}
public static int numDup(List<String> name,List<String> price,List<String> weight) {
	int count=0;
	HashSet<String> unique=new HashSet<String>();
	for(int i=0;i<name.size();i++) {
		if(unique.add(name.get(i)+"-"+price.get(i)+"-"+weight.get(i))) {
			count++;
		}
	}
	return name.size()-count;
}
}
