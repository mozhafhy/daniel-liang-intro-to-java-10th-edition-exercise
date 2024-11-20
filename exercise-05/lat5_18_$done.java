/*
 * Buat 4 pola segitiga angka
 * Pattern A 					Pattern B 			Pattern C 			Pattern D
 * 1			 					1 2 3 4 5 6 							1	 		1 2 3 4 5 6
 * 1 2 							1 2 3 4 5			 					2 1	 			1 2 3 4 5
 * 1 2 3 						1 2 3 4 							3 2 1		 			1 2 3 4
 * 1 2 3 4 					1 2 3 							4 3 2 1	 					1 2 3
 * 1 2 3 4 5 				1 2 							5 4 3	2 1	 						1 2
 * 1 2 3 4 5 6 			1		 						6 5 4 3 2 1	 							1

 */

import java.util.Scanner;

public class lat5_18_$done {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		//* Cetak pola
		patternA(n);
		patternB(n);
		patternC(n);
		patternD(n);

		in.close();
	}

	//! Pattern A
	static void patternA(int n) {
		System.out.println("Pattern A");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.printf("%d ", j + 1);
			}
			System.out.println();
		}
		System.out.println();
	}

	//! Pattern B
	static void patternB(int n) {
		System.out.println("Pattern B");
		for (int i = 0; i < n; i++) {
			for (int j = n; j > i; j--) {
				System.out.printf("%d ", n + 1 - j);
			}
			System.out.println();
		}
		System.out.println();
	}

	//! Pattern C
	static void patternC(int n) {
		System.out.println("Pattern C");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j < n - 1 - i) {
					System.out.print("  ");
				} else {
					System.out.printf("%d ", n - j);
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	//! Pattern D
	static void patternD(int n) {
		System.out.println("Pattern D");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j < i) {
					System.out.print("  ");
				} else {
					System.out.printf("%d ", j + 1);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}