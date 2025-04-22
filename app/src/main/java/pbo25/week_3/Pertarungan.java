package pbo25.week_3;

import java.util.Scanner;

public class Pertarungan {
    public static void mulai(SapuEmak e1, SapuEmak e2) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n=== PERTARUNGAN DIMULAI! ===\n");

        e1.tampilStatus();
        e2.tampilStatus();

        int giliran = 1;
        while (giliran <= 5) { // Pertarungan hanya sampai babak 5
            System.out.println("\n>> BABAK " + giliran);
            if (giliran % 2 == 1) {
                e1.serang(e2);
            } else {
                e2.serang(e1);
            }

            e1.tampilStatus();
            e2.tampilStatus();

            System.out.println("Klik enter untuk lanjut...");
            input.nextLine();
            giliran++;
        }

        // Tentukan pemenang berdasarkan siapa yang HP-nya lebih banyak
        System.out.println("=== GAME OVER ===");
        if (e1.isAlive() && !e2.isAlive()) {
            System.out.println(e1.getNama() + " MENANG!!!");
        } else if (e2.isAlive() && !e1.isAlive()) {
            System.out.println(e2.getNama() + " MENANG!!!");
        } else if (e1.isAlive() && e2.isAlive()) {
            if (e1.getKesehatan() > e2.getKesehatan()) {
                System.out.println(e1.getNama() + " MENANG!!!");
            } else if (e2.getKesehatan() > e1.getKesehatan()) {
                System.out.println(e2.getNama() + " MENANG!!!");
            } else {
                System.out.println("DRAW, keduanya memiliki HP yang sama!");
            }
        } else {
            System.out.println("Keduanya KALAH, tidak ada pemenang!");
        }

        input.close();
    }
}
