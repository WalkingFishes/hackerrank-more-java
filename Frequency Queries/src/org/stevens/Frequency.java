package org.stevens;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Frequency {
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        HashMap<Integer,Integer> integerHash = new HashMap<>();
        List<Integer> returnList = new ArrayList<>();
        for (List<Integer> qList : queries) {
            int qType = qList.get(0);
            int qValue = qList.get(1);
            Integer freq;
            switch (qType) {
                case 1:
                    System.out.println("Insert " + qValue);
                    freq = integerHash.get(qValue);
                    if (freq == null) {
                        freq = 0;
                    }
                    integerHash.put(qValue, ++freq);
                    break;
                case 2:
                    System.out.println("Delete " + qValue);
                    freq = integerHash.get(qValue);
                    if (freq != null) {
                        freq--;
                        if (freq == 0) {
                            integerHash.remove(qValue);
                        } else {
                            integerHash.put(qValue, --freq);
                        }
                    }
                    break;
                case 3:
                    System.out.println(integerHash + " Check for integer frequency of " + qValue);
                    if (integerHash.containsValue(qValue)) {
                        returnList.add(1);
                    } else {
                        returnList.add(0);
                    }
                    break;
                default:
                    System.out.println("Invalid query type");
                    break;
            }
        }
        return returnList;
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/input.txt"));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

//    public static void main(String[] args) throws FileNotFoundException {
//
//    	File file = new File ("src/input.txt");
//    	Scanner scan = new Scanner(file);
//    	int q = scan.nextInt();
//    	List<List<Integer>> queries = new ArrayList<>();
//    	scan.nextLine();
//    	
//    	while (q-->0) {
//    	     s = scan.nextLine();
//    	    System.out.println(s + ": " + isValid(s));
//    	}
//
//        scan.close();
//    }
}