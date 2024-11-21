/*
(Hex to decimal) Write a recursive method that parses a hex number as a string
into a decimal integer
 */

import java.util.Scanner;

public class lat18_24_$ {
	public static void main(String[] args) {
		// read hexString from user input
		Scanner in = new Scanner(System.in);
		String hexString = in.next();
		in.close();

		System.out.println(hex2Dec(hexString));
	}

	/**
	 * ex:
	 * 1B
	 * B (11) + h2d(1) * 16
	 * B (11) + (1 + h2d(0) * 16) * 16
	 * B (11) + (1 + 0 * 16) * 16
	 * 11 + (1 + 0) * 16
	 * 11 + 16
	 * 27
	 */
	public static int hex2Dec(String hexString) {
		char[] symbols = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		// stop if binaryString doesn't have any char left
		if (hexString.length() == 0)
			return 0;

		int lastCharIndex = hexString.length() - 1;
		char lastChar = hexString.charAt(lastCharIndex);

		// search for char in symbols and get its index for its value
		int charValue = 0;
		for (int i = 0; i < symbols.length; i++) {
			if (lastChar == symbols[i]) {
				charValue = i;
				break;
			}
		}

		return charValue + hex2Dec(hexString.substring(0, lastCharIndex)) * 16;
	}
}