/*
 * Hitung UKT setelah 10 tahun jika tahun ini adalah $10,000 dan naik
 * 5% tiap tahun, lalu hitung jumlah UKT 4 tahun setelah tahun ke-10
*/

public class lat5_7_$$done {
	public static void main(String[] args) {
		double tuition = 10000; //* Nilai awal UKT
		final double ANNUAL_INCREASE_RATE = 0.05; //* Persen peningkatan UKT tiap tahun
		int year = 10; //* Banyak tahun untuk UKT pada tahun ke-10

		for (int i = 0; i < year; i++) { // Loop untuk menghitung UKT setalah 10 tahun
			tuition *= 1 + ANNUAL_INCREASE_RATE; // Untuk menjumlahkan UKT dengan nilai peningkatannya
		}

		//! Sekarang, nilai var 'tuition' adalah UKT pada tahun ke-10, bukan lagi 10000
		double sumTuition = 0;
		year = 4; //* Banyak tahun untuk total UKT 4 tahun setelah tahun ke-10
		for (int i = 0; i < year; i++) { // Loop untuk menghitung total UKT 4 tahun setalah tahun ke-10
			tuition *= 1 + ANNUAL_INCREASE_RATE;
			sumTuition += tuition; // Jumlahkan semua UKT di keempat tahun tersebut
		}

		System.out.printf("Your tuition in ten years is $%,.2f\n", tuition);
		System.out.printf("Your total cost of four years\' worth of tuition after the tenth year is $%,.2f", sumTuition);
	}
}