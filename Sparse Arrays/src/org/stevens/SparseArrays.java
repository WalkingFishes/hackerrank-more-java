package org.stevens;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SparseArrays {
    
    static int[] matchStrings(String[] strings, String[] queries) {
        Arrays.sort(strings);
        List<String> arrList = new ArrayList<String>(Arrays.asList(strings));
        int[] retInt = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            retInt[i] = Collections.frequency(arrList, queries[i]);
        }
        return retInt;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/input.txt");
        Scanner scan = new Scanner(file);
        int N = Integer.valueOf(scan.nextLine());
        String[] arr = new String[N];
        for (int i = 0; i<N; i++) {
            arr[i] = scan.nextLine();
        }
        int Q = Integer.valueOf(scan.nextLine());
        String[] queries = new String[Q];
        for (int i = 0; i<Q; i++) {
            queries[i] = scan.nextLine();
        }
        System.out.print("[");
        for (int k : matchStrings(arr, queries)) {
            System.out.print(k+",");
        }
        System.out.println("]");
        scan.close();
        
    }
}
