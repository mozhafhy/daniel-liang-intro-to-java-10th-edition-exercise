/*
(Display patterns) Write a method to display a pattern as follows:
							1
 						2 1
 					3 2 1
...
n n-1 ... 3 2 1
The method header is
public static void displayPattern(int n)
*/
import java.util.Scanner;

public class lat6_6_$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		displayPattern(n);
		in.close();
	}

	public static void displayPattern(int n) {
		int i, j, k;
		for (i = 0; i < n; i++) {
			for (j = n - 1; j > i; j--) {
				System.out.printf("%" + j + "c", '\u0000');
			}

			for (k = i + 1; k > 0; k--) {
				System.out.printf("%" + (i + 1) + "c" + "%" + (i + 1) + "c", '0' + k, '0' + i);
			}
			System.out.println();
		}
	}
}