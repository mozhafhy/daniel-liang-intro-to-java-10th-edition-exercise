/*
 * Financial tsunami
 * Bank meminjamkan uang ke bank lain. Pada situasi ekonomi yang sulit, jika
 * bank mengalami kebangkrutan, bank mungkin tidak dapat membayar pinjaman. Jika
 * total aset bank adalah:
 * Total aset = Saldo saat ini + Pinjaman yang diberikan ke bank lain
 * 
 * Jika total aset bank ada dibawah limit tertentu, bank dinyatakan unsafe
 * (tidak aman). Uang yang
 * di pinjam tidak dapat dikembalikan ke pemberi pinjaman, dan pemberi pinjaman
 * tidak dapat menghitung pinjaman tersebut di toal aset. Sehingga, pemberi
 * pinjaman dapat menjadi unsafe, jika total aset nya berada di bawah limit.
 * 
 * Program akan mendapat input
 * n limit
 * balance lenderBanksCount (borrowerId borrowAmount)...
 * ...
 * 
 * akan terdapat sebanyak n bank dengan id 0 hingga (n-1)
 * 
 * Program akan memberi output
 * Unsafe banks are bank1 bank2 ... bankN
 */

/*
 * indeks dari array bank adalah id dari bank tersebut.
 * bankAssets -> node
 * areUnsafeBanks
 * lendingEdges ([lender, borrower]) -> Edge
 * lendingAmounts -> Edge Weight
 * 
 * 
 */

import java.util.Scanner;

class lat8_17 {
	static String output = "Unsafe banks are "; // output dari program
	static int n; // jumlah bank
	static double limit; // limit minimum total aset bank
	static double[] bankAssets; // array dari total aset bank

	/** array untuk menandai unsafe bank, true -> unsafe, false -> safe */
	static boolean[] areUnsafeBanks;

	/** array untuk menyimpan jumlah pinjaman lendingAmount[lender][borrower] */
	static double[][] lendingAmounts;

	public static void main(String[] args) {
		readInput();

		while (true) {
			int targetId = getOneUnmarkedUnsafeBankId(); // cari 1 bank yang dinilai unsafe

			/** hentikan loop jika tidak ditemukan bank yang unsafe */
			if (targetId == -1)
				break;

			markUnsafeBank(targetId); // tandai bank sebagai unsafe
			output += targetId + " "; // tambahkan id bank ke output

			/** cari bank yang menjadi pemberi pinjaman (lender) ke bank target */
			for (int lenderId = 0; lenderId < n; lenderId++) {
				double lendingAmount = lendingAmounts[lenderId][targetId]; // dapatkan jumlah pinjaman
				reduceBankAsset(lenderId, lendingAmount); // kurangi aset lender sebanyak yang dipinjamkan
			}
		}

		/** tamilkan output program */
		System.out.println(output);
	}

	/** method untuk membaca input */
	static void readInput() {
		Scanner input = new Scanner(System.in);

		n = input.nextInt(); // mmembaca n dari input
		limit = input.nextDouble(); // mmembaca limit dari input

		/** inisialisasi array untuk penyimpanan data */
		bankAssets = new double[n];
		areUnsafeBanks = new boolean[n];
		lendingAmounts = new double[n][n];

		/** loop dari 0 hingga (n-1) untuk mendapatkan detail dari setiap bank */
		for (int bankId = 0; bankId < n; bankId++) {
			double balance = input.nextDouble(); // mmembaca balance bank ke bankId dari input
			bankAssets[bankId] = balance; // menyimpan balance ke array

			int borrowerCount = input.nextInt(); // mmembaca jumlah peminjam dari input
			for (int j = 0; j < borrowerCount; j++) {
				int borrowerId = input.nextInt(); // mmembaca id bank peminjam dari input
				double borrowAmount = input.nextDouble(); // membaca jumlah pinjaman dari input

				lendingAmounts[bankId][borrowerId] = borrowAmount; // mencatat jumlah pinjaman

				bankAssets[bankId] += borrowAmount; // total aset = balance + pinjaman ke bank lain
			}
		}

		input.close(); // tutup scanner untuk membebaskan resource
	}

	/**
	 * method untuk mendapatkan 1 id bank yang dinilai unsafe namun belum tercatat
	 * pada array
	 */
	static int getOneUnmarkedUnsafeBankId() {
		for (int bankId = 0; bankId < n; bankId++) {
			/** lewati jika bank sudah tercatat unsafe */
			if (areUnsafeBanks[bankId])
				continue;

			/** lewati jika bank dinilai safe */
			if (!checkIsBankUnsafe(bankId))
				continue;

			return bankId;
		}

		/** kembalikan -1 jika tidak ada bank yang dinilai unsafe */
		return -1;
	}

	/** method untuk mencatat bank yang dinilai unsafe pada array */
	static void markUnsafeBank(int bankId) {
		areUnsafeBanks[bankId] = true;
	}

	/** method untuk mengurangi aset bank */
	static void reduceBankAsset(int bankId, double amount) {
		bankAssets[bankId] -= amount;
	}

	/** method untuk memeriksa apakah bank dinilai unsafe */
	static boolean checkIsBankUnsafe(int bankId) {
		return bankAssets[bankId] < limit;
	}
}