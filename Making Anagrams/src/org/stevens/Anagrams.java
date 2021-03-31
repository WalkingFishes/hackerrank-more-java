package org.stevens;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Anagrams {
    static void printDuplicateCharacters(String word) {
        char[] characters = word.toCharArray();
        // build HashMap with character and number of times they appear in String
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (Character ch : characters) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        // Iterate through HashMap to print all duplicate characters of String
        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n", word);
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }
    
    static void printDups(String word) {
        char[] characters = word.toCharArray();
        Arrays.sort(characters);
        char previousChar = '\0';
        int occurrence = 1;
        for (char ch : characters) {
            if (ch == previousChar) {
                occurrence++;
            } else {
                if (occurrence > 1) {
                    System.out.println(previousChar + " : " + occurrence);
                }
                previousChar = ch;
                occurrence = 1;
            }
        }
    }
    
    static int makeAnagram(String a, String b) {
        /*
         * Convert Strings A and B to sorted Lists
         * Walk through shortest list and record number of chars to keep
         * Number of total deletions is length of A - (keep count) + length of B - (keep count)
         */ 

        // Convert a and b to sorted Lists
        List<String> aList = new ArrayList<String>(Arrays.asList(a.split("")));
        aList.sort(Comparator.comparing(String::toString));
//        System.out.println("A sorted: " + aList);
        List<String> bList = new ArrayList<String>(Arrays.asList(b.split("")));
        bList.sort(Comparator.comparing(String::toString));
//        System.out.println("B sorted: " + bList);

        // Get unique list of chars in A
        HashSet<String> hashA = new HashSet<String>(Arrays.asList(a.split("")));
//        System.out.println("A: " + hashA);

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
        long startTime = System.nanoTime();
        int charsDeleted = makeAnagram(a, b);
        long stopTime = System.nanoTime();
//        System.out.println(stopTime - startTime);
//        System.out.println("Chars deleted: " + charsDeleted);
        Instant start = Instant.now();
        printDuplicateCharacters(b);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
        start = Instant.now();
        printDups(b);
        end = Instant.now();
        System.out.println(Duration.between(start, end));

        scan.close();
    }

}
