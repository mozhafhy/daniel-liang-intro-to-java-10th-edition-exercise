/*
(Math: pentagonal numbers) A pentagonal number is defined as n(3n–1)/2 for n = 1, 2, . . ., and so on. Therefore, the first few numbers are 1, 5, 12, 22, . . . . Write a method with the following header that returns a pentagonal number:
public static int getPentagonalNumber(int n)
Write a test program that uses this method to display the first 100 pentagonal numbers with 10 numbers on each line.
*/

public class lat6_1 {
	public static void main(String[] args) {
		int row, col, num = 1;
		for (row = 0; row < 3; row++) {
			for (col = 0; col < 3; col++) {
				System.out.printf("%d ", getPentagonalNumber(num));
				num++;
			}
			System.out.println();
		}
	}

	public static int getPentagonalNumber(int n) {
		n = n * (3 * n - 1) / 2;
		return n;
	}
}