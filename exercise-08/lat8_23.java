import java.util.Scanner;

public class lat8_23 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matrix = new int[6][6];

        // Input matriks
        // memasukkan elemen 6x6 matriks (hanya 0 dan 1)
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = input.nextInt();
                if (matrix[i][j] < 0 || matrix[i][j] > 1) {
                    System.out.println("Input hanya boleh 0 dan 1.");
                    input.close();
                    return;
                }
            }
        }

        // Tampilkan matriks
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Cari baris yang jumlah 1-nya ganjil
        int row = -1;
        for(int i = 0; i < 6; i++) {
            int sum = 0;
            for(int j = 0; j < 6; j++) {
                sum += matrix[i][j];
            }

            if(sum % 2 == 1) {
                row = i;
                break;
            }
        }

        // Cari kolom yang jumlah 1-nya ganjil
        int col = -1;
        for(int j = 0; j < 6; j++) {
            int sum = 0;
            for(int i = 0; i < 6; i++) {
                sum += matrix[i][j];
            }

            if(sum % 2 == 1) {
                col = j;
                break;
            }
        }

        // Output hasil
        if(row != -1 && col != -1) {
            System.out.println("The flipped cell is at " + row + ", " + col);
        } else{
            System.out.println("No flipped cell found");
        }

        input.close();
    }
}
