/*
 * Buat program yang meminta user memasukkan tahun dan hari pertama
 * dalam tahun itu, lalu tampilkan hari pertama setiap bulan dalam
 * tahun tersebut.
 * 
 * Contoh:
 * input << 2013 2
 * output >>
 *   January 1, 2013 is Tuesday
 * 	 ...
 *   December 1, 2013 is Sunday
 */

import java.util.Scanner;

public class lat5_28_$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter year: ");
		int year = in.nextInt();

		System.out.print("Enter the first day of the year: ");
		int startDay = in.nextInt();

		int numOfDaysInMonth = 0; // ini hanya inisialisasi
		for (int month = 1; month <= 12; month++) {
			// * seleksi untuk mengecek bulan
			switch (month) {
				case 1 -> {
					numOfDaysInMonth = 31;
					System.out.print("January 1, " + year + " is ");
				}
				case 2 -> {
					System.out.print("February 1, " + year + " is ");
					// cek apakah termasuk leap year atau bukan
					if (year % 400 != 0 && year % 100 != 0 && year % 4 != 0) {
						numOfDaysInMonth = 28;
					} else {
						numOfDaysInMonth = 29;
					}
				}
				case 3 -> {
					numOfDaysInMonth = 31;
					System.out.print("March 1, " + year + " is ");
				}
				case 4 -> {
					numOfDaysInMonth = 30;
					System.out.print("April 1, " + year + " is ");
				}
				case 5 -> {
					numOfDaysInMonth = 31;
					System.out.print("May 1, " + year + " is ");
				}
				case 6 -> {
					numOfDaysInMonth = 30;
					System.out.print("June 1, " + year + " is ");
				}
				case 7 -> {
					numOfDaysInMonth = 31;
					System.out.print("July 1, " + year + " is ");
				}
				case 8 -> {
					numOfDaysInMonth = 31;
					System.out.print("August 1, " + year + " is ");
				}
				case 9 -> {
					numOfDaysInMonth = 30;
					System.out.print("September 1, " + year + " is ");
				}
				case 10 -> {
					numOfDaysInMonth = 31;
					System.out.print("October 1, " + year + " is ");
				}
				case 11 -> {
					numOfDaysInMonth = 30;
					System.out.print("November 1, " + year + " is ");
				}
				case 12 -> {
					numOfDaysInMonth = 31;
					System.out.print("December 1, " + year + " is ");
				}
			}

			// * seleksi untuk mengecek hari
			switch (startDay) {
				case 0 -> {
					System.out.println("Sunday");
				}
				case 1 -> {
					System.out.println("Monday");
				}
				case 2 -> {
					System.out.println("Tuesday");
				}
				case 3 -> {
					System.out.println("Wednesday");
				}
				case 4 -> {
					System.out.println("Thursday");
				}
				case 5 -> {
					System.out.println("Friday");
				}
				case 6 -> {
					System.out.println("Saturday");
				}
			}

			startDay = (startDay + numOfDaysInMonth) % 7; // * hari pertama bulan berikutnya
		}

		in.close();
	}
}