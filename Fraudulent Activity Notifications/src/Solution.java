import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static double median(int[] values, int d) {
		/* Figure out median expenditure of d days
		 *		Start with 0-(d-1) items, add to Array, sort
		 *			If d is odd number, take element at index arr.length/2 (or d/2)
		 *			If d is even, take average of elements at indexes d/2 and d/2 + 1
		 */
		double median = 0;
		Arrays.sort(values);
//		System.out.print("Sorted: ");
//		for (int el : values) System.out.print(el + " ");
//		System.out.println();
		if (values.length % 2 != 0) {
//			System.out.println("val[" + d/2 + "]: " + values[d/2]);
			median = values[d/2];
		} else {
//			System.out.println("val[" + (d/2-1) + "]: " + values[d/2-1] + ", val[" + d/2 +  "]: " + values[d/2]);
			median = (values[d/2-1] + values[d/2])/2.0;
		}
//		System.out.println("Median: " + median);
		return median;
	}
	
	static int activityNotifications(int[] expenditure, int d) {
		int notif = 0;
		/* If element at d > = 2 * median, this would create a notification
		 * Continue down the array until the end
		 */
		int[] arr = new int[d];
		for (int i = 0; i < expenditure.length-d; i++ ) {
			arr = Arrays.copyOfRange(expenditure, i, i+d);
			if (expenditure[i+d] >= median(arr, d)*2) notif++;
		}
		return notif;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("src/input2.txt");
		Scanner scan = new Scanner(file);
		int D = scan.nextInt(); // Number of Days of transaction data
		int T = scan.nextInt(); // Number of Trailing days
		scan.nextLine(); // clear buffer
		int[] arr = new int[D];
		for (int i=0; i<D; i++) {
			arr[i] = scan.nextInt();
		}
//		System.out.print("Before: ");
//		for (int el : arr) System.out.print(el + " ");
//		System.out.println();
		System.out.println(activityNotifications(arr, T));

		scan.close();
		
	}
}
