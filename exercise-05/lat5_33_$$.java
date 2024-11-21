/*
 * Perfect number adalah bilangan yang sama dengan jumlah faktor-faktor positifnya
 * selain dirinya. Ada 4 perfect number yang kurang 10000, temukan semuanya.
 */

public class lat5_33_$$ {
	// kita butuh loop untuk mencari semua faktor positif dari num
	// kita butuh loop untuk mencari semua perfect number unutk num = [1, 10000]
	public static void main(String[] args) {
		
		// * Loop untuk mencari semua perfect number <= 10000
		System.out.println("All perfect numbers less than " + 10000 + " are:");
		for (int num = 1; num <= 10000; num++) {
			int factorSum = 0;
			// * Loop untuk mencari semua faktor positif dari num dan menjumlahkanya
			for (int divider = 2; divider <= num; divider++) {
				if (num % divider == 0) {
					factorSum += num / divider;
				}
			}
			if (factorSum == num) {
				System.out.printf("%d ", num);
			}
		}
	}
}