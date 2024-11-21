/*
(Game: connect four) Connect four is a two-player board game in which the
players alternately drop colored disks into a seven-column, six-row vertically
suspended grid, as shown below.

 */

import java.util.Scanner;

public class lat8_20_$$$ {
	static char[][] array = new char[6][7];

	// store the height of the disk stack in every column
	static int[] columnHeights = new int[7];

	// current player's disk symbol
	static char playerSymbol = 'R';

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		init();

		while (true) {
			// get color of symbol for display purpose
			String color = playerSymbol == 'R' ? "red" : "yellow";

			display();

			// ask user to make a move until it's valid
			while (true) {
				// prompt user to input column
				System.out.printf("Drop a %s disk at column (0-6): ", color);
				int col = in.nextInt();
				if (drop(col, playerSymbol))
					break;
			}

			if (isWin(playerSymbol)) {
				display();
				System.out.printf("The %s player won", color);
				break;
			}

			if (isDraw()) {
				display();
				System.out.println("Draw");
				break;
			}

			// switch player
			playerSymbol = playerSymbol == 'R' ? 'Y' : 'R';
		}

		in.close();
	}

	// initialize the game by filling array with empty spaces for display
	static void init() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = ' ';
			}
		}
	}

	static void display() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print("|" + array[i][j]);
			}
			System.out.print("|\n");
		}
		System.out.println("---------------");
	}

	// drop disk to array, return false if operation failed
	static boolean drop(int col, char symbol) {
		if (col < 0)
			return false;
		if (col > 6)
			return false;
		if (columnHeights[col] == array.length)
			return false;

		array[array.length - columnHeights[col] - 1][col] = symbol;
		columnHeights[col]++;
		return true;
	}

	static boolean isWin(char symbol) {
		return checkRows(symbol) || checkCols(symbol) || checkDiagonal(symbol) | checkAntidiagonal(symbol);
	}

	static boolean isDraw() {
		for (int i = 0; i < columnHeights.length; i++) {
			if (columnHeights[i] < array.length)
				return false;
		}
		return true;
	}

	// check four consecutive in rows
	static boolean checkRows(char symbol) {
		for (int i = 0; i < array.length; i++) {
			int consecutiveCount = 0; // total consecutive same number
			for (int j = 0; j < array.length; j++) {
				if (array[i][j] == symbol) {
					consecutiveCount++;
					if (consecutiveCount == 4)
						return true;
				} else {
					consecutiveCount = 0;
				}
			}
		}

		return false;
	}

	// check four consecutive in cols
	static boolean checkCols(char symbol) {
		for (int i = 0; i < array.length; i++) {
			int consecutiveCount = 0; // total consecutive same number
			for (int j = 0; j < array.length; j++) {
				if (array[j][i] == symbol) {
					consecutiveCount++;
					if (consecutiveCount == 4)
						return true;
				} else {
					consecutiveCount = 0;
				}
			}
		}

		return false;
	}

	// check four consecutive in diagonal
	static boolean checkDiagonal(char symbol) {
		int consecutiveCount = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i][i] == symbol) {
				consecutiveCount++;
				if (consecutiveCount == 4)
					return true;
			} else {
				consecutiveCount = 0;
			}
		}

		return false;
	}

	// check four consecutive in diagonal
	static boolean checkAntidiagonal(char symbol) {
		int consecutiveCount = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i][array.length - i - 1] == symbol) {
				consecutiveCount++;
				if (consecutiveCount == 4)
					return true;
			} else {
				consecutiveCount = 0;
			}
		}

		return false;
	}
}