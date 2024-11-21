/*
 * (Sort students) Write a program that prompts the user to enter the number of students, the students’ names, and their scores, and prints 
 * student names in decreasing order of their scores.
 */
import java.util.Scanner;

public class lat7_17_$$ {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter the number of students: ");
		int studentCounts = in.nextInt();
		getSortedStudents(studentCounts);
	}

	// * Buat method untuk mengurutkan siswa berdasarkan skornya (descending order)
	static void getSortedStudents(int studenCounts) {
		// * Instansiasi array untuk menampung nama dan skor siswa
		String[] names = new String[studenCounts];
		int[] grades = new int[studenCounts];

		// Inisialisasi nilainya
		for (int i = 0; i < studenCounts; i++) {
			System.out.printf("%d. ", i+1);
			names[i] = in.next();
			grades[i] = in.nextInt();
		}

		// * Sorting menggunakan selection sort
		int i, j;
		for (i = 0; i < studenCounts; i++) {
			for (j = 0; j <studenCounts; j++) {
				int tempGrade = grades[i];
				String tempName = names[i];
				if (grades[j] > tempGrade) {
					// * Proses untuk menukar skor ke-i dengan j
					grades[i] = grades[j];
					grades[j] = tempGrade;

					// * Proses untuk menukar nama ke-i dengan j
					names[i] = names[j];
					names[j] = tempName;

					/*
						* grades: a1 a2 a3 a4 ... an (bebas)
						* names : a1 b2 b3 b4 ... bn (terikat dengan grades)
						* 
						* Ketika a1 ditukar dengan a2, otomatis b1 akan ditukar dengan b2
					*/
				}
			}
		}
		// * Cetak daftar siswa dan nilainya yang sudah diurutkan
		System.out.println("\nSorted result:");
		for (i = studenCounts - 1; i >= 0; i--) {
			System.out.printf("%d. %s\t%d\n", (studenCounts - i), names[i], grades[i]);
		}
	}
}