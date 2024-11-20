/*
 * Aproksimasikan nilai π menggunakan deret berikut.
 * 4(1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + ... + (-1)^(i + 1) / (2i - 1))
 * untuk i = 10000, 20000, 30000, ..., 100000
 */

public class lat5_25_$$ {
	//* Kita butuh sesuatu untuk menghitung deretnya
	public static void main(String[] args) {
		int n = 100000;
		double PI = 1.0;

		double k = -1.0;
		//! for loop ini digunakan untuk menghitung hampiran nilai π
		for (int i = 2; i <= n; i++) {
			PI += k / (2 * i - 1); //* k digunakan sebagai pengganti Math.pow(-1, i + 1)
			// di sini, k dimulai dari -1 karena deret dimulai dari suku ke-2 (i = 2)
			k *= -1.0; /** ini digunakan untuk mengubah k dari -1 ke 1, 1 ke -1, dst di setiap iterasinya
								 	 * k bernilai 1 untuk suku-suku ganjil (i = 3, 5, 7, ...)
								   * k bernilai -1 untuk suku-suku genap (i = 2, 4, 6, ...) */

			if (i % 10000 == 0) { //! Cetak nilai π setiap i = 10000, 20000, 30000, ..., 100000
				System.out.printf("For i = %d, \u03C0 is %.16f\n", i, 4.0 * PI);
			}
		}
	}
}