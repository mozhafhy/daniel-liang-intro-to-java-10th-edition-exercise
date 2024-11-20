/*
 * Cetak 100 karakter dimulai dari '!' sampai '~'. Cetak 10 karakter tiap barisnya
 */

public class lat5_15_$done {
	public static void main(String[] args) {
		for (char i = '!'; i <= '~'; i++) { //* char sebenarnya adalah kode hex
			System.out.printf("%c ", i);

			if (i % 10 == 0) { //* ganti baris jika banyak karakter dalam 1 baris yang dicetak sudah 10
				System.out.println();
			}
		}
	}
}