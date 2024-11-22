
/*
(Latin square) A Latin square is an n-by-n array filled with n different Latin letters,
each occurring exactly once in each row and once in each column. Write a
program that prompts the user to enter the number n and the array of characters,
as shown in the sample output, and checks if the input array is a Latin square.
The characters are the first n characters starting from A.
 */

import java.util.Scanner;

public class lat8_36_$$ {
	static char lowestLetter = 'A'; // lowest letter in ASCII table for letter range validation

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// prompt user to input n
		System.out.print("Enter number n: ");
		int n = in.nextInt();

		System.out.printf("Enter %d rows of letters separated by spaces:%n", n);

		char[][] square = new char[n][n];

		// read and validate every element for the square
		for (int i = 0; i < square.length; i++) {
			boolean isRowValid = true;

			for (int j = 0; j < square.length; j++) {
				square[i][j] = in.next().charAt(0);

				if (!isLetterValid(square[i][j], n))
					isRowValid = false;
			}

			in.close();

			if (!isRowValid) {
				System.out.printf("Wrong input: the letters must be from %c to %c",
						lowestLetter, lowestLetter + n - 1);
				return;
			}
		}

		if (isLatinSquare(square)) {
			System.out.println("The input array is a Latin square");
		} else {
			System.out.println("The input array is not a Latin square");
		}

	}

	static boolean isLatinSquare(char[][] square) {
		// check rows
		for (int i = 0; i < square.length; i++) {
			// ensure no letter repetition
			boolean[] areLetterUsed = new boolean[square.length /* square size */];

			// check for every letter
			for (int j = 0; j < square.length; j++) {
				char letter = square[i][j];
				int letterIndex = letter - lowestLetter;
				if (areLetterUsed[letterIndex])
					return false;
				areLetterUsed[letterIndex] = true;
			}
		}

		// check columns
		for (int i = 0; i < square.length; i++) {
			// ensure no letter repetition
			boolean[] areLetterUsed = new boolean[square.length /* square size */];

			// check for every letter
			for (int j = 0; j < square.length; j++) {
				char letter = square[j][i];
				int letterIndex = letter - lowestLetter;
				if (areLetterUsed[letterIndex])
					return false;
				areLetterUsed[letterIndex] = true;
			}
		}

		return true;
	}

	// to be valid, the letter can't exceed 'A' + n - 1
	// ex: if n = 3 -> letter can be A, B, or C
	static boolean isLetterValid(char letter, int n) {
		return letter < lowestLetter + n;
	}
}