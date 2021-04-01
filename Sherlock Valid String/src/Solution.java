import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    /*
     * Determine if 1 or 0 characters can be removed from String s in order for
     * s to contain the same frequency of all characters
     * Return "YES" if so, otherwise return "NO"
     */
    static String isValid(String s) {
    	/*
    	 * Iterate through frequency count for each unique letter, as soon as
    	 * there is more than one difference in the counts, the string is not valid
    	 */
    	// Approach 1:
    	// Convert String to sorted Array
    	// Convert String to HashSet
    	// Iterate over HashSet, call Collections.frequency on the Array
    	ArrayList<String> myList = new ArrayList<String>(Arrays.asList(s.split("")));
    	HashSet<String> myHash = new HashSet<String>(myList);
    	
    	int firstFreq=0;
    	int firstCounter=0;
    	int secondFreq=0;
    	int secondCounter=0;

    	for (String ch : myHash) {
    	    int freq = Collections.frequency(myList, ch);
    	    if (firstFreq == 0 || firstFreq == freq) {
    	        firstFreq = freq;
    	        firstCounter++;
    	    } else if (secondFreq == 0 || secondFreq == freq){
    	        secondFreq = freq;
    	        secondCounter++;
    	    } else { // There are 3 frequencies, invalid
    	        return "NO";
    	    }
    	    if (firstCounter > 1 && secondCounter > 1) { // There is more than one char to delete, invalid
    	        return "NO";
    	    }
    	}
    	return "YES";
    	
    }

    public static void main(String[] args) throws FileNotFoundException {

    	File file = new File ("src/input.txt");
    	Scanner scan = new Scanner(file);
    	int N = scan.nextInt();
    	scan.nextLine();
    	
    	while (N-->0) {
    	    String s = scan.nextLine();
    	    System.out.println(s + ": " + isValid(s));
    	}

        scan.close();
    }
}