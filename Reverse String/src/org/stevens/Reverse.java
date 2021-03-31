package org.stevens;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reverse {
    static String reverseString2(String s) {
        String wordBack = lastChar(s, s.length());
        return wordBack;
    }

    static String lastChar(String s, int len) {
        char ch = s.charAt(len-1);
//        System.out.println(ch + " " + len);
        if (len == 1) {
            return Character.toString(ch);
        }
        return Character.toString(ch) + lastChar(s, len-1);
    }

    static String reverseString(String s) {
        if (s.length() == 1) {
            return s;
        }
        return s.substring(s.length()-1) + reverseString(s.substring(0, s.length()-1));
//        return Character.toString(s.charAt(s.length()-1)) + reverseString(s.substring(0, s.length()-1));
    }
    
    static String reverseWords(String s) {
        /*
         * Split string (on spaces) into words, add to Array
         * Iterate backwards through Array and concatenate elements with space in between
         */
        String[] arr = s.split(" ");
        String newString = arr[arr.length-1];
        for (int i=arr.length-2; i>=0; i--) {
            newString = newString + " " + arr[i];
        }
        return newString;
        
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/input.txt");
        Scanner scan = new Scanner(file);
        String s = "";
        while (scan.hasNext()) {
            s += scan.nextLine();
        }
//        System.out.println("In: " + s);
        Instant start = Instant.now();
        Instant end = Instant.now();

        start = Instant.now();
        String rev = reverseString(s);
        end = Instant.now();
        System.out.println("reverse: " + rev + " " + Duration.between(start, end));

        start = Instant.now();
        rev = reverseString2(s);
        end = Instant.now();
        System.out.println("reverseString2: " + rev + " " + Duration.between(start, end));

        System.out.println(reverseWords(s));

        scan.close();

    }

}
