/*
 * Loan Amount: 10000
 * Number of Years: 1
 * Annual Interest Rate: 7
 * 
 * Monthly Payment: 865.26
 * Total Payment: 10383.21
 * 
 * tabelnya di bawah sini
 * Payment#		Interest		Principal		Balance
 * ...				...					...					...
 * 
 * Rumus:
 * monthlyPayment = (loanAmount * monthlyInterestRate) / 1 - Math.pow(1 + monthlyInterestRate, -numOfYears * 12)
 * totalPayment = monthlyPayment * numOfYears * 12
 * 
 */

import java.util.Scanner;

public class lat5_22_$$done {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Loan Amount: ");
		double loanAmount = in.nextDouble();

		System.out.print("Number of Years: ");
		int numberOfYears = in.nextInt();

		System.out.print("Annual Interest Rate: ");
		double annualInterestRate = in.nextDouble();
		double monthlyInterestRate = annualInterestRate / 1200.0;

		double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfYears * 12));
		double totalPayment = monthlyPayment * numberOfYears * 12;
		System.out.printf("\nMonthly Payment: %.2f\n", monthlyPayment);
		System.out.printf("Total Payment: %.2f\n\n", totalPayment);

		double balance = loanAmount;
		double interest;
		double principal;

		System.out.println("Payment#\tInterest\tPrincipal\tBalance");
		for (int i = 1; i <= numberOfYears * 12; i++) {
			interest = (int) (monthlyInterestRate * balance * 100) / 100.0;
      principal = (int) ((monthlyPayment - interest) * 100) / 100.0;
      balance = (int) ((balance - principal) * 100) / 100.0;
			System.out.println(i + "\t\t" + interest + "\t\t" + principal + "\t\t" + balance);
		}

		in.close();
	}
}