/*
 * Chapter 5 Exercise 29:
 *
 *      (Display calendars) Write a program that prompts the user to enter
 *      the year and first day of the year and displays the calendar table
 *      for the year on the console. For example, if the user entered the year
 *      2013, and 2 for Tuesday, January 1, 2013, your program should display
 *      the calendar for each month in the year, as follows:
 *
 */

import java.util.Scanner; // ! Import scanner karena butuh masukan dari user

public class lat5_29_$$done {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter year: ");
    int year = in.nextInt();

    System.out.print("Enter the first day fo the year (0 - 6): ");
    int startDay = in.nextInt() % 7; // * Agar input yang dimasukkan tetap berada di [0, 6]
    // if (startDay > 6) {
    // System.out.println("Invalid first day of the month!");
    // return;
    // }

    // * Cetak kalender
    int numberOfDaysInMonth = 0;
    for (int i = 1; i <= 12; i++) {
      System.out.print("  ");
      switch (i) {
        case 1 -> {
          System.out.println("January " + year);
          numberOfDaysInMonth = 31;
        }
        case 2 -> {
          System.out.println("February " + year);
          if (year % 400 != 0 && year % 100 != 0 && year % 4 != 0) {
            numberOfDaysInMonth = 28;
          } else {
            numberOfDaysInMonth = 29;
          }
        }
        case 3 -> {
          System.out.println("March " + year);
          numberOfDaysInMonth = 31;
        }
        case 4 -> {
          System.out.println("April " + year);
          numberOfDaysInMonth = 30;
        }
        case 5 -> {
          System.out.println("May " + year);
          numberOfDaysInMonth = 31;
        }
        case 6 -> {
          System.out.println("June " + year);
          numberOfDaysInMonth = 30;
        }
        case 7 -> {
          System.out.println("July " + year);
          numberOfDaysInMonth = 31;
        }
        case 8 -> {
          System.out.println("August " + year);
          numberOfDaysInMonth = 31;
        }
        case 9 -> {
          System.out.println("September " + year);
          numberOfDaysInMonth = 30;
        }
        case 10 -> {
          System.out.println("October" + year);
          numberOfDaysInMonth = 31;
        }
        case 11 -> {
          System.out.println("November " + year);
          numberOfDaysInMonth = 30;
        }
        case 12 -> {
          System.out.println("December " + year);
          numberOfDaysInMonth = 31;
        }
      }

      System.out.println("  ===========================");
      System.out.println("  Sun Mon Tue Wed Thu Fri Sat");

      for (int j = 0; j < startDay; j++) {
        System.out.print("    "); // * Hari sebelum hari pertama adalah blank
      }

      for (int j = 1; j <= numberOfDaysInMonth; j++) { // * Cetak tanggalnya sesuai banyak hari dalam bulan itu
        if (j < 10) {
          System.out.printf("   %d", j);
        } else {
          System.out.printf("  %d", j);
        }

        if ((j + startDay) % 7 == 0 && j != numberOfDaysInMonth) { // * Pindah baris
          System.out.println();
        }
      }
      startDay = (startDay + numberOfDaysInMonth) % 7; // * Hari pertama untuk bulan berikutnya
      System.out.println("\n");
    }
    in.close();
  }
}