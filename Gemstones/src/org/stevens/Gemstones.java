package org.stevens;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Gemstones {
    
    static int gemstones(String[] arr) {
        /*
         * turn each string into a Set, iterate through Set, update HashMap of word counts
         * return number of hashmap entries where value = arr.length
         */
        HashMap<String, Integer> mineralWordCount = new HashMap<>();
        for (String s : arr) {
            String[] mineralArr = s.split("");
            HashSet<String> mineralHash = new HashSet<String>(Arrays.asList(mineralArr));
            System.out.println(mineralHash);
            for (String mineral : mineralHash) {
                int count = mineralWordCount.containsKey(mineral) ? mineralWordCount.get(mineral) : 0;
                mineralWordCount.put(mineral, count + 1);
            }
        }
        System.out.println(mineralWordCount);
        return Collections.frequency(mineralWordCount.values(), arr.length);
    }

    public static void main(String[] args) throws FileNotFoundException {

    	File file = new File ("src/input.txt");
    	Scanner scan = new Scanner(file);
    	int N = scan.nextInt();
    	scan.nextLine();
    	String[] arr = new String[N];
    	
    	for (int i=0; i<N; i++) {
    	    String s = scan.nextLine();
    	    arr[i] = s;
    	}
  	    System.out.println(gemstones(arr));

        scan.close();
    }

}
