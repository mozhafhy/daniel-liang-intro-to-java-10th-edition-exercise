/*
(Factorial) Using the BigInteger class introduced in Section 10.9, you can
find the factorial for a large number (e.g., 100!). Implement the factorial
method using recursion. Write a program that prompts the user to enter an integer and displays its factorial.
 */

import java.math.BigInteger;
import java.util.Scanner;

public class lat18_1_$ {
	public static void main(String[] args) {
		// receive user input
		Scanner in = new Scanner(System.in);
		String nString = in.next();
		in.close();

		// convert input to BigInt
		BigInteger n = new BigInteger(nString);

		System.out.println(factorial(n));
	}

	static BigInteger factorial(BigInteger n) {
		// check if n <= 1
		if (n.compareTo(BigInteger.ONE) != 1)
			return BigInteger.ONE;

		// return n * factorial(n-1)
		return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}
}