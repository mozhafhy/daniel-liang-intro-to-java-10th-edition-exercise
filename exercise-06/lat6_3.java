/*
(Palindrome integer) Write the methods with the following headers

// Return the reversal of an integer, i.e., reverse(456) returns 654
public static int reverse(int number)

// *Return true if number is a palindrome
public static boolean isPalindrome(int number)

Use the reverse method to implement isPalindrome. A number is a palindrome if its reversal is the same as itself. Write a test program that prompts the user to enter an integer and reports whether the integer is a palindrome.
*/
import java.util.Scanner;

public class lat6_3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		System.out.print(isPalindrome(num));
		in.close();
	}

	public static int reverse(int number) {
		String numInString = "";
		while (number != 0) {
			numInString += number % 10;
			number = number / 10;
		}
		number = Integer.parseInt(numInString);
		return number;
	}

	public static boolean isPalindrome(int number) {
		if (number == reverse(number)) return true;
		return false;
	}
}