/*
(Guess the capitals) Write a program that repeatedly prompts the user to enter
a capital for a state. Upon receiving the user input, the program reports whether
the answer is correct. Assume that 50 states and their capitals are stored in a twodimensional array, as shown in Figure 8.10. The program prompts the user to
answer all states’ capitals and displays the total correct count. The user’s answer
is not case-sensitive.
 */

import java.util.Scanner;

public class lat8_37_$$ {
	public static void main(String[] args) {
		String[][] stateCapitalPair = {
				{ "Alabama", "Montgomery" },
				{ "Alaska", "Juneau" },
				{ "Arizona", "Phoenix" },
				{ "Arkansas", "Little Rock" },
				{ "California", "Sacramento" },
				{ "Colorado", "Denver" },
				{ "Connecticut", "Hartford" },
				{ "Delaware", "Dover" },
				{ "Florida", "Tallahassee" },
				{ "Georgia", "Atlanta" },
				{ "Hawaii", "Honolulu" },
				{ "Idaho", "Boise" },
				{ "Illinois", "Springfield" },
				{ "Indiana", "Indianapolis" },
				{ "Iowa", "Des Moines" },
				{ "Kansas", "Topeka" },
				{ "Kentucky", "Frankfort" },
				{ "Louisiana", "Baton Rouge" },
				{ "Maine", "Augusta" },
				{ "Maryland", "Annapolis" },
				{ "Massachusetts", "Boston" },
				{ "Michigan", "Lansing" },
				{ "Minnesota", "Saint Paul" },
				{ "Mississippi", "Jackson" },
				{ "Missouri", "Jefferson City" },
				{ "Montana", "Helena" },
				{ "Nebraska", "Lincoln" },
				{ "Nevada", "Carson City" },
				{ "New Hampshire", "Concord" },
				{ "New Jersey", "Trenton" },
				{ "New Mexico", "Santa Fe" },
				{ "New York", "Albany" },
				{ "North Carolina", "Raleigh" },
				{ "North Dakota", "Bismarck" },
				{ "Ohio", "Columbus" },
				{ "Oklahoma", "Oklahoma City" },
				{ "Oregon", "Salem" },
				{ "Pennsylvania", "Harrisburg" },
				{ "Rhode Island", "Providence" },
				{ "South Carolina", "Columbia" },
				{ "South Dakota", "Pierre" },
				{ "Tennessee", "Nashville" },
				{ "Texas", "Austin" },
				{ "Utah", "Salt Lake City" },
				{ "Vermont", "Montpelier" },
				{ "Virginia", "Richmond" },
				{ "Washington", "Olympia" },
				{ "West Virginia", "Charleston" },
				{ "Wisconsin", "Madison" },
				{ "Wyoming", "Cheyenne" },
		};

		Scanner in = new Scanner(System.in);
		int correctCount = 0;

		for (int i = 0; i < stateCapitalPair.length; i++) {
			System.out.printf("What is the capital of %s? ", stateCapitalPair[i][0]);
			String answer = in.nextLine();

			if (answer.equalsIgnoreCase(stateCapitalPair[i][1])) {
				System.out.println("Your answer is correct");
				correctCount++;
			} else {
				System.out.printf("The correct answer should be %s%n", stateCapitalPair[i][1]);
			}
		}

		System.out.printf("The correct count is %d", correctCount);

		in.close();
	}
}