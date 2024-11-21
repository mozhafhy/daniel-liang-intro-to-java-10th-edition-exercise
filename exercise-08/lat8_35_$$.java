/*
(Largest block) Given a square matrix with the elements 0 or 1, write a program
to find a maximum square submatrix whose elements are all 1s. Your program
should prompt the user to enter the number of rows in the matrix. The program
then displays the location of the first element in the maximum square submatrix
and the number of the rows in the submatrix.
 */

import java.util.Scanner;

public class lat8_35_$$ {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of rows in the matrix: ");
		int size = in.nextInt();

		int[][] matrix = new int[size][size];

		System.out.println("Enter the matrix row by row: ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = in.nextInt();
			}
		}

		int[] largestBlockData = findLargestBlock(matrix);
		System.out.printf("The maximum square submatrix is at (%d, %d) with size %d",
				largestBlockData[0], largestBlockData[1], largestBlockData[2]);

		in.close();
	}

	public static int[] findLargestBlock(int[][] m) {
		int largetBlockSize = 0;
		int largetBlockRow = 0;
		int largetBlockCol = 0;

		for (int size = 1; size <= m.length; size++) { // size
			for (int row = 0; row < m.length - size + 1; row++) { // row
				for (int col = 0; col < m.length - size + 1; col++) { // col
					if (size > largetBlockSize && isBlockValid(m, size, row, col)) {
						largetBlockSize = size;
						largetBlockCol = col;
						largetBlockRow = row;
					}
				}
			}
		}

		int[] result = { largetBlockRow, largetBlockCol, largetBlockSize };
		return result;
	}

	// check is the block only consist of 1s
	public static boolean isBlockValid(int[][] m, int size, int row, int col) {
		// search for number that's not 1 in the block
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (m[row + i][col + j] != 1)
					return false;
			}
		}

		return true;
	}
}