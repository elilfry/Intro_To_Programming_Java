
import java.util.ArrayList;

public class Ex3 {

	public static String[] dictionary(String s) {
		
		String t = s.toLowerCase(); //to lower cases
		String [] ans = sentence(t); // split the string to string array
		
		
		for(int i =0;i<ans.length;i++) { //sort the string array
			for(int j =i+1; j<ans.length;j++) {
				if (ans[i].compareTo(ans[j])>0){
					String temp = ans[i];
					ans[i] =ans[j];
					ans[j] = temp;
				}
			}
		}
		
		ArrayList <String> temp2 = new ArrayList<String>(); //remove duplicate words
		for (int i=0;i<ans.length;i++) {
			if (!temp2.contains(ans[i])) {
				temp2.add(ans[i]);
			}
		}
		ans = temp2.toArray(new String[temp2.size()]); //ArrayList to String Array
		
		return ans;
	}
	
	
	public static String[] sentence(String s) {
	     
	       ArrayList <String> temp1 = new ArrayList<String>(); //ArrayList
	       int arrIndex =0,cnt =0;
	       String c = "";
	       
	       temp1.add("");

	       for (int i = 0; i <s.length(); i++) {
	    	   if (s.charAt(i) != ' ' && s.charAt(i) != '.' && s.charAt(i) != ',') {
			cnt =cnt +1;
			c = temp1.get(arrIndex) + s.charAt(i);
		   temp1.set(arrIndex,c);
			

	    	   }
	    	   else if (cnt != 0) {
	    		   temp1.add("");
	    		   arrIndex = arrIndex+1;
	    		   cnt = 0;
	    		   
	    	   }
	    	  
		}
	      
	       String [] x = temp1.toArray(new String[temp1.size()]); //ArrayList to String Array
	       return x;
		
	}
}
