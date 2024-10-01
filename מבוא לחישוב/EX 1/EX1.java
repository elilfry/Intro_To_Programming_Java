

public class EX1 {
	

		public static void main(String[] args) {
			
			//ex1.1 final number
			
			int num1 = MyConsole.readInt("enter a num");
			int sum = 0,x =0;
			 while (num1 > 0 || sum > 9)
		     {
		          if (num1 == 0) {
		             num1 = sum;
		             sum = 0;
		         }
		          
		         sum = sum + (num1 % 10);
		         num1 = (num1/10);
				
		     }
			 System.out.println("the final sum of the number is "+sum);
			//printing if number is happy ex1.2
				
			    int num2 = MyConsole.readInt("enter a num");
				int sum2 = 0,temp2 = num2;
				 while (num2 > 0 || sum > 9)
			     {
			          if (num2 == 0) {
			             num2 = sum2;
			             sum2 = 0;
			         }
			          
			         sum2 = sum2 + ((num2 % 10) * (num2%10));
			         num2 = (num2/10);
			     }
				 if (sum2 == 1) {
				 System.out.println("the number "+temp2+" is happy number"); }
				 else {
					 System.out.println("the number "+temp2+" is not happy number");
				 }
				//chack if number is pallinadrom ex.1.3

				    int num3 = MyConsole.readInt("enter a num");
					boolean bool = true;
				    String numStr = Integer.toString(num3); //changing the number to array
					int[] numInArr = new int[numStr.length()];
					for (int i = 0; i < numStr.length(); i++) {
						numInArr[i] = numStr.charAt(i);
					}
					int j = (numInArr.length) -1;
					for(int i=0; i < numInArr.length  ;i++)  {
				         if(numInArr[i] != numInArr[j]) {
				      	  bool = false;}
				          j = j-1;
				       }	
				     	 
				       if (bool == true) {
				      	 System.out.println("the number is palindrome");
				       }
				       else { 
				        	 System.out.println("the number is not palindrome");

				       }
	// Josephus Problem ex 1.4
				       int num4 = MyConsole.readInt("enter a num");
				       int temp3;
				        if (powerOfTwo(num4)) {
				        	System.out.println("the winner is number 1");  }
				        else { 
				        	temp3 = nearstPowerOfTwo(num4);
				        	System.out.print("the winner is number ");
				        	System.out.println((2*(num4-temp3))+1);
				        }
				        
		
		}		
		
	//Josephus Problem ex 1.4 function

		 public static boolean powerOfTwo(int n)
	  {
	      if(n==0) {
	      	return false; 
	      }
	      while(n != 1)
	      {
	         
	          if (n % 2 != 0 ) {
	          	return false; }
	          n =n/2;	
	      }
	      return true;
	  }
		 public static int nearstPowerOfTwo(int n) {
			int temp4 = 0;
			 for (int i = n;i >= 0;i--) {
				 if (powerOfTwo(i)) {
					 temp4 = i;
					 return temp4;
				 }
			 }
			 return temp4;
		 }
	} 


}
