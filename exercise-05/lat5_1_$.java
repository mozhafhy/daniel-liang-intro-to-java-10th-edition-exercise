
/*
 * Buat program yang membaca beberapa bilangan bulat sampai menemui 
 * angka 0, lalu program akan menghitung banyak bilangan positif dan
 * negatif, kemudian menghitung total dan rata-ratanya
*/
import java.util.Scanner;

public class lat5_1_$ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int countNeg = 0; //* Nilai awal untuk banyak bilangan nengatif, 0 berarti belum ada bilangan negatif yang dimasukkan
		int countPos = 0; //* Nilai awal untuk banyak bilangan positif, 0 berarti belum ada bilangan positif yang dimasukkan
		double sum = 0; //* Jumlah awal bilangan yang dimasukkan, 0 berarti belum ada bilangan yang dimasukkan

		System.out.print("Enter an integer, the input ends if it is 0: ");
		while (true) { // Loop untuk memasukkan bilangan
			double num = in.nextDouble();
			if (num == 0) //! Loop akan berhenti jika bilangan yang dimasukkan bernilai 0
				break;

			if (num < 0) { // Setiap bilangan negatif yang dimasukkan, countNeg ditambah 1
				countNeg++;
			} else if (num > 0) { // Setiap bilangan positif yang dimasukkan, countPos ditambah 1
				countPos++;
			}

			sum += num;
		}
		double avg = sum / (countNeg + countPos); //* Rata-rata dari bilangan-bilangan yang dimasukkan

		//* Cetak hasilnya
		System.out.printf("The number of positives is %d\n", countPos);
		System.out.printf("The number of negatives is %d\n", countNeg);
		System.out.printf("The total is %.2f\n", sum);
		System.out.printf("The average is %.2f\n", avg);

		in.close();
	}
}