import java.util.Arrays;

public class ArraysCodeChallenge {

	public static void main(String[] args) {
		smallestArray();

	}
	
	private static void smallestArray() {
		int[] findSmallest = {2,1,4,7,8,99,234};
		Arrays.sort(findSmallest);
		
		// int biggest = findSmallest.length-1;
		//// int biggestInt =findSmallest[biggest];
		 //System.out.println(biggestInt);
		System.out.println("Smallest Value is " + findSmallest[0] );
		System.out.println("Highest Value is " + findSmallest[findSmallest.length-1]);

	}

}
