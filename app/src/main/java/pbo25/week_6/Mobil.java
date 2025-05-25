package pbo25.week_6;

import java.util.Date;
import java.util.Calendar;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPintu;
    private double kapasitasMesin; // cc
    private int jumlahKursi;
    private String bahanBakar;
    private double kecepatan;

    public Mobil(String merek, String model, int tahunProduksi,
                 String warna, int jumlahPintu, double kapasitasMesin,
                 int jumlahKursi, String bahanBakar) {
        super(merek, model, tahunProduksi, warna);
        this.jumlahPintu = jumlahPintu;
        this.kapasitasMesin = kapasitasMesin;
        this.jumlahKursi = jumlahKursi;
        this.bahanBakar = bahanBakar;
        this.kecepatan = 0;
    }

    // getters & setters...
    public int getJumlahPintu() { return jumlahPintu; }
    public void setJumlahPintu(int j) { this.jumlahPintu = j; }
    public double getKapasitasMesin() { return kapasitasMesin; }
    public void setKapasitasMesin(double k) { this.kapasitasMesin = k; }
    public int getJumlahKursi() { return jumlahKursi; }
    public void setJumlahKursi(int j) { this.jumlahKursi = j; }
    public String getBahanBakar() { return bahanBakar; }
    public void setBahanBakar(String b) { this.bahanBakar = b; }

    @Override
    public double hitungPajak() {
        // contoh: pajak berdasarkan kapasitas mesin
        return kapasitasMesin * 1000;
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
    }

    // IBergerak
    @Override
    public boolean mulai() {
        System.out.println("Mobil " + merek + " mesin dinyalakan.");
        kecepatan = 10;
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Mobil berhenti, mesin dimatikan.");
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
        System.out.println("Pemeriksaan kondisi mobil.");
        return true;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Servis rutin di bengkel mobil.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        return 500000; // 0.5 juta
    }
}
