import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int maximumToys(int[] arr, int k) {
		// Simple brute force
		//		Sort array of prices, staring at lowest, add values until total > k
		//		Return number of items

		Arrays.sort(arr);
		System.out.print("Sorted: ");
		for (int el : arr) System.out.print(el + " ");
		int total = 0;
		int count=0;
		for (int i=0; i < arr.length; i++) {
			total += arr[i];
			if (total > k) break;
			count++;
		}
		System.out.println("\nk, total: " + k + ", " + total);
		return count;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("src/input.txt");
		Scanner scan = new Scanner(file);
		int N = scan.nextInt(); // number of priced toys
		int k = scan.nextInt(); // budget to spend on toys
		scan.nextLine(); // clear buffer
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.print("Before: ");
		for (int el : arr) System.out.print(el + " ");
		System.out.println();
		System.out.println(maximumToys(arr, k));

		scan.close();
		
	}
}
