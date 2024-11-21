
/*
 * (Financial application: compute tax) Rewrite Listing 3.5, ComputeTax.java, using arrays. For each filing status, there are six tax 
 * rates. Each rate is applied to a certain amount of taxable income. For example, from the taxable income of $400,000 for a single filer, 
 * $8,350 is taxed at 10%, (33,950 - 8,350) at 15%, (82,250 - 33,950) at 25%, (171,550 - 82,550) at 28%, (372,550 - 82,250) at 33%, and 
 * (400,000 - 372,950) at 36%. The six rates are the same for all filing statuses, which can be represented in the following array:
 * 
 * double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
 * 
 * int[][] brackets = {
 	* {8350, 33950, 82250, 171550, 372950}, // Single filer
 	* {16700, 67900, 137050, 20885, 372950}, // Married jointly
 	* {8350, 33950, 68525, 104425, 186475}, // Married separately
 	* {11950, 45500, 117450, 190200, 372950} // Head of household
	*};
 * Suppose the taxable income is $400,000 for single filers. The tax can be computed as follows:
 * tax = brackets[0][0] * rates[0] +
 	* (brackets[0][1] – brackets[0][0]) * rates[1] +
 	* (brackets[0][2] – brackets[0][1]) * rates[2] +
 	* (brackets[0][3] – brackets[0][2]) * rates[3] +
 	* (brackets[0][4] – brackets[0][3]) * rates[4] +
 	* (400000 – brackets[0][4]) * rates[5]
*/
import java.util.Scanner;

public class lat8_12_$$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Category:\n0 - single\n1 - married jointly\n2 - married separately\n3 - head of household");
		System.out.print("Enter your category: ");
		int filerCategory = in.nextInt();

		System.out.print("Enter your income (e.g. 400000): ");
		int income = in.nextInt();

		System.out.printf("Your tax is $%,.2f", computeTax(filerCategory, income));
		in.close();
	}

	// * Buat method untuk menghitung pajak
	static double computeTax(int filerCategory, int income) {
		double[] rates = { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35 };
		int[][] brackets = {
				{ 8350, 33950, 82250, 171550, 372950 }, // Single filer
				{ 16700, 67900, 137050, 20885, 372950 }, // Married jointly
				{ 8350, 33950, 68525, 104425, 186475 }, // Married separately
				{ 11950, 45500, 117450, 190200, 372950 } // Head of household
		};
		double tax = 0;

		if (income <= brackets[filerCategory][0]) {
			tax = income * rates[0];
// * Sakit ga matanya :)
		} else if (income <= brackets[filerCategory][1]) {
			tax = brackets[filerCategory][0] * rates[0] +
					(income - brackets[filerCategory][1]) * rates[1];
		} else if (income <= brackets[filerCategory][2]) {
			tax = brackets[filerCategory][0] * rates[0] +
					(brackets[filerCategory][1] - brackets[filerCategory][0]) * rates[1] +
					(income - brackets[filerCategory][2]) * rates[2];
		} else if (income <= brackets[filerCategory][3]) {
			tax = brackets[filerCategory][0] * rates[0] +
					(brackets[filerCategory][1] - brackets[filerCategory][0]) * rates[1] +
					(brackets[filerCategory][2] - brackets[filerCategory][1]) * rates[2] +
					(income - brackets[filerCategory][3]) * rates[3];
		} else if (income <= brackets[filerCategory][4]) {
			tax = brackets[filerCategory][0] * rates[0] +
					(brackets[filerCategory][1] - brackets[filerCategory][0]) * rates[1] +
					(brackets[filerCategory][2] - brackets[filerCategory][1]) * rates[2] +
					(brackets[filerCategory][3] - brackets[filerCategory][2]) * rates[3] +
					(income - brackets[filerCategory][3]) * rates[4];
		} else {
			tax = brackets[filerCategory][0] * rates[0] +
					(brackets[filerCategory][1] - brackets[filerCategory][0]) * rates[1] +
					(brackets[filerCategory][2] - brackets[filerCategory][1]) * rates[2] +
					(brackets[filerCategory][3] - brackets[filerCategory][2]) * rates[3] +
					(brackets[filerCategory][4] - brackets[filerCategory][3]) * rates[4] +
					(income - brackets[filerCategory][4]) * rates[5];
		}
		return tax;
	}
}