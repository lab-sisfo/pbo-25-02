package pbo25.week_6;

import java.util.Calendar;
import java.util.Date;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;
    private String tipeKendaraan;
    private int kondisiMobil = 100;
    private Date tanggalServisTerakhir;
    private boolean bergerak;
    private double kecepatan;

    public Mobil(String merek, String model) {
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
        return 3000000;
    }

    @Override
    public boolean mulai() {
        if (!bergerak) {
            bergerak = true;
            kecepatan = 10; // kecepatan awal mobil
            System.out.println("Mobil " + getMerek() + " " + getModel() + " mulai bergerak");
            kondisiMobil -= 5; // kondisi menurun 5 setiap kali mobil digunakan
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
            System.out.println("Mobil " + getMerek() + " " + getModel() + " berhenti");
            return true;
        } else {
            System.out.println("Mobil sudah berhenti");
            return false;
        }
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        if (kecepatan >= 0 && kecepatan <= 300) { // Anggap kecepatan maksimal mobil adalah 300 km/jam
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan mobil diatur ke " + kecepatan + " km/jam");
        } else {
            System.out.println("Kecepatan tidak valid. Kecepatan harus antara 0-300 km/jam");
        }
    }

    @Override
    public boolean periksaKondisi() {
        System.out.println("Memeriksa kondisi mobil " + getMerek() + " " + getModel());

        // Menentukan apakah mobil perlu diservis berdasarkan kondisinya
        if (kondisiMobil < 60) {
            System.out.println("Mobil perlu diservis segera. Kondisi: " + kondisiMobil + "%");
            return false;
        } else {
            System.out.println("Kondisi mobil masih baik: " + kondisiMobil + "%");
            return true;
        }
    }

    @Override
    public void lakukanServis() {
        if (kondisiMobil < 90) {
            System.out.println("Melakukan servis pada mobil " + getMerek() + " " + getModel());
            // Reset kondisi mobil setelah diservis
            kondisiMobil = 100;
            tanggalServisTerakhir = new Date();
            System.out.println("Servis selesai. Kondisi mobil sekarang: " + kondisiMobil + "%");
        } else {
            System.out.println("Sepeda masih dalam kondisi baik, tidak perlu melakukan servis. Kondisi mobil: "
                    + kondisiMobil + "%");
        }
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        // Memeriksa kondisi mobil sebelum menghitung waktu servis berikutnya
        if (kondisiMobil >= 90) {
            System.out.println("Servis tidak diperlukan. Kondisi Mobil masih baik: " + kondisiMobil + "%");
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
        if (kondisiMobil >= 90) {
            System.out.println("Mobil tidak memerlukan servis. Kondisi mobil masih baik: " + kondisiMobil + "%.");
            return 0;
        } else {
            double biayaDasar = 800000;// Biaya dasar servis mobil

            // Biaya tambahan berdasarkan kondisi mobil
            double biayaKondisi = (100 - kondisiMobil) * 80000;

            double totalBiaya = biayaDasar + biayaKondisi;
            System.out.println("Estimasi biaya servis: Rp " + totalBiaya);

            return totalBiaya;
        }
    }

    // setter and getter
    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(double kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

}
