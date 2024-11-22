/*
 * Approcimate a square root of n using the following formula:
 * next_guess = (last_guess + n / last_guess) / 2
 * 
 * Lakukan loop sampai next_guess - lat_guess < δ di mana δ
 * adalah bilangan yang sanget kecil (0.0001 misalnya).
 * 
 * Gunakan method berikut.
 * public static double sqrt(long n)
 */

import java.util.Scanner;

public class lat6_22_$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter a number: ");
		long n = in.nextLong();

		System.out.printf("The square root of %d is %f", n, sqrt(n));
		in.close();
	}

	// * Method untuk mencari akar pangkat dua dari n
	public static double sqrt(long n) {
		double last_guess = 1; // ? Nilai awal bisa berapa saja karena nilainya akan diganti oleh nilai next_guess
		double next_guess;
		final double DELTA = 0.0001; // ? Akurasi yang diharapkan
		
		while (true) {
			next_guess = (last_guess + n / last_guess) / 2.0; // rumus
			// ? Pakai mutlak karena yang diuji adalah selisihnya, bukan hasil pengurangannya
			if (mutlak(next_guess - last_guess) < DELTA) { // jika selisihnya lebih kecil dari DELTA, return next_guess
				return next_guess;
			}
			last_guess = next_guess; // jika tidak, ganti nilai last_guess dengan next_guess, lalu ulangi loop
		}
	}

	static double mutlak(double n) {
		return (n >= 0) ? n : -n;
	}
}