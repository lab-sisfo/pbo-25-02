package pbo25.week_6;

import java.util.Date;
import java.util.Calendar;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda;
    private String tipeKendaraan;
    private boolean bergerak;
    private double kecepatan;
    private int kondisiSepeda = 100;
    private Date tanggalServisTerakhir;

    public Sepeda(String merek, String model) {
        super(merek, model);
    }

    @Override
    public double hitungPajak() {
        // Sepeda biasanya tidak kena pajak
        return 0;
    }

    public void setTipeKendaraan(String tipe) {
        this.tipeKendaraan = tipe;
    }
    @Override
    public String getTipeKendaraan() {
        return tipeKendaraan;
    }

    @Override
    public boolean mulai() {
        if (!bergerak) {
            bergerak = true;
            kecepatan = 5.0; // kecepatan awal mengayuh sepeda
            System.out.println("Sepeda " + getMerek() + " " + getModel() + " mulai bergerak");
            kondisiSepeda -= 1; // kondisi menurun 1 setiap kali sepeda digunakan
            return true;
        } else {
            System.out.println("Sepeda sudah bergerak");
            return false;
        }
    }

    @Override
    public boolean berhenti() {
        if (bergerak) {
            bergerak = false;
            kecepatan = 0;
            System.out.println("Sepeda " + getMerek() + " " + getModel() + " berhenti");
            return true;
        } else {
            System.out.println("Sepeda sudah berhenti");
            return false;
        }
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        if (kecepatan >= 0 && kecepatan <= 60) { // Anggap kecepatan maksimal sepeda adalah 60 km/jam
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan sepeda diatur ke " + kecepatan + " km/jam");
        } else {
            System.out.println("Kecepatan tidak valid. Kecepatan harus antara 0-60 km/jam");
        }
    }

    @Override
    public boolean periksaKondisi() {
        System.out.println("Memeriksa kondisi sepeda " + getMerek() + " " + getModel());

        // Menentukan apakah sepeda perlu diservis berdasarkan kondisinya
        if (kondisiSepeda < 60) {
            System.out.println("Sepeda perlu diservis segera. Kondisi: " + kondisiSepeda + "%");
            return false;
        } else {
            System.out.println("Kondisi sepeda masih baik: " + kondisiSepeda + "%");
            return true;
        }
    }

    @Override
    public void lakukanServis() {
        if (kondisiSepeda < 90) {
            System.out.println("Melakukan servis pada sepeda " + getMerek() + " " + getModel());
            // Reset kondisi sepeda setelah diservis
            kondisiSepeda = 100;
            tanggalServisTerakhir = new Date();
            System.out.println("Servis selesai. Kondisi sepeda sekarang: " + kondisiSepeda + "%");
        } else {
            System.out.println("Sepeda masih dalam kondisi baik, tidak perlu melakukan servis. Kondisi sepeda: "
                    + kondisiSepeda + "%");
        }
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        // Memeriksa kondisi sepeda sebelum menghitung waktu servis berikutnya
        if (kondisiSepeda > 90) {
            System.out.println("Servis tidak diperlukan. Kondisi sepeda masih baik: " + kondisiSepeda + "%");
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
        if (kondisiSepeda >= 90) {
            System.out.println("Servis tidak diperlukan. Kondisi sepeda masih baik. " + kondisiSepeda + "%");
            return 0;
        } else {
            double biayaDasar = 150000; // Biaya dasar servis sepeda
            // Biaya tambahan berdasarkan jenis sepeda
            double biayaTambahan = 0.0;

            if (jenisSepeda != null) {
                switch (jenisSepeda.toLowerCase()) {
                    case "gunung":
                        biayaTambahan = 100000.0;
                        break;
                    case "balap":
                        biayaTambahan = 150000.0;
                        break;
                    case "bmx":
                        biayaTambahan = 75000.0;
                        break;
                    default:
                        System.out.println("Jenis sepeda tidak valid");
                        break;
                }
            }

            // Biaya tambahan berdasarkan kondisi sepeda
            double biayaKondisi = (100 - kondisiSepeda) * 5000.0;

            double totalBiaya = biayaDasar + biayaTambahan + biayaKondisi;
            System.out.println("Estimasi biaya servis: Rp " + totalBiaya);

            return totalBiaya;
        }
    }

    // setter getter
    public String getJenisSepeda() {
        return jenisSepeda;
    }

    public void setJenisSepeda(String jenisSepeda) {
        this.jenisSepeda = jenisSepeda;
    }

    public int getJumlahGear() {
        return jumlahGear;
    }

    public void setJumlahGear(int jumlahGear) {
        this.jumlahGear = jumlahGear;
    }

    public int getUkuranRoda() {
        return ukuranRoda;
    }

    public void setUkuranRoda(int ukuranRoda) {
        this.ukuranRoda = ukuranRoda;
    }
}