
/*
(Binary to decimal) Write a recursive method that parses a binary number as a
string into a decimal integer
 */

import java.util.Scanner;

public class lat18_23_$ {
	public static void main(String[] args) {
		// read binaryString from user input
		Scanner in = new Scanner(System.in);
		String binaryString = in.next();
		in.close();

		System.out.println(bin2Dec(binaryString));
	}

	/**
	 * ex:
	 * 110
	 * 0 + b2d(11) * 2
	 * 0 + (1 + b2d(1) * 2) * 2
	 * 0 + (1 + 1 * 2) * 2
	 * 0 + (1 + 2) * 2
	 * 0 + 6
	 * 6
	 */
	static int bin2Dec(String binaryString) {
		// stop if binaryString doesn't have any char left
		if (binaryString.length() == 0)
			return 0;

		int lastCharIndex = binaryString.length() - 1;
		char lastChar = binaryString.charAt(lastCharIndex);
		int charValue = lastChar == '0' ? 0 : 1;

		return charValue + bin2Dec(binaryString.substring(0, lastCharIndex)) * 2;
	}
}