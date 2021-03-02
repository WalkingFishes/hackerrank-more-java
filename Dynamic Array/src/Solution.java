import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * 
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
    	int lastAnswer=0;
//    	System.out.println(n);
    	List<Integer> result = new ArrayList<>();
    	List<List<Integer>> arr = new ArrayList<>(2);
    	for (int i=0; i < 2; i++) {
    		arr.add(new ArrayList<Integer>());
    	}
    	for (List<Integer> ilist : queries) {
//    		System.out.println(ilist);
    		int qType = ilist.get(0);
    		int x = ilist.get(1);
    		int y = ilist.get(2);
    		int idx = (x^lastAnswer)%n;
//    		System.out.println("Find list within arr at index: " + idx + " " + arr.get(idx));
    		List<Integer> tempList = new ArrayList<>();
    		tempList.clear();
    		for (int v : arr.get(idx)) {
//    			if (v != 0) tempList.add(v);
    			tempList.add(v);
    		}
    		if (qType == 1) {
    			tempList.add(y);
    			arr.set(idx, tempList);
//    			System.out.println("Append " + y + " to arr[" + idx + "] " + arr.get(idx));
    		} else if (qType == 2) {
//    			System.out.println("Find the value at element. . .assign to lastValue");
    			int lastIndex = y % arr.get(idx).size();
    			List<Integer> ylist = arr.get(idx);
    			lastAnswer = ylist.get(lastIndex);
    			System.out.println(lastAnswer);
    		}
//    		System.out.println("lastAnswer=" + lastAnswer);
//    		for (int i=0; i<n; i++) {
//    			System.out.println("arr[" + i + "]="+arr.get(i));
//    		}
    	}

    	return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
    	File file = new File("src/input.txt");
    	FileInputStream input = new FileInputStream(file);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

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

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
