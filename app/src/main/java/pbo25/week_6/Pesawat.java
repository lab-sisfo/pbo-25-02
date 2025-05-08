package pbo25.week_6;

import java.util.Calendar;
import java.util.Date;

public class Pesawat extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPenumpang;
    private double kapasitasBagasi; // dalam kg
    private double kecepatan;       // km/jam

    public Pesawat(String merek, String model, int tahunProduksi, String warna,
                   int jumlahPenumpang, double kapasitasBagasi) {
        super(merek, model, tahunProduksi, warna);
        this.jumlahPenumpang = jumlahPenumpang;
        this.kapasitasBagasi = kapasitasBagasi;
        this.kecepatan = 0;
    }

    // getters & setters
    public int getJumlahPenumpang() { return jumlahPenumpang; }
    public void setJumlahPenumpang(int j) { this.jumlahPenumpang = j; }
    public double getKapasitasBagasi() { return kapasitasBagasi; }
    public void setKapasitasBagasi(double k) { this.kapasitasBagasi = k; }

    @Override
    public double hitungPajak() {
        // Pajak berdasarkan jumlah penumpang dan kapasitas bagasi
        return (jumlahPenumpang * 60000) + (kapasitasBagasi * 2500);
    }

    @Override
    public String getTipeKendaraan() {
        return "Pesawat";
    }

    // IBergerak
    @Override
    public boolean mulai() {
        System.out.println("Pesawat menghidupkan mesin dan mulai lepas landas.");
        kecepatan = 300;
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Pesawat mendarat dan berhenti di apron.");
        kecepatan = 0;
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    // IServiceable
    @Override
    public boolean periksaKondisi() {
        System.out.println("Melakukan inspeksi pra-penerbangan.");
        return true;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Pesawat masuk hanggar untuk perawatan menyeluruh.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 6);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        return 20000000; // Rp 20 juta
    }
}
