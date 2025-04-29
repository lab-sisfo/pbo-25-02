package pbo25.week_1;

import java.util.Scanner;

public class No3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("tanggal = ");
        String[] tanggal = input.nextLine().split("-");
        input.close();
        String[] namaBulan = {
                "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        int hari = Integer.parseInt(tanggal[0]);
        int bulan = Integer.parseInt(tanggal[1]);
        int tahun = Integer.parseInt(tanggal[2]);

        if (tahun < 30) {
            tahun = 2000 + tahun;
        } else {
            tahun = 1900 + tahun;
        }

        if (bulan < 1 || bulan > 12) {
            System.out.println("Bulan tidak valid!");
            return;
        }

        int maxHari = 31;
        if (bulan == 4 || bulan == 6 || bulan == 9 || bulan == 11) {
            maxHari = 30;
        } else if (bulan == 2) {
            if ((tahun % 400 == 0) || (tahun % 100 != 0 && tahun % 4 == 0)) {
                maxHari = 29;
            } else {
                maxHari = 28;
            }
        }

        if (hari < 1 || hari > maxHari) {
            System.out.println("Tanggal tidak valid untuk bulan tersebut!");
            return;
        }

        System.out.println(hari + " " + namaBulan[bulan - 1] + " " + tahun);
    }
}
