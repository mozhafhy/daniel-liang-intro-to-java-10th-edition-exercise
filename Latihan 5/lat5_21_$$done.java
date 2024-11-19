/*
 * Buat program yang meminta user untuk memasukkan loan amount dan tahun,
 * lalu tampilkan monthly payment dan total payment untuk masing-masing
 * bunga dimulai dari 5%, 5.125%, 5.250%, ..., 7.875%, 8.000%
 * 
 * Rumus:
 * monthlyPayment = (loanAmount * monthlyInterestRate) / 1 - Math.pow(1 + monthlyInterestRate, -numOfYears * 12)
 * totalPayment = monthlyPayment * numOfYears * 12
 */

import java.util.Scanner;

public class lat5_21_$$done {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Loan Amount: ");
		double loanAmount = in.nextDouble();

		System.out.print("Number of Years: ");
		int numOfYears = in.nextInt();

		// * Cetak tabelnya
		System.out.printf("%s    %s    %s\n", "Interest Rate", "Monthly Payment", "Total Payment");
		for (double i = 5; i <= 8; i += 0.125) { //* i adalah annual interest rate
			double monthlyPayment = (loanAmount * i / 1200.0) / (1 - Math.pow(1 + i / 1200.0, -numOfYears * 12));
			double totalPayment = monthlyPayment * numOfYears * 12;
			System.out.printf("%.3f\t\t %.2f%21.2f\n", i, monthlyPayment, totalPayment);
		}
		in.close();
	}
}