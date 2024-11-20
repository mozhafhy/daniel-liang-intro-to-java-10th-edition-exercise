/*
 * Tampilkan semua leap year dalam periode tahun 101 - 2100.
 * Tampilkan 10 tahun tiap barisnya dan pisah oleh tepat satu
 * spasi. Tampilkan juga total leap year dalam periode tersebut.
 */

public class lat5_27_$$ {
	public static void main(String[] args) {
		int countLeapYears = 0; // 0 berarti belum ada leap year

		// * Buat loop untuk menampilkan leap year
		for (int year = 101; year <= 2100; year++) {
			// Leap year adalah tahun di mana banyak hari dalam bulan Februari = 29
			// Leap year terjadi jika tahunnya habis dibagi 4 dan tidak habis dibagi 100
			// atau habis dibagi 400.
			// ex: 2000 adalah leap year, tetapi 2100 bukan leap year
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				System.out.print(year + " ");
				countLeapYears++; // +1 tiap 'year' adalah leap year

				// pindah baris jika banyak leap year yang dicetak dalam 1 baris = 10
				if (countLeapYears % 10 == 0) {
					System.out.println();
				}

			}
		}
		System.out.println();
		System.out.println("The numbers of leap year in the period of year 101 to 2100 is " + countLeapYears);
	}
}