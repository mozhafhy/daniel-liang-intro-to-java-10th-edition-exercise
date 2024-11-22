/*
 * Cetak 100 bilangan prima palindromik pertama. Tampilkan 10 bilangan
 * tiap barisnya.
 */

public class lat6_26_$$ {
	// Kita butuh prime checker
	// Kita butuh pembalik digit
	public static void main(String[] args) {
		int count = 1;
		// ! Loop untuk mencetak 100 bilangan prima palindromik
		for (long p = 1; count <= 100; p++) {
			if (isPrime(p) && isPrime(balik(p))) { // ? Jika p prima dan palindrome
				System.out.print(p + " ");
				count++;
				if (count % 10 == 0) { // ? Pindah baris jika sudah 10 bilangan
					System.out.println();
				}
			}
		}
	}

	// ! Prime checker
	static boolean isPrime(long p) {
		if (p < 2)
			return false;

		if (p == 2)
			return true; // ? 2 adalah bilangan prima pertama

		// ! Loop untuk melakukan pengecekan
		for (int divider = 2; divider <= (int) Math.pow(p, 0.5); divider++) {
			if (p % divider == 0)
				return false;
		}

		return true;
	}

	// ! Pembalik digit
	static long balik(long p) {
		if (p < 10)
			return p;

		long balik = 0;
		while (p != 0) {
			long sisa = p % 10;
			balik = 10 * balik + sisa;
			p = p / 10;
		}

		return balik;
	}
}