// (Count occurrence of numbers) Write a program that reads the integers between 1
// and 100 and counts the occurrences of each. Assume the input ends with 0.

import java.util.Scanner;

public class lat7_3_$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[] integerOccurrences = new int[100];

		// prompt user to input the integers
		System.out.printf("Enter the integers between 1 and 100: ");
		while (true) {
			int value = in.nextInt();

			// stop when user input 0
			if (value == 0)
				break;

			integerOccurrences[value]++;
		}

		in.close();

		for (int i = 0; i < integerOccurrences.length; i++) {
			// skip integer that never occurs
			if (integerOccurrences[i] == 0)
				continue;

			System.out.println(i + " occurrs " + integerOccurrences[i] + " times");
		}
	}
}