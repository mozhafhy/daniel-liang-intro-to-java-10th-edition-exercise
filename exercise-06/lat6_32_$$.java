/*
 * Mainkan lat6_30 10000 kali dan tunjukkan berapa kali kemenangan yang didapat.
 */

import java.util.Random;

public class lat6_32_$$ {
	static Random random = new Random();

	public static void main(String[] args) {
		int countWins = 0;
		int countLose = 0;

		// * Loop untuk menghitung banyak kemenangan dan kekalahan
		for (int turns = 0; turns < 10000; turns++) {
			if (board()) {
				countWins++;
			} else {
				countLose++;
			}
		}

		System.out.println("Number of winning games: " + countWins);
		System.out.println("Number of losing games : " + countLose);
		System.out.printf("Probability to win     : %.2f%\u0025", 100.0 * countWins / (countLose + countWins));
	}

	// * Default craps board
	static boolean board() {
		int poin = 0;
		while (true) { // user akan terus main sampai menang/kalah
			int die1 = random.nextInt(0, 6) + 1;
			int die2 = random.nextInt(0, 6) + 1;

			switch (die1 + die2) {
				case 2, 3, 12 -> {
					return false;
				}
				case 7, 11 -> {
					return true;
				}
				default -> {
					poin = die1 + die2;
					return specialBoard(poin);
				}
			}
		}
	}

	/** Extended craps board -> masuk ke sini jika pada roll pertama, jumlah mata dadu
	 *  tidak sama dengan 2, 3, 7, 11, 12
	*/
	static boolean specialBoard(int poin) {
		while (true) { // user akan terus main sampai menag/kalah
			int die1 = random.nextInt(0, 6) + 1;
			int die2 = random.nextInt(0, 6) + 1;

			if (die1 + die2 == poin) {
				return true;
			} else if (die1 + die2 == 7) {
				return false;
			} else {
				continue;
			}
		}
	}
}