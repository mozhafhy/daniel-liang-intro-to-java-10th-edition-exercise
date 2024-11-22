/*
 * Game: Craps
 * Kamu melempar 2 dadu 6 sisi. Jika jumlah mata dadunya = 2, 3, or 12,
 * kamu kalah. Jika jumlahnya 7 or 11, kamu menang. Jika jumlahnya adalah
 * nilai lainnya, sebuah poin ditentukan dan kamu lanjut bermain sampai
 * salah satu dari dua kondisi ini terjadi:
 * 1) Jumlah mata dadu = poin, kamu menang
 * 2) Jumlah mata dadu = 7, kamu kalah
 */

import java.util.Random;

public class lat6_30_$$ {
	static Random random = new Random();

	public static void main(String[] args) {
		board();
	}

	static void board() {
		int poin = 0;
		while (true) {
			int die1 = random.nextInt(0, 6) + 1;
			int die2 = random.nextInt(0, 6) + 1;

			System.out.printf("You rolled %d + %d = %d\n", die1, die2, die1 + die2);
			switch (die1 + die2) {
				case 2, 3, 12 -> {
					System.out.println("You lose");
					return;
				}
				case 7, 11 -> {
					System.out.println("You win");
					return;
				}
				default -> {
					poin = die1 + die2;
					System.out.println("point is " + poin);
					specialBoard(poin);
					return;
				}
			}
		}
	}

	static void specialBoard(int poin) {
		while (true) {
			int die1 = random.nextInt(0, 6) + 1;
			int die2 = random.nextInt(0, 6) + 1;

			System.out.printf("You rolled %d + %d = %d\n", die1, die2, die1 + die2);
			if (die1 + die2 == poin) {
				System.out.println("You win");
				return;
			} else if (die1 + die2 == 7) {
				System.out.println("You lose");
				return;
			} else {
				continue;
			}
		}
	}
}