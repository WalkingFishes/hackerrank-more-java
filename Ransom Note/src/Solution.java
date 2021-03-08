import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
//    	System.out.println("Magazine:");
//    	for (String word : magazine) System.out.print(word + " ");
//    	System.out.println();
//    	System.out.println("Note:");
    	List<String> myList = new ArrayList<>(Arrays.asList(magazine));

    	for (String word : note) {
    		if (!myList.contains(word)) {
    			System.out.println("No");
    			return;
    		}
    		myList.remove(word);
//    		System.out.print(word + "(" + list.contains(word) + ") ");
    	}
//    	System.out.println();
    	System.out.println("Yes");

    }

    public static void main(String[] args) throws FileNotFoundException {
    	File file = new File("src/input.txt");

    	Scanner scanner = new Scanner(file);
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
