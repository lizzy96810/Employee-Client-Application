import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CodingChallengPrep {

	public static void main(String[] args) {
		fibbanci();
		String name="Malayalam";
		boolean test = isPalindrome(name);
		System.out.println(test);
        //Example of arrayList
		List<Integer> listOfNames =  names();
		System.out.println(listOfNames.toString());
		  int k = 12;
		   do {
			   k ++;
			   System.out.println(k);
		   } while (k<18);
		    
		   int m = 15;
		     while(m<24) {
		    	 m ++;
		    	 System.out.println(m);
		     }
		    String day = "Monday";
			   switch(day) {
			   case "Monday":
			      System.out.println("Today is Monday");
			      break;
			   case "Tuesday":
				      System.out.println("Today is Tuesday");
				      break;
			   case "Wednesday":
				      System.out.println("Today is Wednesday");
				      break;
			   case "Thursday":
				      System.out.println("Today is Thursday");
				      break;
			   case "Friday":
				      System.out.println("Today is Friday");
				      break;
			   case "Saturday":
				      System.out.println("Today is Saturday");
				      break;
			   case "Sunday":
				      System.out.println("Today is Sunday");
				      break;
			   }
	}
	 
	    
	
	private static void fibbanci() {
		int[] fib = new int[10];
		for(int i = 0; i< fib.length; ++ i) {
			if(i <2) {
				fib[i] = 1;
			} else {
				fib [i] = fib[i-2] + fib [i-1];
			}
			System.out.println(fib[i]);
		}
	}
	
	private static boolean isPalindrome (String name) {
		StringBuffer sb = new StringBuffer();
		for(int i = name.length()-1 ; i>-1; --i) {
			sb.append(name.charAt(i));
		}
		String result = sb.toString();
		boolean answer = name.equalsIgnoreCase(result);
		return answer;
	}
	
    private static List<Integer> names () {
    	List<Integer> numbers = new ArrayList<Integer>();
    	numbers.add(5);
    	numbers.add(4);
    	numbers.add(3);
    	numbers.add(5);
    	numbers.add(5);
    	Set<Integer> setNumbers = new HashSet<Integer>();
    	for(int i:numbers) {
    		setNumbers.add(i);
    	}
    	numbers.clear();
    	numbers.addAll(setNumbers);
    	return numbers;
    }
    
  
}
