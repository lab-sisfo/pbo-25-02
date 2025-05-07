package pbo25.week_6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Memilih jenis kendaraan
        System.out.println("=== Pilih Kendaraan ===");
        System.out.println("1. Sepeda");
        System.out.println("2. Motor");
        System.out.println("3. Mobil");
        System.out.println("4. Kereta");
        System.out.print("Masukkan pilihan (1/2/3/4): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1) {
            // Input Sepeda
            System.out.println("\n=== Input Sepeda ===");
            System.out.print("Merek: ");
            String merekSepeda = scanner.nextLine();
            System.out.print("Model: ");
            String modelSepeda = scanner.nextLine();
            System.out.print("Jenis Sepeda(Gunung/Balap/BMX): ");
            String jenisSepeda = scanner.nextLine();
            System.out.print("Jumlah Gear: ");
            int jumlahGear = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Ukuran Roda: ");
            int ukuranRoda = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Kecepatan: ");
            double kecepatanSepeda = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            Sepeda sepeda = new Sepeda(merekSepeda, modelSepeda);
            sepeda.setJenisSepeda(jenisSepeda);
            sepeda.setJumlahGear(jumlahGear);
            sepeda.setUkuranRoda(ukuranRoda);
            sepeda.setKecepatan(kecepatanSepeda);
            sepeda.setTipeKendaraan("Kendaraan roda dua");

            // Menampilkan informasi sepeda
            System.out.println("\n=== Informasi Sepeda ===");
            System.out.println("Merek: " + sepeda.getMerek());
            System.out.println("Model: " + sepeda.getModel());
            System.out.println("Jenis Sepeda: " + sepeda.getJenisSepeda());
            System.out.println("Jumlah Gear: " + sepeda.getJumlahGear());
            System.out.println("Ukuran Roda: " + sepeda.getUkuranRoda());
            System.out.println("Kecepatan: " + sepeda.getKecepatan() + " km/jam");

            System.out.println("Pajak: Rp " + sepeda.hitungPajak());

            // Menggunakan sepeda
            sepeda.mulai();
            System.out.print("Masukkan kecepatan baru: ");
            double kecepatanBaruSepeda = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            sepeda.setKecepatan(kecepatanBaruSepeda);
            sepeda.berhenti();

            sepeda.periksaKondisi();

            sepeda.lakukanServis();

            sepeda.hitungBiayaServis();

            sepeda.getWaktuServisBerikutnya();
        } else if (pilihan == 2) {
            // Input Motor
            System.out.println("\n=== Input Motor ===");
            System.out.print("Merek: ");
            String merekMotor = scanner.nextLine();
            System.out.print("Model: ");
            String modelMotor = scanner.nextLine();
            System.out.print("Id motor: ");
            String idMotor = scanner.nextLine();
            System.out.print("Jenis Motor (Matic/Bebek/Sport/Moge)");
            String jenisMotor = scanner.nextLine();
            System.out.print("Kapasitas Tangki: ");
            double kapasitasTangki = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            System.out.print("Kecepatan: ");
            double kecepatanMotor = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            System.out.print("Tahun Produksi: ");
            int tahunProduksi = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Tipe Suspensi (Besar/Monoshock/Teleskopik): ");
            String tipeSuspensi = scanner.nextLine();
            System.out.print("Warna: ");
            String warna = scanner.nextLine();

            Motor motor = new Motor(merekMotor, modelMotor);
            motor.setId(idMotor);
            motor.setJenisMotor(jenisMotor);
            motor.setKapasitasTangki(kapasitasTangki);
            motor.setKecepatan(kecepatanMotor);
            motor.setTahunProduksi(tahunProduksi);
            motor.setTipeSuspensi(tipeSuspensi);
            motor.setWarna(warna);

            // Menampilkan informasi motor
            System.out.println("\n=== Informasi Motor ===");
            System.out.println("Merek: " + motor.getMerek());
            System.out.println("Model: " + motor.getModel());
            System.out.println("Jenis Motor: " + motor.getJenisMotor());
            System.out.println("Id motor: " + motor.getId());
            System.out.println("Tipe suspensi: " + motor.getTipeSuspensi());
            System.out.println("Kecepatan: " + motor.getKecepatan() + " km/jam");

            System.out.println("Pajak: Rp " + motor.hitungPajak());

            // Menggunakan motor
            motor.mulai();
            System.out.print("Masukkan kecepatan baru: ");
            double kecepatanBaruMotor = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            motor.setKecepatan(kecepatanBaruMotor);
            motor.berhenti();

            motor.periksaKondisi();

            motor.lakukanServis();

            motor.hitungBiayaServis();

            motor.getWaktuServisBerikutnya();

        } else if (pilihan == 3) {
            System.out.println("\n=== Input Mobil ===");
            System.out.print("Merek: ");
            String merekMobil = scanner.nextLine();
            System.out.print("Model: ");
            String modelMobil = scanner.nextLine();
            System.out.print("Bahan bakar: ");
            String bahanBakar = scanner.nextLine();
            System.out.print("Jumlah Pintu: ");
            int pintu = scanner.nextInt();
            System.out.print("Jumlah Kursi: ");
            int kursi = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Kecepatan: ");
            double kecepatanMobil = scanner.nextDouble();

            Mobil mobil = new Mobil(merekMobil, modelMobil);
            mobil.setBahanBakar(bahanBakar);
            mobil.setJumlahPintu(pintu);
            mobil.setJumlahKursi(kursi);
            mobil.setKecepatan(kecepatanMobil);

            // Menampilkan informasi mobil
            System.out.println("\n=== Informasi Mobil ===");
            System.out.println("Merek: " + mobil.getMerek());
            System.out.println("Model: " + mobil.getModel());
            System.out.println("Bahan Bakar Mobil: " + mobil.getBahanBakar());
            System.out.println("Jumlah pintu: " + mobil.getJumlahPintu());
            System.out.println("Jumlah kursi: " + mobil.getJumlahKursi());
            System.out.println("Kecepatan: " + mobil.getKecepatan() + " km/jam");

            System.out.println("Pajak: Rp " + mobil.hitungPajak());

            // Menggunakan motor
            mobil.mulai();
            System.out.print("Masukkan kecepatan baru: ");
            double kecepatanBaruMobil = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            mobil.setKecepatan(kecepatanBaruMobil);
            mobil.berhenti();

            mobil.periksaKondisi();

            mobil.lakukanServis();

            mobil.hitungBiayaServis();

            mobil.getWaktuServisBerikutnya();

        } else if (pilihan == 4) {
            System.out.println("\n=== Input Kereta ===");
            System.out.print("Merek: ");
            String merekKereta = scanner.nextLine();
            System.out.print("Model: ");
            String modelKereta = scanner.nextLine();
            System.out.print("Nama Kereta: ");
            String nama = scanner.nextLine();
            System.out.print("Jarak Perjalanan: ");
            double jarak = scanner.nextDouble();
            System.out.print("Jenis Kereta (Jasa/Sewa/Travel): ");
            String jenis = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Kecepatan: ");
            double kecepatanKereta = scanner.nextDouble();

            Kereta kereta = new Kereta(merekKereta, modelKereta);
            kereta.setNama(nama);
            kereta.setJarakPerjalanan(jarak);
            kereta.setJenisKereta(jenis);
            kereta.setKecepatan(kecepatanKereta);

            // Menampilkan informasi motor
            System.out.println("\n=== Informasi Kereta ===");
            System.out.println("Merek: " + kereta.getMerek());
            System.out.println("Model: " + kereta.getModel());
            System.out.println("Nama Kereta: " + kereta.getNama());
            System.out.println("Jarak Perjalanan: " + kereta.getJarakPerjalanan());
            System.out.println("Jenis Kereta: " + kereta.getJenisKereta());
            System.out.println("Kecepatan: " + kereta.getKecepatan() + " km/jam");

            System.out.println("Pajak: Rp " + kereta.hitungPajak());

            // Menggunakan Kereta
            kereta.mulai();
            System.out.print("Masukkan kecepatan baru: ");
            double kecepatanBaruKereta = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            kereta.setKecepatan(kecepatanBaruKereta);
            kereta.berhenti();

        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}