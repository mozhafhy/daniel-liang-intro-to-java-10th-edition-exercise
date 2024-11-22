/*
(Compute the weekly hours for each employee) Suppose the weekly hours for all
employees are stored in a two-dimensional array. Each row records an employee’s seven-day work hours with seven columns. For example, the following
array stores the work hours for eight employees. Write a program that displays
employees and their total hours in decreasing order of the total hours.
 */

public class lat8_4_$$ {
	public static void main(String[] args) {
		// id, Su, M, T, W, Th, F, Sa
		int[][] employeeDataArray = {
				{ 0, 2, 4, 3, 4, 5, 8, 8 },
				{ 1, 7, 3, 4, 3, 3, 4, 4 },
				{ 2, 3, 3, 4, 3, 3, 2, 2 },
				{ 3, 9, 3, 4, 7, 3, 4, 1 },
				{ 4, 3, 5, 4, 3, 6, 3, 8 },
				{ 5, 3, 4, 4, 6, 3, 4, 4 },
				{ 6, 3, 7, 4, 8, 3, 8, 4 },
				{ 7, 6, 3, 5, 9, 2, 7, 9 }
		};

		sortEmployees(employeeDataArray);

		// display sorted employee
		for (int i = 0; i < employeeDataArray.length; i++) {
			System.out.println("Employee " + employeeDataArray[i][0] + " : " + getTotalHour(employeeDataArray[i]) + " hours");
		}

	}

	// sort employee by its total hours indescending order
	static void sortEmployees(int[][] employeeDataArray) {
		for (int i = 0; i < employeeDataArray.length; i++) {

			// search for the employee with longest total hours
			int longestHours = getTotalHour(employeeDataArray[i]);
			int longestHoursEmployeeIndex = i;
			for (int j = i + 1; j < employeeDataArray.length; j++) {
				int totalHours = getTotalHour(employeeDataArray[j]);
				if (totalHours > longestHours) {
					longestHours = totalHours;
					longestHoursEmployeeIndex = j;
				}
			}

			// swap array position of the first unsorted employee and longest hour employee
			int[] temp = employeeDataArray[i];
			employeeDataArray[i] = employeeDataArray[longestHoursEmployeeIndex];
			employeeDataArray[longestHoursEmployeeIndex] = temp;
		}
	}

	static int getTotalHour(int[] employeeHours) {
		int totalHours = 0;
		for (int i = 1; i < employeeHours.length; i++) {
			totalHours += employeeHours[i];
		}

		return totalHours;
	}
}