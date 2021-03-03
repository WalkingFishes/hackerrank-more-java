import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	static String abbreviation(String a, String b) {
		// Append all chars from a that are in b to a StringBuffer
		StringBuffer s = new StringBuffer(a.length());
		for (int i=0; i<a.length(); i++) {
			// Only lowercase letters can be deleted
			// If upper case, copy it
			// otherwise, copy it if it exists in b
			char c = a.charAt(i);
			if (Character.isUpperCase(c)) {
				s.append(c);
			} else if (s.length() < b.length()) {
				if (b.indexOf(Character.toUpperCase(c)) >= 0) {
					s.append(Character.toUpperCase(c));
				}
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
