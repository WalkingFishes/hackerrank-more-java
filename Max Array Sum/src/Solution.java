
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	public static int maxSubsetSum(int[] arr) {
		if (arr.length == 0) return 0;
		arr[0] = Math.max(0, arr[0]);
		if (arr.length == 1) return arr[0];
		arr[1] = Math.max(arr[0], arr[1]);
		for (int i = 2; i < arr.length; i++)
		  arr[i] = Math.max(arr[i-1], arr[i]+arr[i-2]);
		return arr[arr.length-1];
	}
	  
	public static void main (String[] args) throws FileNotFoundException {
		File file = new File("src/input.txt");
		Scanner scan = new Scanner(file);
		int N = scan.nextInt();
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = scan.nextInt();
		}
		int[] arr2 = new int[] {-1, 7, 4, 6, 5};
		System.out.println(maxSubsetSum(arr));
		scan.close();
	}

}