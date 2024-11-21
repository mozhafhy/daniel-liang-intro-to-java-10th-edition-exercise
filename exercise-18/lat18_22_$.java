/*
(Decimal to hex) Write a recursive method that converts a decimal number into
a hex number as a string
 */

import java.util.Scanner;

public class lat18_22_$ {

	public static void main(String[] args) {
		// read n from user input
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		System.out.println(dec2Hex(n));
	}

	/**
	 * ex;
	 * 27
	 * 27 % 16 -> 11 (B)
	 * 27 / 16 -> 1
	 * 1 % 16 -> 1 (1B)
	 * 1 / 16 -> 0 (STOP)
	 */
	public static String dec2Hex(int value) {
		String[] symbols = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

		if (value == 0)
			return "0";
		return dec2Hex(value / 16) + symbols[value % 16];
	}
}