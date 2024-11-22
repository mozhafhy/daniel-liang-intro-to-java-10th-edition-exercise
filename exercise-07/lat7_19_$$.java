/*
(Sorted?) Write the following method that returns true if the list is already sorted
in increasing order. Write a test program that prompts the user to enter a list and displays whether
the list is sorted or not. Here is a sample run.

Note that the first number in the
input indicates the number of the elements in the list. This number is not part
of the list. 
 */

import java.util.Scanner;

public class lat7_19_$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// prompt user to input n and list numbers
		System.out.print("Enter list: ");
		int n = in.nextInt();
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = in.nextInt();
		}

		in.close();

		// print result
		if (isSorted(list)) {
			System.out.println("The list is already sorted");
		} else {
			System.out.println("The list is not sorted");
		}
	}

	// check is array sorted in ascending order
	public static boolean isSorted(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			if (list[i] > list[i + 1])
				return false;
		}

		return true;
	}
}