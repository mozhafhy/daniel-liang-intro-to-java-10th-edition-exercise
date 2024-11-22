/*
(Print distinct numbers) Write a program that reads in ten numbers and displays
the number of distinct numbers and the distinct numbers separated by exactly one
space (i.e., if a number appears multiple times, it is displayed only once). (Hint:
Read a number and store it to an array if it is new. If the number is already in the
array, ignore it.) After the input, the array contains the distinct numbers.
 */

import java.util.Scanner;

public class lat7_5_$$ {
	static int[] distinctIntegers = new int[10];
	static int numOfDistictInts = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter ten numbers: ");
		// prompt user to input 10 numbers and store distinct numbers
		for (int i = 0; i < 10; i++) {
			int number = in.nextInt();
			addIfDistinct(number);
		}

		System.out.printf("The number of distinct number is %d%n", numOfDistictInts);
		System.out.println("The distinct numbers are: ");
		// print all distinct numbers
		for (int i = 0; i < numOfDistictInts; i++) {
			System.out.print(distinctIntegers[i] + " ");
		}

		in.close();
	}

	static void addIfDistinct(int value) {
		for (int i = 0; i < numOfDistictInts; i++) {
			if (distinctIntegers[i] == value)
				return;
		}

		distinctIntegers[numOfDistictInts] = value;
		numOfDistictInts++;
	}
}