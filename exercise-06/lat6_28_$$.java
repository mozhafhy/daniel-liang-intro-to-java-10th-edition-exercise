/*
 * Cari semua bilangan prima Mersenne (2^p - 1) untuk p <= 31, lalu
 * tampilkan dalam tabel seperti berikut.
 * p        2^p-1
 * ------------------
 * 2        3
 * 3        7
 * 5        31
 * ...
 */

public class lat6_28_$$ {
	// Kita butuh prime checker isPrime(int p)
	public static void main(String[] args) {
		System.out.println("p       2^p-1"); // ? header tabel
		System.out.println("-----------------");
		for (int p = 1; p <= 31; p++) {
			if (isPrime((int) Math.pow(2, p) - 1)) {
				System.out.printf("%d\t%d\n", p, (int) Math.pow(2, p) - 1);
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