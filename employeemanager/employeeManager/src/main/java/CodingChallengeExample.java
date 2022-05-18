import java.util.Arrays;

public class CodingChallengeExample {

	public static void main(String[] args) {
		String name = "Malayalam";
		boolean palindrome = isPalindromeExample(name);
		System.out.println(palindrome);
		fibnacciExample();
	}
    
	private static boolean isPalindromeExample(String name) {
		System.out.println("========Is Palindrome Example========");
		String output = null;
		StringBuffer sb = new StringBuffer();
		for(int i= name.length()-1; i>-1; --i) {
			sb.append(name.charAt(i));
		}

		output = sb.toString();
		return (name.equalsIgnoreCase(output));
	}
	
	private static void fibnacciExample() {
		System.out.println("========Fibnacci Example========");
		int[] array = new int[10];
		for(int i =0; i< array.length; ++i) {
			if(i<2) {
				array[i] = 1;
			} else {
				array[i] = array[i-2] + array[i-1];
			}
			System.out.println(array[i]);
		}
	}



}
