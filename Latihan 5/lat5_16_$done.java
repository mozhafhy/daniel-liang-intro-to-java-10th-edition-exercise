/*
 * Cari semua faktor terkecil dari sebuah bilangan yang dimasukkan user, lalu cetak
 * dengan urutan dari yang terkecil hingga terbesar.
 * ex:
 * input << 120
 * output >> 2, 2, 2, 3, 5
 */

import java.util.Scanner;

public class lat5_16_$done {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int num = in.nextInt();

		String result = "";
		int divisor = 2;
		//* Karena jika num > 0, 1 berarti masih memenuhi, tetapi tidak memenuhi kondisi if
		//* Akibatnya, num = num / divisor tidak akan dijalankan sehingga nilai num tetap 1
		//* sehingga loop tidak akan pernah berhenti (dan divisor akan terus ditambah 1)
		while (num > 1) { 
			if (num % divisor == 0) {
				result += divisor + ", ";
				num = num / divisor;
			} else {
				divisor++;
			}
		}
		System.out.println(result + "\b\b.");

		in.close();
	}
}