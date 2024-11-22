
/*
8 (Bubble sort) Write a sort method that uses the bubble-sort algorithm. The bubblesort algorithm makes several passes through the array. On each pass, successive
neighboring pairs are compared. If a pair is not in order, its values are swapped;
otherwise, the values remain unchanged. The technique is called a bubble sort or
sinking sort because the smaller values gradually “bubble” their way to the top
and the larger values “sink” to the bottom. Write a test program that reads in ten
double numbers, invokes the method, and displays the sorted numbers.
 */

import java.util.Scanner;

public class lat7_18_$$ {
	public static void main(String[] args) {
		// read 10 doubles from input
		Scanner in = new Scanner(System.in);
		double[] numbers = new double[10];
		for (int i = 0; i < 10; i++) {
			numbers[i] = in.nextDouble();
		}
		in.close();

		bubbleSort(numbers);

		// print the sorted array
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}

	static void bubbleSort(double[] numbers) {
		// start from 1 because we need at least 2 element
		for (int i = 1; i < numbers.length; i++) {
			// check from 0 to n-i
			for (int j = 0; j < numbers.length - i; j++) {
				if (numbers[j] < numbers[j + 1]) {
					// swap element
					double temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}
}