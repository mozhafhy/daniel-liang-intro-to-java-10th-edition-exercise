/*
 * Buat program permainan scissor-rock-paper. User akan terus bermain
 * dengan komputer sampai salah satu di antaranya menang lebih dari 2
 * kali.
 */

import java.util.Random;
import java.util.Scanner;

public class lat5_34_$$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random random = new Random();

		int countUserWins = 0;
		int countCompWins = 0;

		int userChoice = 0;
		int compChoice = 0;

		String userHand = "";
		String compHand = "";

		while (true) { // * While karena unconditional
			System.out.print("scissor (0), rock (1), paper (2): ");
			userChoice = in.nextInt() + 1;
			// Seleksi untuk user
			switch (userChoice) {
				case 1 -> {
					userHand = "scissor";
				}
				case 2 -> {
					userHand = "rock";
				}
				case 3 -> {
					userHand = "paper";
				}
			}
			userChoice = userChoice * 10;

			// Computer turn
			compChoice = random.nextInt(1, 4);
			// System.out.println(compChoice);
			switch (compChoice) {
				case 1 -> {
					compHand = "scissor";
				}
				case 2 -> {
					compHand = "rock";
				}
				case 3 -> {
					compHand = "paper";
				}
			}

			int pairs = userChoice + compChoice;
			switch (pairs) {
				case 21, 32, 13 -> { // ? case user menang
					System.out.printf("The computer is %s. You are %s. You won\n", compHand, userHand);
					countUserWins++;
				}
				case 12, 23, 31 -> { // ? case komputer menang
					System.out.printf("The computer is %s. You are %s. You lose\n", compHand, userHand);
					countCompWins++;
				}
				case 11, 22, 33 -> { // ? case draw
					System.out.printf("The computer is %s. You are %s too. It is a draw\n", compHand, userHand);
				}
			}

			System.out.println();
			// * Seleksi untuk menentukan kapan game berhenti
			if (countCompWins > 2 || countUserWins > 2) {
				System.out.println("Game ended! " + ((countUserWins > countCompWins) ? "You won!" : "Computer Won!"));
				break;
			}
		}

		in.close();
	}
}