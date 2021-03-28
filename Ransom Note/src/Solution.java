import java.io.*;
import java.util.*;

public class Solution {

    // Do all of the words in note exist in magazine

    /*
     * Implementation using HashMaps
     */
    static void checkMagazine(String[] magazine, String[] note) {
        /*
         * Put words from magazine into a HashMap with a count of number of occurrences
         * 
         * Iterate over note, if it exists in hashmap, decrement count and update entry
         * If it doesn't exist, display No
         */
        HashMap<String, Integer> magazineHash = new HashMap<String, Integer>(magazine.length);
        for (String word : magazine) {
            Integer count = magazineHash.get(word);
            if (count == null) {
                magazineHash.put(word, 1);
            } else {
                magazineHash.put(word, count+1);
                
            }
        }
        for (String word : note) {
            Integer count = magazineHash.get(word);
            if (count == null) {
                System.out.println("No");
                return;
            } else if (count == 1) {
                magazineHash.remove(word);
            } else {
                magazineHash.put(word, count-1);
            }
        }
        System.out.println("Yes");

    }

    /*
     * Implementation using Arrays and a List
     */
    static void checkMagazineList(String[] magazine, String[] note) {
        /*
         * Sort both arrays
         * Create a List(mutable) for magazine words
         * Iterate over note array, if it exists in magazine, delete it from magazine
         * since each word can be used only once
         * At any point a word doesn't exist, display No
         */
    	Arrays.sort(magazine);
    	Arrays.sort(note);
    	List<String> myList = new ArrayList<String>(Arrays.asList(magazine));
    	for (String word : note) {
    		if (!myList.contains(word)) {
    			System.out.println("No");
    			return;
    		}
    		myList.remove(word);
    	}
  		System.out.println("Yes");
//    	if (mySet.containsAll(Arrays.asList(note)))
//    		System.out.println("Yes");
//    	else
//    		System.out.println("No");
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
