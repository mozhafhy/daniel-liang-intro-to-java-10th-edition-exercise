/*
 * (Sum series) Write a recursive method to compute series
 * Write a test program that displays m(i) for i = 1, 2, . . ., 10
 */

public class lat18_6_$ {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(m(i));
		}
	}

	// sum series
	static double m(int i) {
		if (i == 0)
			return 0;

		// 1/2 + 2/3 + 3/4 + ... + 1/(1+1)
		return m(i - 1) + ((double) i / (i + 1));
	}
}