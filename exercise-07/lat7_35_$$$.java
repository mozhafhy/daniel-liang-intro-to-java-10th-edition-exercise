/*
(Game: hangman) Write a hangman game that randomly generates a word and
prompts the user to guess one letter at a time, as shown in the sample run. Each
letter in the word is displayed as an asterisk. When the user makes a correct
guess, the actual letter is then displayed. When the user finishes a word, display the number of misses and ask the user whether to continue to play with another
word. Declare an array to store words
 */

import java.util.Scanner;

public class lat7_35_$$$ {
	static String[] words = { "write", "that" };
	static String displayString = "";
	static String answerString = "";
	static int numOfMisses = 0;

	public static void main(String[] args) {
		setupGame();
		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.printf("(Guess) Enter a letter in word %s > ", displayString);
			char letter = in.next().charAt(0);
			reveal(letter);

			if (isDone()) {
				System.out.printf("The word is program. You missed %d time%n", numOfMisses);
				System.out.print("Do you want to guess another word? Enter y or n> ");
				char answer = in.next().charAt(0);
				if (answer == 'y')
					setupGame();
				else
					break;
			}
		}
	}

	static void setupGame() {
		// select random word as the answer
		answerString = words[(int) (words.length * Math.random())];
		System.out.println(answerString);
		displayString = "";
		numOfMisses = 0;

		// make a display
		for (int i = 0; i < answerString.length(); i++) {
			displayString += "*";
		}
	}

	// check is game done
	static boolean isDone() {
		for (int i = 0; i < displayString.length(); i++) {
			if (displayString.charAt(i) == '*')
				return false;
		}

		return true;
	}

	// reveal letter to string
	static void reveal(char letter) {
		String newDisplayString = "";

		// reveal every letter in the
		for (int i = 0; i < answerString.length(); i++) {
			if (displayString.charAt(i) == letter) {
				// letter already revealed
				System.out.printf("%c is already in the word%n", letter);
				return;
			} else if (displayString.charAt(i) != '*') {
				// letter already revealed but not the target letter
				newDisplayString += displayString.charAt(i);
			} else if (answerString.charAt(i) == letter) {
				// letter not revealed yet
				newDisplayString += answerString.charAt(i);
			} else {
				// no match
				newDisplayString += '*';
			}
		}

		if (displayString.equals(newDisplayString)) {
			System.out.printf("%c is not in the word%n", letter);
		}

		displayString = newDisplayString;
	}
}