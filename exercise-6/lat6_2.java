/*
(Sum the digits in an integer) Write a method that computes the sum of the digits in an integer. Use the following method header: public static int sumDigits(long n)
*/
import java.util.Scanner;

public class lat6_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long num = in.nextLong();
		System.out.println(sumDigits(num));
		in.close();
	}

	public static int sumDigits(long n) {
		int sum = 0;
		while (n != 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}
}