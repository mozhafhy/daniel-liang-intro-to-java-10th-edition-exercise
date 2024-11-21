/*
 (Compute greatest common divisor using recursion) The gcd(m, n) can also
be defined recursively as follows:
 - If m % n is 0, gcd(m, n) is n.
 - Otherwise, gcd(m, n) is gcd(n, m % n).
 Write a recursive method to find the GCD. Write a test program that prompts the
user to enter two integers and displays their GCD.
 */

import java.util.Scanner;

public class lat18_3_$ {
	public static void main(String[] args) {
		// read m and n from user input
		Scanner in = new Scanner(System.in);
		System.out.print("Enter m: ");
		int m = in.nextInt();
		System.out.print("Enter n: ");
		int n = in.nextInt();
		in.close();

		System.out.println("gcd: " + gcd(m, n));
	}

	static int gcd(int m, int n) {
		if (m % n == 0)
			return n;
		return gcd(n, m % n);
	}
}