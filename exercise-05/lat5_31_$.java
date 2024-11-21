/*
 * Misal kamu investasi CD seharga $10,000 dengan yield tahunannya
 * sebesar 5.75%. Setelah 1 bulan, nilai CD-nya menjadi:
 * 10000 + 10000 * 5.75 / 1200 = 10047.92 = 10000 * (1 + 5.75 / 1200)
 * 
 * Setelah 2 bulan:
 * 10047.92 + 10047.92 * 5.75 / 1200 = 10096.06 = 10047.92 * (1 + 5.75 / 1200)
 * 
 * Setelag 3 bulan:
 * 10096.06 + 10096.06 * 5.75 / 1200 = 10144.44 = 10096.06 * (1 + 5.75 / 1200)
 * dst...
 * 
 * Buat program yang meminta user untuk memasukkan nilai CD, yield
 * tahunan, dan banyak bulan, lalu tampilkan tabel yang menunjukkan
 * seperti berikut ini.
 * Month  CD Value
 * 1      10047.92
 * 2      10096.06
 * ...
 * n - 1  val_n-1
 * n      val_n
 */

import java.util.Scanner;

public class lat5_31_$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter the initial deposit amount: ");
		double initDeposit = in.nextDouble();

		System.out.print("Enter annual percentage yield: ");
		double annualYield = in.nextDouble() / 100; // ? bagi 100 untuk mengubahnya menjadi persen

		System.out.print("Enter maturity period (number of months): ");
		int numOfMonths = in.nextInt();

		// * Loop untuk mencetak tabel
		System.out.println("Month  CD Value"); // ? header tabel
		double depositAfterEachMonth = initDeposit;
		for (int month = 1; month <= numOfMonths; month++) { // ! Kita mulai dari bulan ke-1
			depositAfterEachMonth *= (1 + annualYield / 12); // ? bagi 12 untuk mengubahnya menjadi yield per bulan

			// Cetak konten/baris
			System.out.printf("%d\t%.2f\n", month, depositAfterEachMonth);
		}

		in.close();
	}
}