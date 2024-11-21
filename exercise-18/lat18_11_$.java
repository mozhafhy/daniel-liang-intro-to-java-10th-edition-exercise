/*
(Sum the digits in an integer using recursion) Write a recursive method that
computes the sum of the digits in an integer
 */

import java.util.Scanner;

public class lat18_11_$ {
	public static void main(String[] args) {
		// read n from user input
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		in.close();

		System.out.println(sumDigits(n));
	}

	// sum the digits from the rightmost digit
	public static int sumDigits(long n) {
		// stop recursion when n = 0 (base case)
		if (n == 0)
			return 0;

		// get the rightmost digit (last digit)
		int lastDigit = (int) (n % 10);

		// 234 -> 23 + 4 -> 2 + 3 + 4 -> 0 + 2 + 3 + 4 -> 9
		return sumDigits(n / 10) + lastDigit;
	}
}