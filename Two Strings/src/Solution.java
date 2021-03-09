import java.io.*;
import java.util.*;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
//    	System.out.println(s1 + " " + s2 );
    	/*
    	 * Check if s1 and s2 share any substrings
    	 * 
    	 * One approach is to break down s2 into its substrings (in an array?) and
    	 * call String contains on s1
    	 */
    	/*
    	 * Need algorithm to break string into all its possible substrings 
    	 * N = s1.length
    	 * Combinations of indices, compare starting from the longest string
    	 * 		0:(N-0)
    	 * 		0:(N-1), 1:(N-0)
    	 * 		0:(N-2), 1:(N-1), 2:(N-0)
    	 * 		0:(N-3), 1:(N-2), 2:(N-1), 3:(N-0)
    	 * 		0:(N-4), 1:(N-3), 2:(N-2), 3:(N-1), 4:(N-0)
    	 *  	 :
    	 *  	 :
    	 *   	0:(N-N-1), 1:(N-N-2), ..., N-1:N-(N-N)
//    	 */
//    	for (int i = s2.length()-1; i >= 0; i--) {
//    		for (int j = 0; (i+j) < s2.length(); j++) {
//    			System.out.print("[" + j + ":" + (i+j) + "]: ");
//    			System.out.println(s2.substring(j, j+i+1) + " " + s1.contains(s2.substring(j, j+i+1)));
//    			if (s1.contains(s2.substring(j, j+i+1))) return "YES";
//    		}
//    	}
//    	return "NO";
    	/*
    	 * A better solution is to just boil the strings down into a set of unique characters and then check for overlap
    	 * This is much, much faster
    	 */
    	Set<String> set1 = new HashSet<String>(Arrays.asList(s1.split("")));
    	Set<String> set2 = new HashSet<String>(Arrays.asList(s2.split("")));
//    	for (String s : set1) System.out.println(s);
    	
    	Set<String> set3 = new HashSet<String>(set1);
    	set3.addAll(set2);
    	return set3.size() == set1.size() + set2.size() ? "NO" : "YES";
    		
    }



    public static void main(String[] args) throws FileNotFoundException {

    	File file = new File ("src/input03.txt");
    	Scanner scanner = new Scanner(file);
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
        }

        scanner.close();
    }
}