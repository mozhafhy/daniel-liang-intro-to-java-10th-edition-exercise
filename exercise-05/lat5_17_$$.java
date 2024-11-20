/* 
 * Buat pola piramida angka seperti ini:
 * Enter the number of lines: 7 << input
 * 							1
 *            2 1 2
 *          3 2 1 2 3
 *        4 3 2 1 2 3 4
 *      5 4 3 2 1 2 3 4 5
 *    6 5 4 3 2 1 2 3 4 5 6
 *  7 6 5 4 3 2 1 2 3 4 5 6 7
*/

import java.util.Scanner;

public class lat5_17_$$ {
	/*
	 * Piramida itu terdiri dari dua bagian, yaitu:
	 * 			Bagian 1							Bagian 2
	 * 							1
	 *            2 1 					2
	 *          3 2 1 					2 3
	 *        4 3 2 1 					2 3 4
	 *      5 4 3 2 1 					2 3 4 5
	 *    6 5 4 3 2 1 					2 3 4 5 6
	 *  7 6 5 4 3 2 1 					2 3 4 5 6 7
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of lines: ");
		int n = in.nextInt(); //* Minta user untuk memasukkan banyak baris dari piramida

		//* Cetak piramida
		for (int i = 0; i < n; i++) {
			//* Cetak bagian 1
			for (int j = 0; j < n; j++) {
				if (j < n - 1 - i) { //* Cetak spasi
					System.out.print("  ");
				} else {
					System.out.printf("%d ", n - j);
				}
			}

			//* Cetak bagian 2
			for (int j = 0; j < i; j++) {
				System.out.printf("%d ", j + 2); //* +2 karena kita mau j mulai dari 2, bukan 0
			}
			System.out.println(); //* Pindah baris
		}

		in.close();
	}
}