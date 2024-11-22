/*
 * Buat program yang mengecek apakah sebuah password valid atau tidak.
 * Syarat sebuah password yang valid adalah:
 * 1) Password harus terdiri dari minimal 8 karakter
 * 2) Password harus terdiri dari huruf dan angka
 * 3) Password harus memiliki sedikitnya 2 angka
 */

import java.util.Scanner;

public class lat6_18_$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter a password: ");
		String password = in.next();

		System.out.println((isValidPassword(password)) ? "Valid Password" : "Invalid Password");

		in.close();
	}

	static boolean isValidPassword(String password) {
		password = password.toLowerCase();
		// * Cek panjang
		if (password.length() < 8) {
			return false;
		}

		// * Cek karakter: apakah terdiri dari huruf dan angka
		for (int i = 0; i < password.length(); i++) {
			if (!(Character.isLetter(password.charAt(i)) || Character.isDigit(password.charAt(i)))) {
				return false;
			}
		}

		// * Banyak karakter numerik
		int countNumeric = 0;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				countNumeric++;
			}
		}
		if (countNumeric < 2) {
			return false;
		}

		return true;
	}
}