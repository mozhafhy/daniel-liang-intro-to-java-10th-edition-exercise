/*
 * Tampilkan waktu dan tanggal saat ini.
 * Format: (sesuai pemahamanku)
 * (time) GMT, date/month/year
 */

// Kita butuh method yang digunakan untuk mendapatkan jam
// Kita butuh method yang digunakan utuk mendapatkan tanggal, bulan, tahun

public class lat6_24_$$ {
	// ? Variabel-variabel yang independen terhadap leap years
	static long totMillis = System.currentTimeMillis();
	static long totSeconds = totMillis / 1000;
	static long totMinutes = totSeconds / 60;
	static long totHours = totMinutes / 60;
	static long totDays = ceil(totHours / 24.0);

	public static void main(String[] args) { // ! main method
		System.out.printf("%s GMT, %s", getTime(), getCurrentDate());
	}

	// * Display the date
	public static String getCurrentDate() {
		return String.format("%d/%d/%d", getDate(), getCurrentYearMonthIndex(), getYear());
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
		// ? nilai `days` sekarang adalah banyak hari dari 1/1/currentYear sampai current date

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