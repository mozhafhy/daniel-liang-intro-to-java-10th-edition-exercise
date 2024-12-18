/*
(Find words) Write a program that finds all occurrences of a word in all the files
under a directory, recursively. Pass the parameters from the command line as
follows:

java Exercise18_30 dirName word
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class lat18_30_$$ {
	public static void main(String[] args) {
		String directory = args[0];
		String word = args[1];

		// Display the number of files
		System.out.println(findWords(new File(directory), word) + " times");
	}

	public static long findWords(File file, String word) {
		long numOfOccurrences = 0;
		System.out.println(file.getPath());

		if (file.isDirectory()) {
			// get all files and subdirectories in current directory
			File[] files = file.listFiles();

			for (int i = 0; files != null && i < files.length; i++) {
				numOfOccurrences += findWords(files[i], word); // Recursive call
			}
		} else {
			// Base case: get file content as string then run a search
			try {
				// get file content as a string
				String content = readFile(file.getPath(), Charset.forName("ASCII"));

				// search for all word occurrences in file
				for (int i = 0; i < content.length() - word.length() + 1; i++) {
					// check if the substring from i with the same length to word have the same
					// content as word
					if (content.substring(i, i + word.length()).equals(word)) {
						i += word.length() - 1; // skip the entire substring
						numOfOccurrences++;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return numOfOccurrences;
	}

	static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}