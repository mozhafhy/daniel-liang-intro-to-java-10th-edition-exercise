/*
 * Demonstrasikan cancellation error dengan membandingkan penghitungan 
 * dari kiri ke kanan dan kanan ke kiri dari deret berikut.
 * 
 * 1 + 1/2 + 1/3 + 1/4 + ... + 1/n
 * 
 * umtuk n = 50000.
 */

public class lat5_23_$ {
	public static void main(String[] args) {
		final int n = 50000;
		double sumLeftToRight = 0.0;
		double sumRightToLeft = 0.0;

		//* Lakukan penghitungan dari kiri ke kanan menggunakan for loop
		for (int i = 1; i <= n; i++) { // dimulai dari 1 karena deretnya dimulai dari 1
			sumLeftToRight += 1.0 / i; // pakai 1.0 agar jadi double karena i integer
		}

		//* Lakukan penghitungan dari kanan ke kiri menggunakan for loop
		for (int i = n; i >= 1; i--) { // berakhir di i = 1 karena deretnya berakhir di 1
			sumRightToLeft += 1.0 / i; // pakai 1.0 agar jadi double karena i integer
		}

		// Cetak hasil dan selisihnya
		System.out.println("Computing from left to right " + sumLeftToRight);
		System.out.println("Computing from right to left " + sumRightToLeft);
		System.out.println("The difference is " + (sumRightToLeft - sumLeftToRight));
	}
}