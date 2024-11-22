/*
(Find the number of uppercase letters in a string) Write a recursive method
to return the number of uppercase letters in a string. Write a test program that
prompts the user to enter a string and displays the number of uppercase letters in
the string.
 */

import java.util.Scanner;

public class lat18_14_$ {
	static char lowestUppercase = 'A'; // 'A' is the uppercase letter with lowest value in UTF-16
	static char highestUppercase = 'Z'; // 'Z' is the uppercase letter with lowest value in UTF-16

	public static void main(String[] args) {
		// read value from user input
		Scanner in = new Scanner(System.in);
		String value = in.nextLine();
		in.close();

		System.out.print(countUppercaseLetters(value, value.length() - 1));
	}

	/**
	 * check every character from right to left
	 * 
	 * @param value string to be checked
	 * @param high  the highest index in the string that's unchecked
	 * @return number of uppercase letters
	 * 
	 */
	static int countUppercaseLetters(String value, int high) {
		// stop if there are no more unchecked character in the string
		if (high < 0)
			return 0;

		char rightmostChar = value.charAt(high);

		// count uppercase letters from the rest of unchecked characters
		int numOfUppercaseLetters = countUppercaseLetters(value, high - 1);

		// increase counter if the current char in the range of uppercase letters
		if (rightmostChar >= lowestUppercase && rightmostChar <= highestUppercase) {
			numOfUppercaseLetters++;
		}

		return numOfUppercaseLetters;
	}
}