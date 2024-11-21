/*
 * String permutation
 * Tulislah sebuah fungsi rekursif untuk menampilkan semua permutasi dari sebuah string.
 * Contohnya, string "abc" akan memiliki permutasi:
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 */

import java.util.Scanner;

public class lat18_25_$$ {
	public static void main(String[] args) {
		/** membaca string untuk dipermutasi dari input */
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		input.close();

		displayPermutation(s);
	}

	/** method awal untuk memulai rekursif */
	public static void displayPermutation(String s) {
		/** mulai rekursif */
		displayPermutation("", s);
	}

	/**
	 * method yang akan dipanggil secara rekursif untuk menampilkan setiap permutasi
	 * 
	 * @param s1 salah satu hasil sementara dari permutasi
	 * @param s2 karakter-karakter yang belum ditambahkan
	 */
	public static void displayPermutation(String s1, String s2) {
		/**
		 * jika tidak ada karakter yang dapat ditambahkan, permutasi selesai dan hasil
		 * ditampilkan
		 */
		if (s2.length() == 0) {
			System.out.println(s1);
			return;
		}

		/**
		 * melakukan rekursif untuk menemukan semua kemungkinan permutasi,
		 * ex: s1 = "a", s2 = "bc" (b, c)
		 * maka akan dipanggil: displayPermutation("ab", "a") &
		 * displayPermutation("ac", "b")
		 */
		for (int i = 0; i < s2.length(); i++) {
			String concated = s1 + s2.charAt(i); // hasil sementara + 1 karakter yang belum ditambahkan

			/** hilangkan karakter yang sudah ditambahkan untuk pemanggilan berikutnya */
			String unused = s2.substring(0, i) + s2.substring(i + 1, s2.length());

			/** pemanggilan ulang untuk menyelesaikan rekursif */
			displayPermutation(concated, unused);
		}
	}
}