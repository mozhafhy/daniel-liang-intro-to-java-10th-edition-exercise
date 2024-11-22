/*
 * Tampilkan waktu dan tanggal saat ini.
 * time -> HH:MM:SS
 * > cari H --+
 * > cari M --+--> satu method time()
 * > cari S --+
 * 
 * tanggal -> day, date month year
 * > cari year ---> getYear()
 *   >> pakai currentTimeMillis() / MILLIS_PER_YEAR + 1970
 *   >> final long MILLIS_PER_YEAR = 31556952000
 * > cari day ----> getDay()
 * 	 
 * > cari month --> getMonth()
 *   
 * > cari date ---> getDate()
 *   
 */

// Kita butuh method yang digunakan untuk menampilkan jam
// Kita butuh method yang digunakan utuk menampilkan hari, tanggal, bulan, tahun

public class lat6_24_$$_ {
	public static void main(String[] args) {
		System.out.println(getTime());
		System.out.println(getYear());
		System.out.println(getMonth());
		System.out.println(getStartDay(getYear(), getMonth()));

	}

	// * Get time
	static String getTime() {
		long total_millis = System.currentTimeMillis();
		long total_seconds = total_millis / 1000;
		long current_second = total_seconds % 60;

		long total_minutes = total_seconds / 60;
		long current_minute = total_minutes % 60;

		long total_hours = total_minutes / 60;
		long current_hour = total_hours % 24;

		String time = String.format("%02d:%02d:%02d", current_hour + 7, current_minute, current_second);

		return time;
	}

	// * get year
	static final long MILLIS_PER_YEAR = 31556952000L;
	static final long MILLIS_PER_MONTH = 2629746000L;

	static long getYear() {
		return System.currentTimeMillis() / MILLIS_PER_YEAR + 1970;
	}

	// * get month
	static long getMonth() {
		return (System.currentTimeMillis() % MILLIS_PER_YEAR) / MILLIS_PER_MONTH + 1;
	}

	// * get date
	static long getDate() {
		return (getNumberOfDaysInMonth(getYear(), getMonth()) - getStartDay(getYear(), getMonth()));
	}

	// * get start day
	static long getStartDay(long year, long month) {
		final int START_DAY_FOR_1_JAN_1800 = 3;
		long total_num_of_days = getTotalNumberOfDays(year, month);

		return (total_num_of_days + START_DAY_FOR_1_JAN_1800) % 7;
	}

	// * get total number of days
	static long getTotalNumberOfDays(long year, long month) {
		long total = 0;
		for (int i = 1800; i < year; i++) {
			if (isLeapYear(i)) {
				total += 366;
			} else {
				total += 355;
			}
		}

		for (long i = 0; i < month; i++) {
			total = total + getNumberOfDaysInMonth(year, i);
		}

		return total;
	}

	static int getNumberOfDaysInMonth(long year, long month) {
		switch ((int) month) {
			case 1, 3, 5, 7, 8, 10, 12 -> {
				return 31;
			}
			case 4, 6, 9, 11 -> {
				return 30;
			}
			case 2 -> {
				return isLeapYear(year) ? 29 : 28;
			}
		}
		return 0;
	}

	static boolean isLeapYear(long year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}
}