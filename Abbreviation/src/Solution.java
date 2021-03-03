import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	static String abbreviation(String a, String b) {
		// Append all chars from a that are in b to a StringBuffer
		// Go through character by character comparison of a and b
		// If a is upper case, add to StringBuffer s
		// If a is lowercase, compare to b at current b index
		//     If match (upper or lower) add to s
		//     If no match (include if end of b is reached), do not add to s
		// At end of a, compare b to s
		StringBuffer s = new StringBuffer(a.length());
		int j=0; // index for String b
		for (int i=0; i<a.length(); i++) { // index for String a
			// Only lowercase letters can be deleted
			// If upper case, copy it
			// otherwise, copy it if it exists in b at current b index
			char c = a.charAt(i);
			if (Character.isUpperCase(c)) {
				s.append(c);
				j++;
			} else if (j < b.length() && b.charAt(j) == Character.toUpperCase(c)) { // a is lowercase
				s.append(Character.toUpperCase(c));
				j++;
			}
		}
//		System.out.println(s);
		// Check if strings match
		if (b.contentEquals(s)) {
			return "YES";
		} else {
			return "NO";
		}
		
	}
	public static void main (String[] args) throws FileNotFoundException {
		File file = new File("src/input.txt");
		Scanner scan = new Scanner(file);
		int N = scan.nextInt();
		scan.nextLine();
		while (N-- > 0) {
			String a = scan.nextLine();
			String b = scan.nextLine();
			System.out.println(abbreviation(a, b));
		}
		scan.close();
	}
}
