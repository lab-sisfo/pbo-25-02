package pbo25.week_6;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        // Contoh kendaraan yang sudah ada
        Mobil mobil = new Mobil("Toyota", "Avanza", 2020, "Hitam", 4, 1500, 7, "Bensin");
        Motor motor = new Motor("Yamaha", "NMAX", 2021, "Merah", "Matic", 7.1, "Telescopic");
        Sepeda sepeda = new Sepeda("Polygon", "Heist", 2022, "Biru", "Gunung", 21, 27);

        // Tambahan: Pesawat
        Pesawat pesawat = new Pesawat("Boeing", "747", 2018, "Putih", 366, 183380);

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");

        // Cetak info dan uji fungsi setiap kendaraan
        Kendaraan[] fleet = { mobil, motor, sepeda, pesawat };

        for (Kendaraan k : fleet) {
            System.out.println("=== " + k.getTipeKendaraan() + " ===");
            System.out.println("Merek     : " + k.getMerek());
            System.out.println("Model     : " + k.getModel());
            System.out.println("Pajak     : Rp " + k.hitungPajak());

            // jika bergerak
            if (k instanceof IBergerak) {
                IBergerak ib = (IBergerak) k;
                ib.mulai();
                System.out.println("Kecepatan : " + ib.getKecepatan() + " km/jam");
                ib.berhenti();
            }

            // jika serviceable
            if (k instanceof IServiceable) {
                IServiceable is = (IServiceable) k;
                is.periksaKondisi();
                is.lakukanServis();
                System.out.println("Servis berikutnya: " + sdf.format(is.getWaktuServisBerikutnya()));
                System.out.println("Biaya servis     : Rp " + is.hitungBiayaServis());
            }

            System.out.println();
        }
    }
}
