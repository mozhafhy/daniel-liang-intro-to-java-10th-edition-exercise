/*
(Occurrences of a specified character in an array) Write a recursive method that
finds the number of occurrences of a specified character in an array. You need to
define the following two methods.
 */

import java.util.Scanner;

public class lat18_17_$ {
	public static void main(String[] args) {
		// read target char and a string from user input
		// that converted into characters array
		Scanner in = new Scanner(System.in);
		char[] chars = in.nextLine().toCharArray();
		char a = in.next().charAt(0); // get the first character of a word
		in.close();

		System.out.println(count(chars, a));
	}

	/**
	 * character occurrence counter that will check the string from right to left
	 * 
	 * @param chars array of characters to be checked
	 * @param a     target character
	 * @return number of occurrences
	 * 
	 */
	public static int count(char[] chars, char ch) {
		return count(chars, ch, chars.length - 1);
	}

	/**
	 * character occurrence counter that will check the string from right to left
	 * 
	 * @param chars array of characters to be checked
	 * @param a     target character
	 * @param high  the highest index of unchecked array element
	 * @return number of occurrences
	 * 
	 */
	public static int count(char[] chars, char a, int high) {
		// stop if there are no more character in the string
		if (high < 0)
			return 0;

		// recall method with string removed 1 char
		int numOfOccurrences = count(chars, a, high - 1);

		// increase counter if the last char of str is a
		if (chars[high] == a) {
			numOfOccurrences++;
		}

		return numOfOccurrences;
	}
}