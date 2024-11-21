/*
 * Buat program lottery di mana program membuat bilangan dua digit lottery
 * secara acak. Aturannya adalah:
 * 1) Jika bilangan yang dimasukkan user == bilangan lottery, menang $10,000
 * 2) Jika semua digit yang dimasukkan user == digit bilangan lottery, tetapi
 * 		urutannya berbeda, menang $3,000
 * 3) Jika hanya 1 digit yang sama, menang $1,000
 * Digit-digit bilangan lottery harus berbeda.
 */

import java.util.Random;
import java.util.Scanner;

public class lat5_32_$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random random = new Random();

		int lotteryFirstDigit = random.nextInt(1, 10);
		int lotterySecondDigit = lotteryFirstDigit;

		// * Loop untuk membuat digit kedua lottery berbeda dari digit pertamanya
		while (lotteryFirstDigit == lotterySecondDigit) {
			lotterySecondDigit = random.nextInt(1, 10);
		}

		String lotteryNum = "" + lotteryFirstDigit + lotterySecondDigit;

		// * Seleksi input user
		System.out.print("Enter your lottery pick (two digits): ");
		int guessNum = in.nextInt();
		int firstGuessDigit = guessNum / 10;
		int secondGuessDigit = guessNum % 10;

		System.out.println("The lottery number is " + lotteryNum);

		if (guessNum == Integer.parseInt(lotteryNum)) {
			System.out.println("Exact match: you win $10,000");
		} else if (firstGuessDigit == lotterySecondDigit && secondGuessDigit == lotteryFirstDigit) {
			System.out.println("Match all digits: you win $3,000");
		} else if (firstGuessDigit == lotteryFirstDigit
				|| firstGuessDigit == lotterySecondDigit
				|| secondGuessDigit == lotteryFirstDigit
				|| secondGuessDigit == lotterySecondDigit) {
			System.out.println("Match one digit: you win $1,000");
		} else {
			System.out.println("Sorry, no match");
		}

		in.close();
	}
}