/*
(Tower of Hanoi) Modify Listing 18.8, TowerOfHanoi.java, so that the program
finds the number of moves needed to move n disks from tower A to tower B.
(Hint: Use a static variable and increment it every time the method is called.)
 */

import java.util.Scanner;

public class lat18_18_$ {
	static int numOfMoves = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		moveDisks(n, 'A', 'B', 'C');
		System.out.println("moves: " + numOfMoves);
	}

	static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
		numOfMoves++;
		// stop if this is the highest
		if (n == 1)
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);

		else {
			moveDisks(n - 1, fromTower, auxTower, toTower);
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
			moveDisks(n - 1, auxTower, toTower, fromTower);
		}
	}
}