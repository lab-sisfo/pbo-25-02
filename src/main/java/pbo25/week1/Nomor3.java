import java.util.Scanner;

public class Nomor3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan tanggal dalam format dd-mm-yy: ");
        String date = input.nextLine();
        input.close();

        // Cek format input minimal harus 8 karakter (dd-mm-yy)
        if (date.length() != 8 || date.charAt(2) != '-' || date.charAt(5) != '-') {
            System.out.println("Format tanggal salah! Gunakan format dd-mm-yy.");
            return;
        }

        String[] listBulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", 
                              "Agustus", "September", "Oktober", "November", "Desember"};

        try {
            // Ambil bagian tanggal, bulan, dan tahun dari input
            int tanggal = Integer.parseInt(date.substring(0, 2)); // 2 digit pertama
            int bulan = Integer.parseInt(date.substring(3, 5));   // 2 digit tengah
            int tahun = Integer.parseInt(date.substring(6, 8));   // 2 digit terakhir

            // Konversi tahun ke 4 digit
            tahun += (tahun >= 26) ? 1900 : 2000;

            // Validasi bulan
            if (bulan < 1 || bulan > 12) {
                System.out.println("Bulan tidak valid!");
                return;
            }

            // Menghilangkan nol di depan tanggal (misalnya 01 jadi 1)
            String namaBulan = listBulan[bulan - 1];

            // Daftar jumlah hari tiap bulan
            int[] hariDalamBulan = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
            };

            // Cek tahun Kabisat Februari
            if (bulan == 2 && ((tahun % 4 == 0 && tahun % 100 != 0 ) || (tahun % 400 == 0))) {
                hariDalamBulan[1] = 29;
            }

            // Validasi tanggal
            if (tanggal < 1 || tanggal > hariDalamBulan [bulan - 1]) {
                System.out.println("Tanggal tidak valid untuk bulan tersebut");
                return;
            }

            System.out.println(tanggal + " " + namaBulan + " " + tahun);
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka dalam format dd-mm-yy!");
        }
    }
}
