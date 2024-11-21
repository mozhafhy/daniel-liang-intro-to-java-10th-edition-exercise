/*
* (Emirp) An emirp (prime spelled backward) is a nonpalindromic prime number 
* whose reversal is also a prime. For example, 17 is a prime and * 71 is a prime,
* so 17 and 71 are emirps. Write a program that displays the first 100 emirps.
* Display 10 numbers per line, separated by exactly one space, as follows:
*
* 13 17 31 37 71 73 79 97 107 113
* 149 157 167 179 199 311 337 347 359 389
* ...
*/

public class lat6_27_$$ {
	public static void main(String[] args) {
		int count = 0; // * Variabel yang digunakan untuk menghitung ada berapa banyak emirp yang dicetak
		for (int i = 10; count < 100; i++) {
			// * Seleksi yang mengharuskan i merupakan bilangan prima, bukan palindrome, dan masih prima 
			// * jika digit-digitnya dibalik
			if (isPrime(i) && !isPalindrome(i) && isPrime(reverse(i))) {
				System.out.printf("%10d", i); // * Hanya cetak i yang merupakan emirp
				count++;
				if (count % 10 == 0 && i != 0) // * pindah baris
					System.out.println();
			}
		}
	}

	// * Method untuk mengecek apakah suatu bilangan n merupakan prima atau bukan
	static boolean isPrime(int n) {
		int i;
		if (n < 2) { // * Semua bilangan yang < 2 pasti bukan prima
			return false;
		}
		// * Loop untuk menguji apakah n habis dibagi oleh bilangan 2, 3, 4, ..., sqrt(n)
		// ! Saya tidak tahu persis mengapa batas atas sqrt(n) dipakai, yang jelas, ini hanya untuk optimasi saja
		for (i = 2; i <= (int) (Math.sqrt(n)); i++) {
			if (n % i == 0) {
				break; // * Jika n habis dibagi i, keluar dari loop
			}
		}
		// * Jika i masih kurang dari sqrt(n), artinya n komposit karena ada bilangan k < sqrt(n) yang habis membaginya
		if (i < (int) (Math.sqrt(n)))
			return false;
		else
			return true;
		/*
		 * false berarti n bukan prima; true berarti n prima
		*/
	}

	// * Method untuk membalik digit-digit n (123 menjadi 321 misalnya)
	static int reverse(int n) {
		int reverse = 0;
		while (n != 0) {
			int sisa = n % 10; // * Kita ambil satu-satu digit n
			reverse = reverse * 10 + sisa;
			n = n / 10; // * Bagi dengan 10 agar bisa mengambil digit berikutnya
		}
		return reverse;
	}

	// * Method untuk mengecek apakah n merupakan palindrome atau bukan
	static boolean isPalindrome(int n) {
		return (reverse(n) == n);
	}
}