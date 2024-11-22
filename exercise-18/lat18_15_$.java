/*
(Occurrences of a specified character in a string) Rewrite Programming Exercise 18.10
using a helper method to pass the substring high index to the method
 */

import java.util.Scanner;

public class lat18_15_$ {
	public static void main(String[] args) {
		// read str and a from user input
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		char a = in.next().charAt(0); // get the first character of a word
		in.close();

		System.out.println(count(str, a, str.length() - 1));
	}

	/**
	 * character occurrence counter that will check the string from right to left
	 * 
	 * @param str  string to be checked
	 * @param a    target character
	 * @param high the highest index in the string that's unchecked yet
	 * @return number of occurrences
	 * 
	 */
	public static int count(String str, char a, int high) {
		// stop if there are no more character in the string
		if (high < 0)
			return 0;

		// recall method with string removed 1 char
		int numOfOccurrences = count(str, a, high - 1);

		// increase counter if the last char of str is a
		if (str.charAt(high) == a) {
			numOfOccurrences++;
		}

		return numOfOccurrences;
	}
}