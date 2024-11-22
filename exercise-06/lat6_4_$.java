/*
(Display an integer reversed) Write a method with the following header to display an integer in reverse order:

public static void reverse(int number)

For example, reverse(3456) displays 6543. Write a test program that prompts the user to enter an integer and displays its reversal.
*/
import java.util.Scanner;

public class lat6_4_$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		reverse(num);
		
		in.close();
	}

	public static void reverse(int number) {
		String numString = "";
		while (number != 0) {
			numString += number % 10;
			number = number / 10;
		}
		System.out.print((numString));
	}
}