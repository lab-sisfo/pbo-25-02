package pbo25.week_1;

import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Mi Angka ta'yang mau dicari = ");
        int x = input.nextInt();
        input.close();

        boolean found = false;

        try {
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == x) {
                        System.out.println("Found " + x + " at [" + i + "][" + j + "]");
                        found = true;
                    }
                }
            }

            if (!found) {
                throw new Exception("Angka tidak ditemukan");
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
