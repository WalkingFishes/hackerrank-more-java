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
		int[] irr = new int[arr.size()];
		int size = irr.length;
		return result;
	}
    static int[] rotLeft(int[] a, int d) {
        int[] result = new int[a.length];
        // loop is executed number of times from d to end of array
        // copy source starting at d to destination starting at 0
        for (int i=0; i<a.length-d; i++) {
            result[i] = a[i+d];
        }
        // loop is executed number of times from start to d
        // copy source starting at 0 to destination starting at length-d
        for (int i=0; i<d; i++) {
            result[a.length-d+i] = a[i];
        }
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

        int[] nlist = new int[] {1, 2, 3, 4, 5};
        int[] rlist = Result.rotLeft(nlist, d);
        for (int i : rlist)
        	System.out.print(i + " ");
        scan.close();
    }
}