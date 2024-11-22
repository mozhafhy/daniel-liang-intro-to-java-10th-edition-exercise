/*
 * Cari semua twin prime kurang dari 1000. Tampilkan sebagai berikut.
 * (3, 5)
 * (5, 7)
 * ...
 */

public class lat6_29_$$ {
	public static void main(String[] args) {
		for (int p = 1; p < 1000; p++) {
			if (isPrime(p) && isPrime(p + 2)) {
				System.out.printf("(%d, %d)\n", p, p + 2);
			}
		}
	}

	// ! Prime checker
	static boolean isPrime(int p) {
		if (p < 2)
			return false;

		if (p == 2)
			return true;

		for (int divider = 2; divider <= (int) Math.pow(p, 0.5); divider++) {
			if (p % divider == 0)
				return false;
		}

		return true;
	}
}