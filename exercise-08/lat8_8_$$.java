/*
(All closest pairs of points) Revise Listing 8.3, FindNearestPoints.java, to
display all closest pairs of points with the same minimum distance
 */

import java.util.Scanner;

public class lat8_8_$$ {
	public static void main(String[] args) {
		// prompt user to input n
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of points: ");
		int n = in.nextInt();

		// prompt user to input n points
		System.out.printf("Enter %d points: ", n);
		double[][] points = new double[n][2];
		for (int i = 0; i < n; i++) {
			points[i][0] = in.nextDouble();
			points[i][1] = in.nextDouble();
		}
		in.close();

		double shortestDistance = -1; // -1 to mark that has no value
		for (int i = 0; i < points.length; i++) {
			for (int j = i; j < points.length; j++) {
				// continue iteration if comparing same points
				if (i == j)
					continue;

				double distance = getDistance(points[i][0], points[i][1], points[j][0], points[j][1]);

				// update shortest distance it it's unset or longer than current distance
				if (shortestDistance == -1 || distance < shortestDistance) {
					shortestDistance = distance;
				}
			}
		}

		for (int i = 0; i < points.length; i++) {
			for (int j = i; j < points.length; j++) {
				// continue iteration if comparing same points
				if (i == j)
					continue;

				double distance = getDistance(points[i][0], points[i][1], points[j][0], points[j][1]);

				if (distance > shortestDistance)
					continue; // don't print anything if distance not short enough

				System.out.printf(
						"The closest two points are (%.1f, %.1f) and (%.1f, %.1f)%n",
						points[i][0],
						points[i][1],
						points[j][0],
						points[j][1]);
			}
		}
		System.out.println("Their distance is " + shortestDistance);
	}

	static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
}