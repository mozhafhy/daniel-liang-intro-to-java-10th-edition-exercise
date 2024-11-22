// ! Makasih banyak, Bang Fazle :D
/*
 * Card card number validation
 * Nomor kartu kredit mengikuti pola tertentu. Subuah nomor kartu kredit harus
 * memiliki 13 - 16 digit dan harus dimulai dengan:
 * 1. 4 untuk Visa Cards
 * 2. 5 untuk Master Cards
 * 3. 37 untuk American Express Cards
 * 4. 6 untuk Discover Cards
 * 
 * Pada 1954, Hans Luhn (IBM) mengajukan algoritma untuk validasi nomor kartu
 * kredit. Algoritma ini berguna untuk menentukan apakah nomor kartu kredit
 * dimasukkan atau terbaca dengan benar. Nomor kartu kredit dibuat mengikuti
 * pemeriksaan validasi ini, yang dikenal dengan Luhn Check atau Mod 10 Check.
 * 
 * Luhn Check:
 * misal: 4388576018402626
 * ---
 * 1. Gandakan setiap angka kedua dari kanan ke kiri dan jumlahkan angka pertama
 * dan angka kedua dari hasil penggandaan.
 * 
 * (4)3(8)8(5)7(6)0(1)8(4)0(2)6(2)6
 * 4, 4, 8, 2, 3, 1, 7, 8
 * 
 * ---
 * 2. Jumlahkan semua angka dari langkah 1.
 * 4 + 4 + 8 + 2 + 3 + 1 + 7 + 8 = 37
 * 
 * ---
 * 3. Jumlahkan semua angka dengan indeks ganjil dari kanan ke kiri.
 * 4(3)8(8)5(7)6(0)1(8)4(0)2(6)2(6)
 * 6 + 6 + 0 + 8 + 0 + 7 + 8 + 3 = 38
 * 
 * ---
 * 4. Jumlahkan hasil dari langkah 2 dan 3.
 * 37 + 38 = 75
 * 
 * ---
 * 5. Jika hasil dari langkah 4 habis dibagi 10 maka nomor tersebut valid. Jika
 * tidak, nomor tersebut tidak valid.
 * 75 % 10 != 0 => 4388576018402626 bukan nomor kartu kredit yang valid
 * 
 * Contoh valid: 4388576018410707
 */

 import java.util.Scanner;

 public class lat6_31_$$Fazle {
	 /**
		* list prefix yang valid, di deklarasikan dengan keyword final untuk membuat
		* konstanta karena prefix tidak boleh dan tidak akan diubah pada program
		*/
	 static final int VISA_PREFIX = 4;
	 static final int MASTERCARD_PREFIX = 5;
	 static final int AMERICAN_XP_PREFIX = 37;
	 static final int DISCOVER_PREFIX = 6;
 
	 public static void main(String[] args) {
		 System.out.println("Enter a credit card number as a long integer:");
 
		 /** membaca nomor kartu dari input */
		 Scanner input = new Scanner(System.in);
		 long number = input.nextLong();
		 input.close();
 
		 /** output akhir dari program */
		 if (isValid(number)) {
			 System.out.println(number + " is valid");
		 } else {
			 System.out.println(number + " is invalid");
		 }
	 }
 
	 /** mengembalikan true apabila nomor kartu valid */
	 public static boolean isValid(long number) {
		 /**
			* langkah 1:
			* Memeriksa apakah nomor kartu memiliki angka depan yang valid.
			* Angka yang valid adalah 4, 5, 37, 6.
			* Jika tidak, kembalikan false.
			*/
		 if (!prefixMatched(number, VISA_PREFIX) &&
				 !prefixMatched(number, MASTERCARD_PREFIX) &&
				 !prefixMatched(number, AMERICAN_XP_PREFIX) &&
				 !prefixMatched(number, DISCOVER_PREFIX)) {
			 return false;
		 }
 
		 /** langkah 2 */
		 int a = sumOfDoubleEvenPlace(number);
 
		 /** langkah 3 */
		 int b = sumOfOddPlace(number);
 
		 /** langkah 4 */
		 int sum = a + b;
 
		 /** langkah 5 */
		 return sum % 10 == 0;
	 }
 
	 /** Mendapatkan hasil dari langkah 2 */
	 public static int sumOfDoubleEvenPlace(long number) {
		 int sum = 0;
 
		 number /= 10; // hilangkan 1 angka paling kanan
		 while (number > 0) {
			 int digit = (int) (number % 10) * 2; // ambil 1 angka paling kanan lalu kalikan 2
			 number /= 100; // hilangkan 2 angka paling kanan
			 sum += getDigit(digit); // tambahkan `sum` dengan penjumlahan 2 angka pada bilangan `digit`
		 }
 
		 return sum;
	 }
 
	 /**
		* Mengembalikan penjumlahan dari angka pertama dan kedua dari bilangan dengan
		* dua angka
		*/
	 public static int getDigit(int number) {
		 return number > 9 ? number - 9 : number;
	 }
 
	 /** Mengembalikan penjumlahan dari angka dengan posisi ganjil (langkah 3) */
	 public static int sumOfOddPlace(long number) {
		 int sum = 0;
 
		 while (number > 0) {
			 int digit = (int) (number % 10); // ambil 1 angka palig kanan
			 number /= 100; // hilangkan 2 angka paling kanan
			 sum += digit; // tambahkan `sum` dengan bilangan `digit`
		 }
 
		 return sum;
	 }
 
	 /** Mengembalikan true apabila angka `d` adalah sebuah prefix untuk `number` */
	 public static boolean prefixMatched(long number, int d) {
		 int prefixSize = getSize(d); // cari panjang prefix `d`
		 int prefix = (int) getPrefix(number, prefixSize); // ambil `prefixSize` angka pertama pada `number`
		 return prefix == d; // apakah prefix sama dengan d? true atau false
	 }
 
	 /** Mengembalikan jumlah angka pada suatu bilangan */
	 public static int getSize(long d) {
		 int size = 0; // jumlah angka pada bilangan `d`
 
		 /** loop berjalan hingga d tidak memiliki angka yang tersisa */
		 while (d > 0) {
			 d /= 10; // hilangkan 1 angka paling kanan pada `d`
			 size++; // naikkan jumlah angka
		 }
 
		 return size;
	 }
 
	 /**
		* Mengembalikan k angka pertama dari bilangan. Jika jumlah angka kurang dari
		* `k`, kembalikan bilangan tersebut
		*/
	 public static long getPrefix(long number, int k) {
		 int prefixSize = getSize(k); // cari panjang prefix (`k`)
		 int numberSize = getSize(number); // cari panjang `number`
 
		 /** hilangkan (`numberSize` - `prefixSize`) angka paling kanan */
		 long divider = (long) Math.pow(10, numberSize - prefixSize);
		 return number / divider;
	 }
 
 }