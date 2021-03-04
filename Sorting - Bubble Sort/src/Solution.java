import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	static void countSwaps(int[] arr) {
		int swaps = 0;
		for (int i=0; i < arr.length; i++) {
			for (int j=0; j < arr.length-1; j++) {
				if (arr[j] > arr[j+1]) {
					swaps++;
					int hold = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = hold;
				}
			}
		}
		System.out.println("Array is sorted in " + swaps + " swaps.");
		System.out.println("First Element: " + arr[0]);
		System.out.println("Last Element: " + arr[arr.length-1]);
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("src/input.txt");
		Scanner scan = new Scanner(file);
		int N = scan.nextInt();
		scan.nextLine(); // clear buffer
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.print("Before: ");
		for (int el : arr) System.out.print(el + " ");
		System.out.println();
		countSwaps(arr);
		scan.close();
		

	}

}
