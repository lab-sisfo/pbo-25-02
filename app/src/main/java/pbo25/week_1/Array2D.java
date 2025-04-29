package pbo25.week_1;

import java.util.Scanner;

public class Array2D {
    public static void main(String[] args) {
        int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        System.out.println("Array 2D:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Masukkan angka yang ingin dicari: ");
            int target = scanner.nextInt();

            boolean found = false;
            for (int i = 0; i < matrix.length; i++) { 
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == target) {
                        System.out.println("Angka " + target + " ditemukan di posisi: [" + i + "][" + j + "]");
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            if (!found) {
                System.out.println("Angka " + target + " tidak ditemukan dalam array.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}