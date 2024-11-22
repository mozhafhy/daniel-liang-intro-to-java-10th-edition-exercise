/*
(Game: bean machine) The bean machine, also known as a quincunx or the Galton box, is a device for statistics
experiments named after English scientist Sir Francis Galton.
It consists of an upright board with evenly spaced nails (or pegs) in a triangular form

Balls are dropped from the opening of the board. Every time a ball hits a nail, it
has a 50% chance of falling to the left or to the right. The piles of balls are accumulated in the slots at the bottom of the board.
Write a program that simulates the bean machine. Your program should prompt
the user to enter the number of the balls and the number of the slots in the machine.
Simulate the falling of each ball by printing its path
 */

import java.util.Scanner;

public class lat7_21_$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// prompt user to input number of balls to drop
		System.out.print("Enter the number of balls to drop: ");
		int numOfBalls = in.nextInt();

		// prompt user to input number of slots
		System.out.print("Enter the number of slots in the bean machine: ");
		int numOfSlots = in.nextInt();
		int[] slotNumOfBalls = new int[numOfSlots];

		// drop balls
		for (int i = 0; i < numOfBalls; i++) {
			String movementString = "";
			double slotPos = numOfSlots / 2.0 - 0.5;

			// randomize slot position for each ball
			for (int j = 0; j < numOfSlots - 1; j++) {
				if (Math.random() > 0.5) {
					slotPos -= 0.5;
					movementString += "L";
				} else {
					slotPos += 0.5;
					movementString += "R";
				}
			}

			System.out.println(movementString);
			slotNumOfBalls[(int) slotPos]++;
		}

		// display balls
		for (int i = numOfBalls; i > 0; i--) { // balls stack height loop
			for (int j = 0; j < numOfSlots; j++) { // slots loop
				if (slotNumOfBalls[j] >= i) {
					System.out.print("O");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		in.close();
	}
}