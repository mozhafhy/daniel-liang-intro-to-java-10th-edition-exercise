/*
 * Konversi milidetik ke jam:menit:detik.
 * 
 * ex:
 * convertMillis(5500) returns a string 0:0:5
 */

import java.util.Scanner;

public class lat6_25 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Convert miliseconds: ");
		long millis = in.nextLong();

		System.out.println(convertMillis(millis));
		in.close();
	}

	// ! Converter method
	public static String convertMillis(long millis) {
		String result = "";
		long total_seconds = millis / 1000;
		long second = total_seconds % 60;

		long total_minutes = total_seconds / 60;
		long minute = total_minutes % 60;

		long hours = total_minutes / 60;

		result = String.format("%d:%d:%d", hours, minute, second);

		return result;
	}
}