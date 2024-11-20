/*
 * Buat piramida angka berikut
 *                             1
 *                         1   2   1
 *                     1   2   4   2   1
 *                 1   2   4   8   4   2   1
 *             1   2   4   8  16   8   4   2   1
 *     		 1   2   4   8  16  32  16   8   4   2   1
 *     1   2   4   8  16  32  64  32  16   8   4   2   1
 * 1   2   4   8  16  32  64 128  64  32  16   8   4   2   1
 */

import java.util.Scanner;

public class lat5_19_$$done {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();

    for (int i = 0; i < n; i++) {
      int m = 1;
			//* Bagian 1
      for (int j = 0; j < n; j++) {
        if (j < n - i - 1) {
          System.out.printf("%4s", "");
          continue;
        }
        System.out.printf("%4s", m);
        m = m * 2; // Kali dua untuk bilangan 2^m berikutnya
      }
			//* Bagian 2
      for (int j = 0; j < i; j++) {
        m = m / 2; // Bagi 2 agar kembali ke nilai m awal
        System.out.printf("%4d", m / 2); // Bagi 2 lagi
      }
      System.out.println();
    }
  }
}