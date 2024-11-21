/*
 * Hitung rata-rata dan standar deviasi dari 10 bilangan yang dimasukkan user.
 * 
 * Rumus:
 * mean = sum(xi) / n
 * std_dev = sqrt((sum(xi * xi) - sum(xi) * sum(xi) / n) / (n - 1))
 */

import java.util.Scanner;

public class lat5_45_$$ {
	// Kita butuh algoritma untuk mencari sum(xi)
	// Untuk itu, kita bisa gunakan for loop
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter ten numbers: "); // ? Header

		double sum_xi = 0.0; // ? Nilai awal dari sum(xi)
		double sum_xi_sq = 0.0;
		for (int i = 0; i < 10; i++) {
			double xi = in.nextDouble();
			sum_xi += xi; // ? ini sum(xi)
			sum_xi_sq += xi * xi; // ? ini sum(xi * xi)
		}

		double mean = sum_xi / 10; // ? Bagi 10 karena banyak datanya 10
		double std_dev = Math.sqrt((sum_xi_sq - sum_xi * sum_xi / 10) / 9);

		// Cetak hasilnya
		System.out.printf("The mean is %.2f\n", mean);
		System.out.printf("The standard deviation is %.5f", std_dev);

		in.close();
	}
}