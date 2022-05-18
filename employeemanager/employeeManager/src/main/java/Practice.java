

public class Practice {

	public static void main(String[] args) {
		fibinacci();
		String name = "Malayalam";
		boolean test = isPalindrome("Malayalam");
		System.out.println(test);

	}
    
	private static void fibinacci() {
		int[] fib = new int[10];
		for(int i = 0; i< fib.length; ++i) {
			if(i<2) {
				fib[i] = 1;
			} else {
				fib [i] = fib[i-2] + fib[i-1];
			}
			System.out.println(fib[i]);
		}
	}
	
	private static boolean isPalindrome(String name) {
		String palin = null;
		StringBuffer sb = new StringBuffer();
		for(int i = name.length()-1; i>-1; --i) {
			sb.append(name.charAt(i));
		}
		palin = sb.toString();
		boolean result = name.equalsIgnoreCase(palin);
		return result;
	}
}


