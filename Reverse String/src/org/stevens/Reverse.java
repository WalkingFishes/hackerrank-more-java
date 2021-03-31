package org.stevens;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Reverse {
    static String reverseString(String s) {
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

    static String lastChar2(String s) {
        if (s.length() == 1) {
            return s;
        }
        return Character.toString(s.charAt(s.length()-1)) + lastChar2(s.substring(0, s.length()-1));
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/input.txt");
        Scanner scan = new Scanner(file);
        String s = scan.nextLine();
        System.out.println("In: " + s);
        Instant start = Instant.now();
//        System.out.println("Out1: " + reverseString(s));
        reverseString(s);
        Instant end = Instant.now();
        System.out.println("reverseString: " + Duration.between(start, end));
        start = Instant.now();
//        System.out.println("Out2: " + lastChar2(s));
        lastChar2(s);
        end = Instant.now();
        System.out.println("lastChar2: " + Duration.between(start, end));
        scan.close();

    }

}
