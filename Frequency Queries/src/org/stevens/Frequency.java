package org.stevens;

import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Frequency {
    static List<Integer> freqQuery(List<int[]> queries) {
        HashMap<Integer,Integer> integerHash = new HashMap<>();
        List<Integer> returnList = new ArrayList<>();
        for (int[] qList : queries) {
            int qType = qList[0];
            int qValue = qList[1];
            Integer freq;
            switch (qType) {
                case 1:
//                    System.out.println("Insert " + qValue);
                    freq = integerHash.get(qValue);
                    if (freq == null) {
                        freq = 0;
                    }
                    integerHash.put(qValue, ++freq);
                    break;
                case 2:
//                    System.out.println("Delete " + qValue);
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
//                    System.out.println(integerHash + " Check for integer frequency of " + qValue);
                    if (integerHash.containsValue(qValue)) {
                        returnList.add(1);
                    } else {
                        returnList.add(0);
                    }
                    break;
                default:
//                    System.out.println("Invalid query type");
                    break;
            }
        }
        return returnList;
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/input12.txt"));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());
        List<int[]> queries = new ArrayList<>(q);
        Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
        for (int i = 0; i < q; i++) {
          int[] query = new int[2];
          Matcher m = p.matcher(bufferedReader.readLine());
          if (m.matches()) {
            query[0] = Integer.parseInt(m.group(1));
            query[1] = Integer.parseInt(m.group(2));
            queries.add(query);
          }
        }
        List<Integer> ans = freqQuery(queries);
        System.out.println(ans.size());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bufferedWriter.write(ans.stream()
                          .map(Object::toString)
                          .collect(joining("\n"))
                          + "\n");

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
