/*
(Number of files in a directory) Write a program that prompts the user to enter a
directory and displays the number of the files in the directory. 
 */

import java.io.File;
import java.util.Scanner;

public class lat18_29_$ {
	public static void main(String[] args) {
		// Prompt the user to enter a directory or a file
		System.out.print("Enter a directory or a file: ");
		Scanner in = new Scanner(System.in);
		String directory = in.nextLine();
		in.close();

		// Display the number of files
		System.out.println(countFiles(new File(directory)) + " files");
	}

	public static long countFiles(File file) {
		long numOfFiles = 0;

		if (file.isDirectory()) {
			// get all files and subdirectories in current directory
			File[] files = file.listFiles();

			for (int i = 0; files != null && i < files.length; i++) {
				numOfFiles += countFiles(files[i]); // Recursive call
			}
		} else {
			// Base case
			numOfFiles++;
		}

		return numOfFiles;
	}
}