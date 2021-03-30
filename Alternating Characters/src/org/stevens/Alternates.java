package org.stevens;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Alternates {

    static int alternatingCharacters(String s) {
        char ch = s.charAt(0);
        int dels = 0;
        for (int i=1; i<s.length(); i++) {
            if (ch == s.charAt(i)) {
                dels++;
            } else {
                ch = s.charAt(i);
            }
        }
        return dels;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/input.txt");
        Scanner scan = new Scanner(file);
        int q = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        while (q-->0) {
            String s = scan.nextLine();
            System.out.println("Chars deleted: " + alternatingCharacters(s));
        }

        scan.close();
    }

}
