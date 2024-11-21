/*
(Game: nine heads and tails) Nine coins are placed in a 3-by-3 matrix with some
face up and some face down. You can represent the state of the coins using a
3-by-3 matrix with values 0 (heads) and 1 (tails)
 */

import java.util.Scanner;

public class lat8_11_$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 511: ");
		int n = in.nextInt();

		String bin = decTo9DigitsBin(n);

		// draw the matrix
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				char digit = bin.charAt(i * 3 + j);
				char symbol = digit == '0' ? 'H' : 'T';
				System.out.print(symbol + " ");
			}
			System.out.println();
		}

		in.close();
	}

	// convert decimal to a 9 digit binary
	static String decTo9DigitsBin(int n) {
		// convert dec to bin
		String result = "";
		while (n > 0) {
			result += n % 2;
			n /= 2;
		}

		// add zero to the front to make it 9 digits
		while (result.length() < 9) {
			result = "0" + result;
		}

		return result;
	}
}