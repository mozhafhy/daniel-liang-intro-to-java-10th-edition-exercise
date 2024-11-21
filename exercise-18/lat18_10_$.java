/*
(Occurrences of a specified character in a string) Write a recursive method that
finds the number of occurrences of a specified letter in a string
 */

import java.util.Scanner;

public class lat18_10_$ {
	public static void main(String[] args) {
		// read str and a from user input
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		char a = in.next().charAt(0); // get the first character of a word
		in.close();

		System.out.println(count(str, a));
	}

	// counter that will check every character from right to left
	public static int count(String str, char a) {
		// stop if there are no more character in the string
		if (str.length() == 0)
			return 0;

		// recall method with string removed 1 char
		int numOfOccurences = count(str.substring(0, str.length() - 1), a);

		// increase counter if the last char of str is a
		if (str.charAt(str.length() - 1) == a) {
			numOfOccurences++;
		}

		return numOfOccurences;
	}
}