/*
(Sort three numbers) Write a method with the following header to display three numbers in increasing order:

public static void displaySortedNumbers(double num1, double num2, double num3)

Write a test program that prompts the user to enter three numbers and invokes the method to display them in increasing order.
*/
import java.util.Scanner;

public class lat6_5_$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num1 = in.nextInt();
		int num2 = in.nextInt();
		int num3 = in.nextInt();

		displaySortedNumbers(num1, num2, num3);

		in.close();
	}

	public static void displaySortedNumbers( double num1, double num2, double num3) {
		double min = num1;
		double max = num1;
		double mid = num1;

		if (num2 <= min) {
			min = num2;
		}
		if (num3 <= min) {
			min = num3;
		}

		if (num2 >= max) {
			max = num2;
		}
		if (num3 >= max) {
			max = num3;
		}

		if (min <= num2 && num2 <= max) {
			mid = num2;
		}
		if (min <= num3 && num3 <= max) {
			mid = num3;
		}

		System.out.printf("%.2f %.2f %.2f", min, mid, max);
	}
}