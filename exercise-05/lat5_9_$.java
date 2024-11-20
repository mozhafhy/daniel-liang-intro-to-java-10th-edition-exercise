/*
 * Buat program yang meminta user untuk memasukkan banyak siswa,
 * nama siswa, dan nilainya, lalu tampilkan siswa dengan nilai
 * tertinggi pertama dan kedua
 */

import java.util.Scanner;

public class lat5_9_$ {
	//! Eksperimen dengan ANSI escape code
	static final String RESET = (char) 27 + "[0m";
	static final String YELLOW = (char) 27 + "[33m";
	static final String GREEN = (char) 27 + "[32m";
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int nilaiRank1 = 0;
		int nilaiRank2 = 0;

		String namaRank1 = null;
		String namaRank2 = null;

		int n = in.nextInt(); // * Banyak siswa
		for (int i = 0; i < n; i++) { // * Loop untuk memasukkan nama dan nilai siswa
			in.nextLine();
			System.out.printf("Enter student %d\'s name : ", i + 1);
			String nama = in.nextLine();

			System.out.printf("Enter student %d\'s score: ", i + 1);
			int nilai = in.nextInt();

			System.out.println();

			// * Algoritma untuk menukar nilaiRank1 dan nilaiRank2, namaRank1 dan namaRank2
			int tempNilai = nilaiRank1;
			String tempNama = namaRank1;
			// Jika nilai yang dimasukkan > nilaiRank1, ganti nilaiRank1 dengan nilai dan nilaiRank2 dengan tempNilai
			if (nilai > nilaiRank1) {
				nilaiRank1 = nilai;
				nilaiRank2 = tempNilai;

				namaRank1 = nama;
				namaRank2 = tempNama;
			} else if (nilai > nilaiRank2) {
				namaRank2 = nama;
				nilaiRank2 = nilai;
			}
		}
		System.out.printf("#1 student by score is %s%s%s, with a score of %s%d%s\n", YELLOW, namaRank1, RESET, GREEN, nilaiRank1, RESET);
		System.out.printf("#2 student by score is %s%s%s, with a score of %s%d%s\n", YELLOW, namaRank2, RESET, GREEN, nilaiRank2, RESET);

		in.close();
	}
}