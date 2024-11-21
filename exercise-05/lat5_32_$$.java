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

		int lottery = random.nextInt(1, 10);
		
	}
}