/*
 * (Print calendar) Programming Exercise 3.21 uses Zeller’s congruence to calculate
 * the day of the week. Simplify Listing 6.12, PrintCalendar.java, using Zeller’s
 * algorithm to get the start day of the month.
 * 
 * Zeller's congruence:
 * h = (q + 26(m + 1) / 10 + k + k / 4 + 5 * j) % 7
 * Variabel:
 * h >> int dayOfTheWeek
 * q >> final int dayOfTheMonth = 1
 * m >> int month -> 3 = maret, 4 = mei, ..., 12 = desember, 13 = januari, 14 = februari
 * j >> int century = int year / 100
 * k >> int yearOfCentury = int year % 100
 * 
 * Format kalender:
 *           (month) (year)
 * -----------------------------
 *  Sun Mon Tue Wed Thu Fri Sat
 *               0   0   0   0
 *   0   0   0   0   0  00  00
 *   0   0  00  00  00  00  00
 *  00  00  00  00  00  00  00
 *  00  00  00  00  00  00
 */

// Kita butuh method untuk mencari hari pertama pada bulan dan tahun yang dimaksud
// Kita butuh method untuk mencetak kalender

import java.util.Scanner;

public class lat6_34_$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter full year (e.g., 2012): ");
		int year = in.nextInt();

		System.out.print("Enter month as a number between 1 and 12: ");
		int month = in.nextInt();

		// * Print the calendar
		printCalendar(month, year);

		in.close();
	}

	// * Method untuk mencetak kalender untuk bulan pada tahun yang dimasukkan user
	public static void printCalendar(int month, int year) {
		printHeader(month, year);
		printBody(month, year);
	}

	// * Cetak header kalender
	public static void printHeader(int month, int year) {
		System.out.printf("		%s %d\n", getMonthName(month), year);
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}

	// * Cetak body kalender
	public static void printBody(int month, int year) {
		int startDay = getStartDay(month, year);
		int numOfDays = getNumberOfDaysInMonth(month, year);

		for (int day = 0; day < startDay; day++) {
			System.out.print("    ");
		}

		for (int day = 1; day <= numOfDays; day++) {
			System.out.printf("%4d", day);

			if ((day + startDay) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	// * Get the name of the month
	public static String getMonthName(int month) {
		switch (month) {
			case 1 -> {
				return "January";
			}
			case 2 -> {
				return "February";
			}
			case 3 -> {
				return "March";
			}
			case 4 -> {
				return "April";
			}
			case 5 -> {
				return "May";
			}
			case 6 -> {
				return "June";
			}
			case 7 -> {
				return "July";
			}
			case 8 -> {
				return "August";
			}
			case 9 -> {
				return "September";
			}
			case 10 -> {
				return "October";
			}
			case 11 -> {
				return "November";
			}
			case 12 -> {
				return "December";
			}
		}
		return null;
	}

	// * Get the start day of the month using Zeller's algorithm
	public static int getStartDay(int month, int year) {
		return zeller(month, year);
	}

	// * Get the number of days in the respective month
	public static int getNumberOfDaysInMonth(int month, int year) {
		switch (month) {
			case 1, 3, 5, 7, 8, 10, 12 -> {
				return 31;
			}
			case 4, 6, 9, 11 -> {
				return 30;
			}
			case 2 -> {
				return (isLeapYear(year)) ? 29 : 28;
			}
		}
		return 0;
	}

	// ! Zeller's algorithm
	public static int zeller(int month, int year) {
		final int DAY_OF_THE_MONTH = 0; // ? 0 karena kita ingin mencari hari pertama dalam `month`, index hari = 0
		// ? In Zeller's algorithm, January = 13 & February = 14
		if (month == 1) {
			month = 13;
		}
		if (month == 2) {
			month = 14;
		}

		int century = year / 100;
		int yearOfCentury = year % 100;

		int dayOfTheWeek = (DAY_OF_THE_MONTH + (26 * (month + 1) / 10)
				+ yearOfCentury + (century / 4) + (yearOfCentury / 4) + (5 * century)) % 7;

		return dayOfTheWeek;
	}

	// ! Leap year checker
	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 400 != 0);
	}
}