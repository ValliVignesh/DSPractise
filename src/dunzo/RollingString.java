package dunzo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class RollingString {

	@Test
	public void test1() {
		String s = "abc";
		List<String> op = new ArrayList<String>();
		op.add("0 0 L");
		op.add("2 2 L");
		op.add("0 2 R");
		Assert.assertEquals("acc", rollstring(s, op));
	}

	private String rollstring(String s, List<String> op) {
		String result = "";
		String[] operations = new String[op.size()];
		for (int i = 0; i < op.size(); i++) {
			operations[i] = op.get(i);
			System.out.println(operations[i]);
			char[] c = operations[i].toCharArray();
			if (c[1] != 0) {
				for (int j = c[0]; j <= c[1]; j++) {
					if (c[2] == 'L') {
						for (int k = 0; k < s.length(); k++) {
							int temp = (int) s.charAt(k) - 1;
							result += String.valueOf(temp);
							System.out.println(result);
						}
					}
					if (c[2] == 'R') {
						for (int k = 0; k < s.length(); k++) {
							int temp = (int) s.charAt(k) + 1;
							result += String.valueOf(temp);
							System.out.println(result);
						}
					}
				}
			}
		}

		return result;
	}

	private String rollString_Sindhu(String s, List<String> operations) {
		
		StringBuffer rollString=new StringBuffer(s); 
		for (int i = 0; i < operations.size(); i++) { 
			String str[]=operations.get(i).split("\\s+");   
			for (int j = Integer.parseInt(str[0]); j <=Integer.parseInt(str[1]); j++) {     
				if(str[2].equalsIgnoreCase("L")){               
					char temp=rollString.charAt(j);     
					if(temp=='a'){   
						temp='z';                     
						}
					else{    
							temp--;                     } 
					
					
					rollString.setCharAt(j, temp);                 }
				else{  
						char temp=rollString.charAt(j);                     
						if(temp=='z'){
							
							
		}
	          temp='a';  
	          }
				else{  
	        	  temp++;  
	        	  }
	          rollString.setCharAt(j, temp);  
	          }             }             //    }             System.out.println(rollString.toString());             return rollString.toString();

	}
}
