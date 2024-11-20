
/*
(Financial application: compute the future investment value) Write a method that computes future investment value at a given interest rate for a specified number of years. The future investment is determined using the formula in Programming Exercise 2.21.
futureInvestmentValue = investmentAmount * (1 + monthlyInterestRate)^numberOfYears*12
Use the following method header:

public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years)

For example, futureInvestmentValue(10000, 0.05/12, 5) returns 12833.59.
Write a test program that prompts the user to enter the investment amount (e.g., 1000) and the interest rate (e.g., 9%) and prints a table that displays future value for the years from 1 to 30, as shown below:
The amount invested: 1000
Annual interest rate: 9
Years 		Future Value
1 					  1093.80
2 						1196.41
...
29 					 13467.25
30 					 14730.57
*/
import java.util.Scanner;

public class lat6_7 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int years = 30;

		System.out.print("The amoun invested: ");
		int investmentAmount = in.nextInt();

		System.out.print("Annual interest rate: ");
		int annualInterestRate = in.nextInt();

		System.out.printf("Years%20s\n", "Future Value");
		for (int year = 1; year <= years; year++) {
			double futureValue = futureInvestmentValue(investmentAmount, annualInterestRate / 1200.0, year);
			System.out.printf("%d\t\t%.2f\n", year, futureValue);
		}

		in.close();
	}

	public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
		return investmentAmount * Math.pow((1 + monthlyInterestRate), years * 12);
	}
}