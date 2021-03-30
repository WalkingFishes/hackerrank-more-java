package org.stevens;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Anagrams {
    
    static int makeAnagram(String a, String b) {
        /*
         * Convert Strings A and B to sorted Lists
         * Walk through shortest list and record number of chars to keep
         * Number of total deletions is length of A - (keep count) + length of B - (keep count)
         */ 

        // Convert a and b to sorted Lists
        List<String> aList = new ArrayList<String>(Arrays.asList(a.split("")));
        aList.sort(Comparator.comparing(String::toString));
        System.out.println("A sorted: " + aList);
        List<String> bList = new ArrayList<String>(Arrays.asList(b.split("")));
        bList.sort(Comparator.comparing(String::toString));
        System.out.println("B sorted: " + bList);

        // Get unique list of chars in A
        HashSet<String> hashA = new HashSet<String>(Arrays.asList(a.split("")));
        System.out.println("A: " + hashA);

        int keep = 0; // This is the length of the anagram
        for (String s : hashA) {
            // keep the lowest value between cntA and cntB
            int cntA = Collections.frequency(aList, s);
            int cntB = Collections.frequency(bList, s);
            keep += (cntA > cntB) ? cntB : cntA;
        }
        return a.length() + b.length() - 2*keep;

    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/input.txt");
        Scanner scan = new Scanner(file);
        String a = scan.nextLine();
        String b = scan.nextLine();
        System.out.println("Chars deleted: " + makeAnagram(a, b));

        scan.close();
    }

}
