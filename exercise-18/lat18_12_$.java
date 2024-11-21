/*
(Print the characters in a string reversely) Rewrite Programming Exercise 18.9
using a helper method to pass the substring high index to the method
 */

import java.util.Scanner;

public class lat18_12_$ {
	public static void main(String[] args) {
		// read value from user input
		Scanner in = new Scanner(System.in);
		String value = in.nextLine();
		in.close();

		reverseDisplay(value, value.length() - 1);
	}

	/**
	 * 
	 * @param value string to be reversed
	 * @param high  the highest index in the string that's not printed yet
	 */
	public static void reverseDisplay(String value, int high) {
		// stop if there are no unprinted character left
		if (high < 0)
			return;

		// print the highest index that's not printed
		System.out.print(value.charAt(high));
		reverseDisplay(value, high - 1);
	}
}