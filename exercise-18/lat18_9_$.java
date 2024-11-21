/*
(Print the characters in a string reversely) Write a recursive method that displays a string reversely
 */

import java.util.Scanner;

public class lat18_9_$ {
	public static void main(String[] args) {
		// read value from user input
		Scanner in = new Scanner(System.in);
		String value = in.nextLine();
		in.close();

		reverseDisplay(value);
	}

	public static void reverseDisplay(String value) {
		if (value.length() == 0)
			return; // stop if there are no characters left

		int lastCharIndex = value.length() - 1;
		char lastCharacter = value.charAt(lastCharIndex);
		System.out.print(lastCharacter);

		// recall method with value removed 1 char
		reverseDisplay(value.substring(0, lastCharIndex));
	}
}