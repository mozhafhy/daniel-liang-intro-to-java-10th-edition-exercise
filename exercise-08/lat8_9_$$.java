/*
(Game: play a tic-tac-toe game) In a game of tic-tac-toe, two players take turns
marking an available cell in a 3 * 3 grid with their respective tokens (either
X or O). When one player has placed three tokens in a horizontal, vertical, or
diagonal row on the grid, the game is over and that player has won. A draw (no
winner) occurs when all the cells on the grid have been filled with tokens and
neither player has achieved a win. Create a program for playing tic-tac-toe.
 The program prompts two players to enter an X token and O token alternately. Whenever a token is entered, the program redisplays the board on the
console and determines the status of the game (win, draw, or continue).
 */

import java.util.Scanner;

public class lat8_9_$$ {
	static char[][] board = {
			{ ' ', ' ', ' ' },
			{ ' ', ' ', ' ' },
			{ ' ', ' ', ' ' },
	};

	static char playerChar = 'X';

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (true) {
			displayBoard();

			// prompt user until a new valid position made
			while (true) {
				// prompt user to input row position
				System.out.printf("Enter a row (0, 1, or 2) for player %c: ", playerChar);
				int row = in.nextInt();
				// prompt user to input col position
				System.out.printf("Enter a column (0, 1, or 2) for player %c: ", playerChar);
				int col = in.nextInt();

				// if this position is taken, reprompt user to pick a different position
				if (board[row][col] != ' ')
					continue;

				board[row][col] = playerChar;
				break;
			}

			// stop if current turn player win
			if (isWin(playerChar)) {
				displayBoard();
				System.out.printf("%c player won%n", playerChar);
				break;
			}

			// change the turn
			playerChar = playerChar == 'X' ? 'O' : 'X';
		}

		in.close();
	}

	static void displayBoard() {
		System.out.printf("-------------%n");
		System.out.printf("| %c | %c | %c |%n", board[0][0], board[0][1], board[0][2]);
		System.out.printf("-------------%n");
		System.out.printf("| %c | %c | %c |%n", board[1][0], board[1][1], board[1][2]);
		System.out.printf("-------------%n");
		System.out.printf("| %c | %c | %c |%n", board[2][0], board[2][1], board[2][2]);
		System.out.printf("-------------%n");
	}

	static boolean isWin(char playerChar) {
		// horizontal
		rowLoop: for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != playerChar)
					continue rowLoop;
			}
			return true;
		}

		// vertical
		colLoop: for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[j][i] != playerChar)
					continue colLoop;
			}
			return true;
		}

		// diagonal tl-br
		boolean isDiagonalSuccess = true;
		for (int i = 0; i < 3; i++) {
			if (board[i][i] != playerChar) {
				isDiagonalSuccess = false;
				break;
			}
		}

		if (isDiagonalSuccess)
			return true;

		// diagonal tr-bl
		isDiagonalSuccess = true;
		for (int i = 0; i < 3; i++) {
			if (board[i][2 - i] != playerChar) {
				isDiagonalSuccess = false;
				break;
			}
		}

		if (isDiagonalSuccess)
			return true;

		return false;
	}
}