/*
 * Cari FPB dari dua bilangan n1 dan n2
 */

import java.util.Scanner;

public class lat5_14_$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int d = Math.min(n1, n2); //* Untuk mencari minimum dari n1 dan n2
		/*
		 * Motivasi:
		 * FPB dari n1 dan n2 adalah sebuah bilangan asli d terbesar yang habis membagi n1 dan n2.
		 * FPB dapat dicari secara iteratif sedemikian sehingga d habis membagi n1 dan n2
		 * Caranya adalah dengan mengecek apakah ada di antara bilangan-bilangan asli k, k-1, k-2, ..., 2, 1
		 * yang habis membagi n1 dan n2.
		 * d adalah bilangan pertama dari barisan tersebut yang habis membagi n1 dan n2.
		 */

		while (!(n1 % d == 0 && n2 % d == 0)) { // Cek terus sampai d habis membagi n1 dan n2
			d--;
		}
		// Cetak d-nya
		System.out.printf("The GCD of %d and %d is %d", n1, n2, d);
		in.close();
	}
}