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
     * s to contain the same freqValueuency of all characters
     * Return "YES" if so, otherwise return "NO"
     */
    static String isValid(String s) {
    	/*
    	 * Iterate through freqValueuency count for each unique letter, as soon as
    	 * there is more than one difference in the counts, the string is not valid
    	 */
    	// Approach 1:
    	// Convert String to sorted Array
    	// Convert String to HashSet
    	// Iterate over HashSet, call Collections.freqValueuency on the Array
    	ArrayList<String> myList = new ArrayList<String>(Arrays.asList(s.split("")));
    	HashSet<String> myHash = new HashSet<String>(myList);
    	
    	int firstFreqValue=0;
    	int firstCounter=0;
    	int secondFreqValue=0;
    	int secondCounter=0;

    	for (String ch : myHash) {
    	    int freqValue = Collections.frequency(myList, ch);
    	    if (firstFreqValue == 0 || firstFreqValue == freqValue) {
    	        firstFreqValue = freqValue;
    	        firstCounter++;
    	    } else if (secondFreqValue == 0 || secondFreqValue == freqValue){
    	        secondFreqValue = freqValue;
    	        secondCounter++;
    	    } else { // There are 3 freqValueuencies, invalid
    	        return "NO";
    	    }
//    	    System.out.println(ch + ": 1f: " + firstFreqValue + "(" + firstCounter + "), 2f: " + secondFreqValue + "(" + secondCounter + ")");
    	}
        if (firstCounter == 0 || secondCounter == 0) { // All chars with the same count
            return "YES";
        }
        if (firstCounter == 1 && (firstFreqValue == 1 || firstFreqValue - secondFreqValue == 1)) { // Difference in counts == 1
            return "YES";
        }
        if (secondCounter == 1 && (secondFreqValue == 1 || secondFreqValue - firstFreqValue == 1)) { // Difference in counts == 1
            return "YES";
        }
    	return "NO";
    	
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