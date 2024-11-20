/*
 * Tampilkan semua bilangan prima di antara 2 - 1000
 */

public class lat5_20_$ {
	/*
	 * Kita butuh prime checker
	 */
	public static void main(String[] args) {
		System.out.println("Prime numbers from 2 to 1000:");
		int countPrime = 0;
		for (int n = 2; n < 1000; n++) {
			boolean flag = true;
			for (int i = 2; i < (int) Math.pow(n, 0.5);) { //! Ini adalah prime checker-nya
				if (n % i == 0) { //* i adalah pembagi, jika i habis membagi n, keluar dari loop dan set flag = false
					flag = false;
					break;
				} else { //* Jika tidak habis dibagi, cek untuk pembagi berikutnya
					i++;
				}
			}

			if (flag) { //! Cetak n yang merupakan prima
				countPrime++; // Hitung ada berapa bilangan prima
				System.out.printf("%-4d", n);

				if (countPrime % 8 == 0) //* Ganti baris tiap 8 bil. prima yang dicetak dalam 1 baris
					System.out.println();
			}
		}
	}
}