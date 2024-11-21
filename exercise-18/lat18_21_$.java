/*
(Decimal to binary) Write a recursive method that converts a decimal number
into a binary number as a string
 */

import java.util.Scanner;

public class lat18_21_$ {
	public static void main(String[] args) {
		// read n from user input
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		System.out.println(dec2Bin(n));
	}

	/**
	 * ex;
	 * 4
	 * 4 % 2 -> 0 (0)
	 * 4 / 2 -> 2
	 * 2 % 2 -> 0 (00)
	 * 2 / 2 -> 1
	 * 1 % 2 -> 1 (100)
	 * 1 / 2 -> 0 (STOP)
	 */
	public static String dec2Bin(int value) {
		if (value == 0)
			return "0";
		return dec2Bin(value / 2) + String.valueOf(value % 2);
	}
}