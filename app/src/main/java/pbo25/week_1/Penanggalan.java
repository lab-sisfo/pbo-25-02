package pbo25.week_1;

import java.util.Scanner;

public class Penanggalan{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan tanggal (format: dd-mm-yyyy atau dd-mm-yy): ");
        String input = scanner.nextLine();

        String[] bulan = {
            "Januari", "Februari", "Maret", "April", "Mei", 
            "Juni", "Juli", "Agustus", "September", 
            "Oktober", "November", "Desember"
        };

        int[] jmlHari = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String[] bagianTanggal = input.split("-");
        String tanggal = "";

        if (bagianTanggal.length == 3) {
            int hari = Integer.parseInt(bagianTanggal[0]);
            int bulanIndex = Integer.parseInt(bagianTanggal[1]) - 1;
            String tahunInput = bagianTanggal[2];

            int tahun;
            if (tahunInput.length() == 2) {
                tahun = Integer.parseInt(tahunInput);
                if (tahun < 50) {
                    tahun += 2000; // Untuk tahun 00-49
                } else {
                    tahun += 1900; // Untuk tahun 50-99
                }
            } else {
                tahun = Integer.parseInt(tahunInput);
            }

            // tahun kabisatt
            if (bulanIndex == 1 && (tahun % 400 == 0 || (tahun % 4 == 0 && tahun % 100 != 0))) {
                jmlHari[1] = 29;
            }

            if (bulanIndex >= 0 && bulanIndex < bulan.length && hari > 0 && hari <= jmlHari[bulanIndex]) {
                tanggal = hari + " " + bulan[bulanIndex] + " " + tahun;
            } else {
                tanggal = "Bulan atau hari tidak valid!";
            }
        } else {
            tanggal = "Format input salah!";
        }

        System.out.println(tanggal);
        scanner.close();
    }
}