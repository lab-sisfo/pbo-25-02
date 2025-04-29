package pbo25.week_1;

import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        System.out.print("Masukan Judul Film = ");
        Scanner input = new Scanner(System.in);
        String judul = input.nextLine();
        input.close();

        String[] kalimat = judul.split("\\s");

        for (int i = 0; i < kalimat.length; i++) {
            if (!kalimat[i].isEmpty()) {
                kalimat[i] = kalimat[i].substring(0, 1).toUpperCase() + kalimat[i].substring(1).toLowerCase();
            }
        }
        System.out.println(String.join(" ", kalimat));
    }
}
