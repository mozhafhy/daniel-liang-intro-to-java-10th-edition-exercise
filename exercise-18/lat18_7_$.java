/*
(Fibonacci series) Modify Listing 18.2, ComputeFibonacci.java, so that the
program finds the number of times the fib method is called. (Hint: Use a static
variable and increment it every time the method is called.)
 */

import java.util.Scanner;

public class lat18_7_$ {
	static int fibMethodCalledCount = 0;

	public static void main(String[] args) {
		// read n from user input
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		// display fib(n)
		System.out.println(fib(n));

		System.out.println(fibMethodCalledCount);
	}

	// method for finding the Fibonacci number
	public static long fib(long index) {
		fibMethodCalledCount++; // increase counter

		if (index == 0) // Base case
			return 0;

		else if (index == 1) // Base case
			return 1;
		else // Reduction and recursive calls
			return fib(index - 1) + fib(index - 2);
	}
}