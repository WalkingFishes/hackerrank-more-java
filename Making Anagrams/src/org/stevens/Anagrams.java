package org.stevens;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Anagrams {
    
    static int makeAnagram(String a, String b) {
        /*
         * Remove all letters in a that aren't in b and count the removals
         * Remove all letters in b that aren't in a and count the removals
         * Take difference in string lengths
         * Sum the 3 counts to equal the number of deletions to make the two string anagrams.
         * 
         */
        /* Convert a and b to HashSets (makes unique chars)
         * 
         * 
         */
        HashSet<String> hashA = new HashSet<String>(Arrays.asList(a.split("")));
//        System.out.println("A: " + hashA);
        HashSet<String> hashB = new HashSet<String>(Arrays.asList(b.split("")));
//        System.out.println("B: " + hashB);
        
        // aNotInB contains all the chars in a that aren't in b
        HashSet<String> aNotInB = new HashSet<String>();
        aNotInB = (HashSet<String>) hashA.clone();
        aNotInB.removeAll(hashB);
//        System.out.println("A not in B: " + aNotInB);
        // aList contains all the chars in a that are in b
        List<String> aList = new ArrayList<String>(Arrays.asList(a.split("")));
        aList.removeAll(aNotInB);
//        System.out.println("A in B: " + aList);

        // bNotInA contains all the chars in b that aren't in a
        HashSet<String> bNotInA = new HashSet<String>();
        bNotInA = (HashSet<String>) hashB.clone();
        bNotInA.removeAll(hashA);
//        System.out.println("B not in A: " + bNotInA);
        // bList contains all the chars in b that are in a
        List<String> bList = new ArrayList<String>(Arrays.asList(b.split("")));
        bList.removeAll(bNotInA);
//        System.out.println("B in A: " + bList);
        
        // No. chars deleted from A
        int delA = a.length() - aList.size();
        // No. chars deleted from B
        int delB = a.length() - bList.size();
        
        return delA + delB;
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
