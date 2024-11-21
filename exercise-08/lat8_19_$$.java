/*
(Pattern recognition: four consecutive equal numbers) Write the following
method that tests whether a two-dimensional array has four consecutive numbers
of the same value, either horizontally, vertically, or diagonally. Write a test
program that prompts the user to enter the number of rows and columns of a two-dimensional
array and then the values in the array and displays
true if the array contains four consecutive numbers with the same value.
 */

import java.util.Scanner;

public class lat8_19_$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// prompt user to input number of rows and columns
		System.out.print("Number of rows: ");
		int rows = in.nextInt();
		System.out.print("Number of columns: ");
		int columns = in.nextInt();

		int[][] array = new int[rows][columns];

		// read user input for array values
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j] = in.nextInt();
			}
		}

		// check four consecutive equal numbers
		if (checkRows(array) || checkCols(array) || checkDiagonal(array) || checkAntidiagonal(array)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		in.close();
	}

	// check four consecutive in rows
	static boolean checkRows(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			int consecutiveCount = 0; // total consecutive same number
			int prevValue = array[0][0];
			for (int j = 0; j < array.length; j++) {
				if (array[i][j] == prevValue) {
					// current value still same to prev value
					consecutiveCount++;
					if (consecutiveCount == 4)
						return true;
				} else {
					// current value different from prev value
					consecutiveCount = 0;
					prevValue = array[i][j]; // change prev value
				}
			}
		}

		return false;
	}

	// check four consecutive in cols
	static boolean checkCols(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			int consecutiveCount = 0; // total consecutive same number
			int prevValue = array[0][0];
			for (int j = 0; j < array.length; j++) {
				if (array[j][i] == prevValue) {
					// current value still same to prev value
					consecutiveCount++;
					if (consecutiveCount == 4)
						return true;
				} else {
					// current value different from prev value
					consecutiveCount = 0;
					prevValue = array[i][j]; // change prev value
				}
			}
		}

		return false;
	}

	// check four consecutive in diagonal
	static boolean checkDiagonal(int[][] array) {
		int consecutiveCount = 0;
		int prevValue = array[0][0];
		for (int i = 0; i < array.length; i++) {
			if (array[i][i] == prevValue) {
				consecutiveCount++;
				if (consecutiveCount == 4)
					return true;
			} else {
				consecutiveCount = 0;
				prevValue = array[i][i];
			}
		}

		return false;
	}

	// check four consecutive in diagonal
	static boolean checkAntidiagonal(int[][] array) {
		int consecutiveCount = 0;
		int prevValue = array[0][0];
		for (int i = 0; i < array.length; i++) {
			if (array[i][array.length - i - 1] == prevValue) {
				consecutiveCount++;
				if (consecutiveCount == 4)
					return true;
			} else {
				consecutiveCount = 0;
				prevValue = array[i][i];
			}
		}

		return false;
	}
}