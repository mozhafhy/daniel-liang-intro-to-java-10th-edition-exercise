/*
(Print the digits in an integer reversely) Write a recursive method that displays
an int value reversely
*/

import java.util.Scanner;

public class lat18_8_$ {
	public static void main(String[] args) {
		// read n from user input
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		reverseDisplay(n);
	}

	static void reverseDisplay(int n) {
		// stop if there are no digits left
		if (n == 0)
			return;

		System.out.print(n % 10); // display last digit of n
		reverseDisplay(n / 10); // remove the last digit of n then recall the method
	}
}