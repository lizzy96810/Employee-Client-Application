
public class CodingChalleng {

	public static void main(String[] args) {
		fibinacci();
        String name = "Malayalam";
       boolean result = palindrome(name);
       System.out.println(result);
	}
	
	private static void fibinacci() {
		// 1,1,2,3,5,8,13
		
		int[] fib = new int [10];
		for(int i = 0; i < fib.length; ++i) {
			 if(i <2) {
				 fib[i] = 1;
			 }else { 
				fib [i] = fib[i-2] + fib[i-1];
			 }
			System.out.println(fib[i]);

		}
	}
	
	private static boolean palindrome(String name) {
		String palin = null;
		StringBuffer sb = new StringBuffer();
		 
		for(int i = name.length() -1; i>-1; --i) {
			sb.append(name.charAt(i));
			System.out.println(palin);
		}
		palin = sb.toString();
		System.out.println(palin);
		return name.equalsIgnoreCase(palin);
	}

}
