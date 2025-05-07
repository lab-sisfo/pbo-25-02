package pbo25.week_6;

import java.util.Calendar;
import java.util.Date;

public class Motor extends Kendaraan implements IBergerak, IServiceable {
    private String jenisMotor;
    private double kapasitasTangki;
    private String tipeSuspensi;
    private String tipeKendaraan;
    private boolean bergerak;
    private double kecepatan;
    private int kondisiMotor = 100;
    private Date tanggalServisTerakhir;

    public Motor(String merek, String model) {
        super(merek, model);
    }

    public void setTipeKendaraan(String tipe) {
        this.tipeKendaraan = tipe;
    }

    @Override
    public String getTipeKendaraan() {
        return tipeKendaraan;
    }

    @Override
    public double hitungPajak() {
        if ("Matic".equals(jenisMotor) || "Bebek".equals(jenisMotor)) {
            return 300000.0;
        } else if ("Sport".equals(jenisMotor)) {
            return 900000.0;
        } else if ("Moge".equals(jenisMotor)) {
            return 2000000.0;
        }
        return 0;
    }

    @Override
    public boolean mulai() {
        if (!bergerak) {
            bergerak = true;
            kecepatan = 10; // kecepatan awal motor
            System.out.println("Mobil " + getMerek() + " " + getModel() + " mulai bergerak");
            kondisiMotor -= 3; // kondisi menurun 3 setiap kali motor digunakan
            return true;
        } else {
            System.out.println("Mobil sudah bergerak");
            return false;
        }
    }

    @Override
    public boolean berhenti() {
        if (bergerak) {
            bergerak = false;
            kecepatan = 0;
            System.out.println("Motor " + getMerek() + " " + getModel() + " berhenti");
            return true;
        } else {
            System.out.println("Motor sudah berhenti");
            return false;
        }
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        if (kecepatan >= 0 && kecepatan <= 150) { // Anggap kecepatan maksimal motor adalah 150 km/jam
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan motor diatur ke " + kecepatan + " km/jam");
        } else {
            System.out.println("Kecepatan tidak valid. Kecepatan harus antara 0-150 km/jam");
        }
    }

    @Override
    public boolean periksaKondisi() {
        System.out.println("Memeriksa kondisi motor " + getMerek() + " " + getModel());

        // Menentukan apakah motor perlu diservis berdasarkan kondisinya
        if (kondisiMotor < 60) {
            System.out.println("Mobil perlu diservis segera. Kondisi: " + kondisiMotor + "%");
            return false;
        } else {
            System.out.println("Kondisi motor masih baik: " + kondisiMotor + "%");
            return true;
        }
    }

    @Override
    public void lakukanServis() {
        if (kondisiMotor < 90) {
            System.out.println("Melakukan servis pada motor " + getMerek() + " " + getModel());
            // Reset kondisi motor setelah diservis
            kondisiMotor = 100;
            tanggalServisTerakhir = new Date();
            System.out.println("Servis selesai. Kondisi motor sekarang: " + kondisiMotor + "%");
        } else {
            System.out.println("Motor masih dalam kondisi baik, tidak perlu melakukan servis. Kondisi motor: "
                    + kondisiMotor + "%");
        }
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        // Memeriksa kondisi motor sebelum menghitung waktu servis berikutnya
        if (kondisiMotor >= 90) {
            System.out.println("Servis tidak diperlukan. Kondisi motor masih baik: " + kondisiMotor + "%");
            return null;
        } else {
            // Menghitung waktu servis berikutnya (6 bulan setelah servis terakhir)
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tanggalServisTerakhir);
            calendar.add(Calendar.MONTH, 6);

            Date waktuServisBerikutnya = calendar.getTime();
            System.out.println("Waktu servis berikutnya: " + waktuServisBerikutnya);

            return waktuServisBerikutnya;
        }
    }

    @Override
    public double hitungBiayaServis() {
        if (kondisiMotor >= 90) {
            System.out.println("Motor masih dalam kondisi baik. Kondisi motor: " + kondisiMotor + "%.");
            return 0;
        } else {
            double biayaDasar = 85000; // Biaya dasar servis motor
            double biayaTambahan = 0.0;

            // Switch-case untuk jenisMotor
            switch (jenisMotor) {
                case "Matic":
                    // Switch-case untuk tipeSuspensi
                    switch (tipeSuspensi.toLowerCase()) {
                        case "besar":
                            biayaTambahan = 150000;
                            break;
                        case "monoshock":
                            biayaTambahan = 250000;
                            break;
                        case "teleskopik":
                            biayaTambahan = 100000;
                            break;
                        default:
                            System.out.println("Tipe suspensi tidak valid untuk motor Matic");
                            break;
                    }
                    break;
                case "Bebek":
                    switch (tipeSuspensi) {
                        case "besar":
                            biayaTambahan = 150000;
                            break;
                        case "monoshock":
                            biayaTambahan = 200000;
                            break;
                        case "teleskopik":
                            biayaTambahan = 75000;
                            break;
                        default:
                            System.out.println("Tipe suspensi tidak valid untuk motor Bebek");
                            break;
                    }
                    break;
                case "Sport":
                    switch (tipeSuspensi) {
                        case "besar":
                            biayaTambahan = 300000;
                            break;
                        case "monoshock":
                            biayaTambahan = 500000;
                            break;
                        case "teleskopik":
                            biayaTambahan = 700000;
                            break;
                        default:
                            System.out.println("Tipe suspensi tidak valid untuk motor Sport");
                            break;
                    }
                    break;
                case "Moge":
                    switch (tipeSuspensi) {
                        case "besar":
                            biayaTambahan = 1000000;
                            break;
                        case "monoshock":
                        case "teleskopik":
                            biayaTambahan = 2000000;
                            break;
                        default:
                            System.out.println("Tipe suspensi tidak valid untuk motor Moge");
                            break;
                    }
                    break;
                default:
                    System.out.println("Jenis motor tidak valid");
                    break;
            }

            // Biaya tambahan berdasarkan kondisi motor
            double biayaKondisi = (100 - kondisiMotor) * 5000;

            // Total biaya servis
            double totalBiaya = biayaDasar + biayaTambahan + biayaKondisi;
            System.out.println("Estimasi biaya servis: Rp " + totalBiaya);

            return totalBiaya;
        }
    }

    // setters getters
    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenisMotor) {
        this.jenisMotor = jenisMotor;
    }

    public double getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setKapasitasTangki(double kapasitasTangki) {
        this.kapasitasTangki = kapasitasTangki;
    }

    public String getTipeSuspensi() {
        return tipeSuspensi;
    }

    public void setTipeSuspensi(String tipeSuspensi) {
        this.tipeSuspensi = tipeSuspensi;
    }
}
