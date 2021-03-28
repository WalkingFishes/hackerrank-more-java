package org.stevens;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Triplets {

    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long, ArrayList<Integer>> myHash = new HashMap<Long, ArrayList<Integer>>();
        long cnt = 0;
        for (Long l : arr) {
            // Check to see if numbers exists in hashmap, initialize to 0
            ArrayList<Integer> current = myHash.get(l);
            Integer occurrence = 0;
            if (current == null) {
                myHash.put(l, new ArrayList<Integer>(List.of(1,0)));
            } else {
                occurrence = current.get(0);
            }

            // Check if previous number in triplet exists and update l entry with its count
            ArrayList<Integer> previous = myHash.get(l/3);
            Integer prevOcc = 0;
            Integer prevPrevOcc = 0;
            if (previous != null) {
                prevOcc = previous.get(0);
                prevPrevOcc = previous.get(1);
            }
            cnt += prevOcc * prevPrevOcc;
            occurrence += 1;
            myHash.put(l, new ArrayList<Integer>(List.of(occurrence++, prevOcc)));

        }
        for (Long k : myHash.keySet()) {
            ArrayList<Integer> count = myHash.get(k);
            Integer occ = count.get(0);
            Integer pcc = count.get(1);
            System.out.println("k: " + k + ", occ: " + occ + ", pcc: " + pcc);
        }
        return cnt;
    }
    static long perms(List<Long> arr) {
        long cnt = 0;
        for (int i=0; i<arr.size()-2; i++) {
            for (int j=i; j<arr.size()-2; j++) {
                for (int k=j; k<arr.size()-2; k++) {
                    Long x = arr.get(i);
                    Long y = arr.get(j+1);
                    Long z = arr.get(k+2);
                    if ((x == 1 && y == 3 && z == 9) || (x == 3 && y == 9 && z == 27) || (x == 9 && y == 27 && z == 81)) {
                        System.out.print("["+i+","+(j+1)+","+(k+2)+"] : ");
                        System.out.print("["+arr.get(i)+","+arr.get(j+1)+","+arr.get(k+2)+"]");
                        cnt++;
                        System.out.println("  +1");
                    }
                }
            }
        }
        return cnt;
    }
    static long submit(List<Long> arr, long r) {
        Map<Long, Long> potential = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();
        long count = 0;
        for (int i = 0; i < arr.size(); i++) {
            long a = arr.get(i);
            long key = a / r;
            
            if (counter.containsKey(key) && a % r == 0) {
                count += counter.get(key);
            }
            
            if (potential.containsKey(key) && a % r == 0) {
                long c = potential.get(key);
                counter.put(a, counter.getOrDefault(a, 0L) + c);
            }
            
            potential.put(a, potential.getOrDefault(a, 0L) + 1); // Every number can be the start of a triplet.
        }
        return count;        
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/input.txt");
        Scanner scan = new Scanner(file);
        int N = scan.nextInt();
        int r = scan.nextInt();
        scan.nextLine();
        List<Long> arr = new ArrayList<Long>(N);
        
        while (N-- > 0) {
            arr.add(scan.nextLong());
        }
        long ans = perms(arr);
        System.out.println("Brute count: " + ans);
        ans = countTriplets(arr, r);
        System.out.println("Algo count: " + ans);
        ans = submit(arr, r);
        System.out.println("Submit count: " + ans);

    }

}
