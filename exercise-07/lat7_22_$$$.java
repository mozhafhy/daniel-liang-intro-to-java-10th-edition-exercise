/*
(Game: Eight Queens) The classic Eight Queens puzzle is to place eight queens
on a chessboard such that no two queens can attack each other (i.e., no two queens
are on the same row, same column, or same diagonal). There are many possible
solutions. 
 */

public class lat7_22_$$$ {
	static int[] queenRows = new int[8];
	static int[] queenCols = new int[8];

	public static void main(String[] args) {
		// initiate with -1 for no position yet
		for (int i = 0; i < args.length; i++) {
			queenRows[i] = -1;
			queenCols[i] = -1;
		}

		solverLoop: for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (putQueen(0, i, j)) {
					System.out.println("solved");
					break solverLoop;
				}
			}
		}

		// display solution
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (isQueenExist(i, j))
					System.out.print("Q ");
				else
					System.out.print(". ");
			}
			System.out.println();
		}

		for (int i = 0; i < 8; i++) {
			System.out.print(queenCols[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < 8; i++) {
			System.out.print(queenRows[i] + " ");
		}
	}

	static boolean putQueen(int i, int row, int col) {
		// stop if 8 queen exist
		if (i == 8)
			return true;

		// change this queen position
		queenCols[i] = col;
		queenRows[i] = row;

		// go back if the current queen position is invalid
		if (!isQueenValid(i)) {
			queenCols[i] = -1;
			queenRows[i] = -1;
			return false;
		}

		// get position for the new queen
		for (int j = 0; j < 8; j++) {
			for (int k = 0; k < 8; k++) {
				if (putQueen(i + 1, j, k))
					return true;
			}
		}

		return false;
	}

	static boolean isQueenValid(int queenIndex) {
		// check cols: no queen can be on the same col
		for (int i = 0; i < 8; i++) {
			if (i != queenIndex && queenCols[i] == queenCols[queenIndex])
				return false;
		}

		// check rows: no queen can be on the same row
		for (int i = 0; i < 8; i++) {
			if (i != queenIndex && queenRows[i] == queenRows[queenIndex])
				return false;
		}

		// check diagonal and antidiagonal
		for (int i = 0; i < 8; i++) {
			// avoid checking self or unset quen
			if (i == queenIndex || queenCols[i] == -1 || queenRows[i] == -1) {
				continue;
			}

			int x = queenCols[queenIndex];
			int y = queenRows[queenIndex];
			int p = queenCols[i];
			int q = queenRows[i];

			// if (p - q == x - y || p + q == x + y) {
			// return false;
			// }
			if (Math.abs(x - p) == Math.abs(y - q)) {
				return false;
			}
		}

		return true;
	}

	static boolean isQueenExist(int row, int col) {
		for (int i = 0; i < 8; i++) {
			if (queenRows[i] == row && queenCols[i] == col)
				return true;
		}

		return false;
	}
}