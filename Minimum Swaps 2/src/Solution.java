import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int minimumSwaps(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		int swaps = 0;
		// if value at i > value at i+1
		//		if i+1 is end of line, swap i and i+1
		// 		else if value at i+1 > i+2, swap i+2 and i
		//		go back to start of array
		// else increment i

		return swaps;
	}

	public static void main (String[] args) throws FileNotFoundException {
		File file = new File("src/input.txt");
		Scanner scan = new Scanner(file);
		int N = scan.nextInt();
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println(minimumSwaps(arr));
		scan.close();
	}

}
