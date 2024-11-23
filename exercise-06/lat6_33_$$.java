/*
 * Tampilkan waktu dan tanggal saat ini.
 * Format:
 * Current date and time is (month) (date), (year) HH:MM:SS
 */

// Kita butuh method yang digunakan untuk mendapatkan jam (see line 27)
// Kita butuh method yang digunakan utuk mendapatkan tanggal (line 74), bulan (line 53), tahun (line 37)

// Kita butuh method yang digunakan untuk mendapatkan nama bulan (see line 96)

public class lat6_33_$$ {
	// ? Variabel-variabel yang independen terhadap leap years
	static long totMillis = System.currentTimeMillis();
	static long totSeconds = totMillis / 1000;
	static long totMinutes = totSeconds / 60;
	static long totHours = totMinutes / 60;
	static long totDays = ceil(totHours / 24.0);

	public static void main(String[] args) { // ! main method
		int montIndex = (int) getCurrentYearMonthIndex();

		// * Cetak
		System.out.printf("Current date and time is %s %d, %d %s",
				getMonthName(montIndex), getDate(), getYear(), getTime());
	}

	// * Get the current time in GMT, format: HH:MM:SS
	public static String getTime() {
		int currSecond = (int) (totSeconds % 60);
		int currMinute = (int) (totMinutes % 60);
		int currHour = (int) (totHours % 24);
		String time = String.format("%02d:%02d:%02d", currHour, currMinute, currSecond);

		return time;
	}

	// * Get the current year
	public static int getYear() {
		long days = totDays;
		int countYears = 0;
		for (int year = 1970; days > 365; year++) { // ? a year cannot be less than 365 days
			if (isLeapYear(year)) {
				days = days - 366;
			} else {
				days = days - 365;
			}
			countYears++;
		}

		return 1970 + countYears; // ? return 1970 + the elapsed year
	}

	// * Get the current-year month index (1, 2, 3, ..., 12)
	public static long getCurrentYearMonthIndex() {
		long days = totDays;
		for (int year = 1970; days > 365; year++) {
			if (isLeapYear(year)) {
				days = days - 366;
			} else {
				days = days - 365;
			}
		}
		// ? nilai `days` sekarang adalah banyak hari dari 1/1/currentYear sampai
		// ? current date

		int index = 1; // ? bulan dimulai dari Januari dengan index 1
		for (int month = 1; days > 28; month++) {
			days = days - getDaysInMonth(getYear(), month);
			index++;
		}
		return index;
	}

	// * Get the current day
	public static long getDate() {
		long days = totDays;
		for (int year = 1970; days > 365; year++) {
			if (isLeapYear(year)) {
				days = days - 366;
			} else {
				days = days - 365;
			}
		}

		for (int month = 1; days > 28; month++) {
			days = days - getDaysInMonth(getYear(), month);
		}

		// ? The process is still the same as `getCurrentYearMonthIndex()` method
		return days; // ? but we return `days` instead of `index`
	}

	/*
	 * =============================================================================
	 */

	// ! Get the name of the month
	public static String getMonthName(int monthIndex) {
		switch (monthIndex) {
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

	// ! Get the number of days in a month with respect to its year
	public static int getDaysInMonth(int year, int month) {
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
			default -> {
				return 0;
			}
		}
	}

	// ! Leap year checker
	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}

	// ! Fungsi pembulatan ke atas
	public static long ceil(double n) {
		return (n > (long) n) ? (long) n + 1 : (long) n;
	}
}