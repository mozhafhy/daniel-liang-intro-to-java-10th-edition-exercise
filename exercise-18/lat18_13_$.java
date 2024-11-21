/*
(Find the largest number in an array) Write a recursive method that returns the
largest integer in an array. Write a test program that prompts the user to enter a
list of eight integers and displays the largest element.
 */

import java.util.Scanner;

public class lat18_13_$ {
	public static void main(String[] args) {
		int[] numbers = new int[8];

		// read 8 integers from user input
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 8; i++) {
			numbers[i] = in.nextInt();
		}
		in.close();

		System.out.println(findLargestInt(numbers, numbers.length - 1));
	}

	/**
	 * compare every element in array to find the largest
	 * 
	 * @param array
	 * @param high  highest index of elements that are not compared yet
	 * @return largest integer in array
	 */
	static int findLargestInt(int[] array, int high) {
		// base case
		if (high == 0)
			return array[0];

		// compare last unchecked element with largest element of unchecked array
		int foundLargest = findLargestInt(array, high - 1);
		if (array[high] > foundLargest) {
			return array[high];
		}

		return foundLargest;
	}
}