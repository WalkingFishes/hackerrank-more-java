import java.io.*;
import java.util.*;

public class Solution {

    static int sherlockAndAnagrams(String s) {
    	System.out.println(s);
    	/*
    	 * Create a list (array?) of all the sorted substrings
    	 * Iterate over the list and count number of matches minus 1 for matching itself
    	 * return total matches
    	 */
    	ArrayList<String> myList = new ArrayList<String>();
    	for (int i = s.length()-1; i >= 0; i--) {
    		for (int j = 0; (i+j) < s.length(); j++) {
    			char tempArray[] = s.substring(j, j+i+1).toCharArray();
    			Arrays.sort(tempArray);
//    			System.out.println("[" + j + ":" + (i+j) + "]: " + s.substring(j, j+i+1));
    			myList.add(new String(tempArray));
    		}
    	}
//    	System.out.println("myList:");
    	int matches=0;
    	int start=1;
    	for (String str : myList) {
    		matches += countOccurance(myList, str, start);
//    		System.out.println(str);
    		start++;
    	}
    	
    	return matches;
    }

    static int countOccurance(ArrayList<String> arr, String str, int start) {
    	int count=0;
    	for (int i = start; i < arr.size(); i++) {
//    		System.out.print(arr.get(i)+": ");
    		if (str.equals(arr.get(i))) {
//    			System.out.println("matches");
    			count++;
    		} else {
//    			System.out.println("doesn't match");
    		}
    	}
    	return count;
    }
    			

    public static void main(String[] args) throws FileNotFoundException {

    	File file = new File ("src/input.txt");
    	Scanner scanner = new Scanner(file);
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(result);
        }

        scanner.close();
    }
}