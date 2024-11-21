/*
 * Konversi bilangan desimal yang dimasukkan user menjadi oktal.
 */

import java.util.Scanner;

public class lat5_38_$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a decimal number: ");
		long decimal = in.nextLong(); // ? Pakai long karena bilngannya bisa lebih dari 10 digit
		String octal = "";

		// * loop untuk konversi ke oktal
		while (decimal >= 1) {
			octal = (decimal % 8) + octal;
			decimal /= 8;
		}

		System.out.println("The octal representasion is " + octal);
		in.close();
	}
}