/*
(Explore matrix) Write a program that prompts the user to enter the length of a
square matrix, randomly fills in 0s and 1s into the matrix, prints the matrix, and
finds the rows, columns, and diagonals with all 0s or 1s
 */

import java.util.Scanner;

public class lat8_14_$$ {
	public static void main(String[] args) {
		// prompt user to input matrix size
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the size for the matrix:");
		int size = in.nextInt();
		in.close();

		int[][] matrix = new int[size][size];

		// randomly generate 0 and 1 to matrix and display it
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				// assign 1 if random() > 0.5 and 0 if random() <= 0.5
				matrix[i][j] = Math.random() > 0.5 ? 1 : 0;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		findRows(matrix);
		findColumns(matrix);
		checkMajorDiagonal(matrix);
		checkSubDiagonal(matrix);
	}

	static void findRows(int[][] matrix) {
		boolean isRowFound = false;
		rowLoop: for (int i = 0; i < matrix.length; i++) {
			int rowValue = matrix[i][0];

			// validate row
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != rowValue) {
					// go to the next row because this row have 2 different numbers
					continue rowLoop;
				}
			}

			// row is valid
			isRowFound = true;
			System.out.printf("All %ds on row %d%n", rowValue, i);
		}

		if (!isRowFound) {
			System.out.println("No same numbers on a row");
		}
	}

	static void findColumns(int[][] matrix) {
		boolean isColFound = false;
		colLoop: for (int i = 0; i < matrix.length; i++) {
			int colValue = matrix[0][i];

			// validate col
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[j][i] != colValue) {
					// go to the next column because this column have 2 different numbers
					continue colLoop;
				}
			}

			// Column is valid
			isColFound = true;
			System.out.printf("All %ds on column %d%n", colValue, i);
		}

		if (!isColFound) {
			System.out.println("No same numbers on a column");
		}
	}

	// check major diagonal
	static void checkMajorDiagonal(int[][] matrix) {
		int diagonalValue = matrix[0][0];

		// validate diagonal
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][i] != diagonalValue) {
				// diagonal don't have same numbers
				System.out.println("No same numbers on the major diagonal");
				return;
			}
		}

		System.out.printf("All %ds on major diagonal%n", diagonalValue);
	}

	// check sub-diagonal
	static void checkSubDiagonal(int[][] matrix) {
		int diagonalValue = matrix[matrix.length - 1][matrix.length - 1];

		// validate diagonal
		for (int i = 0; i < matrix.length - 1; i++) {
			if (matrix[i + 1][i] != diagonalValue) {
				// diagonal don't have same numbers
				System.out.println("No same numbers on the sub-diagonal");
				return;
			}
		}

		System.out.printf("All %ds on sub-diagonal%n", diagonalValue);
	}
}