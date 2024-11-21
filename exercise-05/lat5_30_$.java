/*
 * Misal kamu punya tabungan 100 dan bunga tahunan 5% sehingga bunga
 * bulanannya adalah 0.05 / 12 = 0.00417. Setelah satu bulan, tabunganmu
 * menjadi:
 * 100 * (1 + 0.00417) = 100.417
 * 
 * Bulan berikutnya, tabunganmu menjadi:
 * (100.417) * (1 + 0.00417) = 201.252
 * 
 * Bulan berikutnya menjadi:
 * (201.252) * (1 + 0.00417) = 301.507
 * 
 * dst...
 * 
 * Buat program yang meminta user untuk memasukkan tabungan awal, bunga
 * tahunan, dan lama menabung dalam bulan (e.g. 6), lalu tampilkan total
 * tabungan akhirnya.
 */

import java.util.Scanner;

public class lat5_30_$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter saving amount: ");
		double initSaving = in.nextDouble();

		System.out.print("Enter annual interest: ");
		double annualInterestRate = in.nextDouble() / 100.0; // ? bagi 100 untuk mengubahnya menjadi persen

		System.out.print("Enter number of months: ");
		int numOfMonths = in.nextInt();

		// * Loop untuk menghitung tabungan akhir
		double endSavingAmount = 0;
		for (int month = 1; month <= numOfMonths; month++) { // ! kita mulai dari bulan ke-1
			endSavingAmount = (endSavingAmount + initSaving) * (1 + annualInterestRate / 12);
			System.out.println(1 + annualInterestRate / 12);
			System.out.println(endSavingAmount);
		}

		System.out.printf("Your total savings after %d months is %.3f", numOfMonths, endSavingAmount);
		in.close();
	}
}