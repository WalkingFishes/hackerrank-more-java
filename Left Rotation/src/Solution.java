import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Result {
	public static List<Integer> rotateLeft(int d, List<Integer> arr) {
		// Get 2 sublists, from d to end of list and start of list to d
		// add both to 2 list
		List<Integer> result = new ArrayList<Integer>();
		result.addAll(arr.subList(d, arr.size()));
		result.addAll(arr.subList(0, d));
		return result;
	}
}

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
    	File file = new File("src/input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        // Rotate amount
        int d = scan.nextInt();
        List<Integer> arr = new ArrayList<Integer>();
        while (n-->0) {
        	arr.add(scan.nextInt());
        }
        List<Integer> result = Result.rotateLeft(d, arr);
        System.out.println(result);
        scan.close();
    }
}