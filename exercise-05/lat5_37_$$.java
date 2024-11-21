/*
 * Buat program yang mengonversi bilangan desimal yang dimasukkan user
 * menjadi biner.
 */

import java.util.Scanner;

public class lat5_37_$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a decimal number: ");
		long decimal = in.nextLong(); // ? Pakai long karena bisa saja bilangannya lebih dari 10 digit
		String binary = "";

		// * while loop untuk mengonversi decimal ke biner
		while (decimal >= 1) { // ? pakai while karena unconditional
			binary = decimal % 2 + binary;
			decimal /= 2; // ? bagi 2 setiap selesai menentukan modulonya
		}

		System.out.println("The binary representation is " + binary);
		in.close();
	}
}