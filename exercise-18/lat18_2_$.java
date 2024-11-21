/*
(Fibonacci numbers) Rewrite the fib method in Listing 18.2 using iterations.
Hint: To compute fib(n) without recursion, you need to obtain fib(n - 2)
and fib(n - 1) first. Let f0 and f1 denote the two previous Fibonacci
Programming Exercises 729
numbers.
 */

import java.util.Scanner;

public class lat18_2_$ {
	public static void main(String[] args) {
		// read the value of n from user
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		in.close();

		long f0 = 0; // fib(0)
		long f1 = 1; // fib(1)
		long currentFib = 0; // initiate with f(0)

		/**
		 * calculate for fib >= 2
		 * change current to a new computed value (f0 + f1) then rearrange the values in
		 * every iteration
		 * current -> f1 -> f0 -> (remove)
		 */
		for (int i = 2; i <= n; i++) {
			currentFib = f0 + f1;
			f0 = f1;
			f1 = currentFib;
		}

		// switch current to 1 if n = 1
		if (n == 1)
			currentFib = f1;

		System.out.println(currentFib);
	}
}