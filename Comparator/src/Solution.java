import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player {
	String name;
	int score;
	
	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player> {
	public int compare(Player a, Player b) {
		if (a.score > b.score) return -1;
		if (a.score < b.score) return 1;
		return a.name.compareTo(b.name);
	}
}

public class Solution {
	

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("src/input.txt");
		Scanner scan = new Scanner(file);
		int n = scan.nextInt(); // Number of players
		
		Player[] player = new Player[n];
		Checker checker = new Checker();

		for (int i=0; i<n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		System.out.println("Before: ");
		for (Player p : player) System.out.println(p.name + " " + p.score);
		Arrays.sort(player, checker);
		System.out.println("\nAfter: ");
		for (Player p : player) System.out.println(p.name + " " + p.score);

		scan.close();
		
	}
}
