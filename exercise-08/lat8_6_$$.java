// (Algebra: multiply two matrices) Write a method to multiply two matrices

public class lat8_6_$$ {
	public static void main(String[] args) {
		double[][] a = {
				{ 1, 1 },
				{ 2, 2 },
				{ 3, 3 }
		};

		double[][] b = {
				{ 1, 1, 1 },
				{ 2, 2, 2 },
		};

		double[][] c = multiplyMatrix(a, b);

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static double[][] multiplyMatrix(double[][] a, double[][] b) {
		// check if number of columns in a and number of rows in b are the same
		if (a[0].length != b.length)
			throw new Error("Can't multiply matrices");

		int numOfCols = b[0].length;
		int numOfRows = a.length;

		double[][] result = new double[numOfRows][numOfCols];

		// calculate multiplied matrix
		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfCols; j++) {
				for (int k = 0; k < b.length; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		return result;
	}
}