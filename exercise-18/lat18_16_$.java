/*
(Find the number of uppercase letters in an array) Write a recursive method
to return the number of uppercase letters in an array of characters.
 */

import java.util.Scanner;

public class lat18_16_$ {
	static char lowestUppercase = 'A'; // 'A' is the uppercase letter with lowest value in UTF-16
	static char highestUppercase = 'Z'; // 'Z' is the uppercase letter with lowest value in UTF-16

	public static void main(String[] args) {
		// read string from user input and convert it to characters array
		Scanner in = new Scanner(System.in);
		char[] chars = in.nextLine().toCharArray();
		in.close();

		System.out.println(count(chars));
	}

	public static int count(char[] chars) {
		return count(chars, chars.length - 1);
	}

	/**
	 * check every character from right to left
	 * 
	 * @param chars array of characters to be checked
	 * @param high  the highest index of unchecked array elements
	 * @return number of uppercase letters
	 * 
	 */
	public static int count(char[] chars, int high) {
		if (high < 0)
			return 0;

		int numOfUppercaseLetters = count(chars, high - 1);

		// increase counter if character in high index is uppercase letter
		if (chars[high] >= lowestUppercase && chars[high] <= highestUppercase) {
			numOfUppercaseLetters++;
		}

		return numOfUppercaseLetters;
	}
}