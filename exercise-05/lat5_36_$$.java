/*
 * Buat program untuk membuat kode ISBN-10 dari 9 angka yang dimasukkan
 * user. Format kode ISBN-10:
 * 
 * d1.d2.d3.d4.d5.d6.d7.d8.d9.d10
 * 
 * Di mana d10 nilainya adalah:
 * (1*d1 + 2*d2 + 3*d3 + 4*d4 + 5*d5 + 6*d6 + 7*d7 + 8*d8 + 9*d9) mod 11
 * 
 * Jika d10 = 10, ganti dengan X.
 * 
 * Ex:
 * Enter the first 9 digits of an ISBN as integer: 013031997
 * The ISBN-10 number is 013031997X
 */

import java.util.Scanner;

public class lat5_36_$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the first 9 digits of an ISBN as integer: ");
		long digits = in.nextInt();
		String digitsAsString = String.format("%09d", digits);
		String ISBN10 = digitsAsString;
		// System.out.println(ISBN10);

		int d10 = 0;
		for (int i = 0; i < 9; i++) {
			d10 += i * Integer.parseInt(ISBN10.charAt(i) + "");
		}
		d10 %= 11;

		System.out.println("The ISBN-10 number is " + ISBN10 + ((d10 == 10) ? "X" : d10));
		in.close();
	}
}