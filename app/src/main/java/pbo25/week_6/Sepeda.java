package pbo25.week_6;

import java.util.Date;
import java.util.Calendar;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda; // inci
    private double kecepatan;

    public Sepeda(String merek, String model, int tahunProduksi, String warna,
                  String jenisSepeda, int jumlahGear, int ukuranRoda) {
        super(merek, model, tahunProduksi, warna);
        this.jenisSepeda = jenisSepeda;
        this.jumlahGear = jumlahGear;
        this.ukuranRoda = ukuranRoda;
        this.kecepatan = 0;
    }

    // getters & setters...
    public String getJenisSepeda() { return jenisSepeda; }
    public void setJenisSepeda(String j) { this.jenisSepeda = j; }
    public int getJumlahGear() { return jumlahGear; }
    public void setJumlahGear(int j) { this.jumlahGear = j; }
    public int getUkuranRoda() { return ukuranRoda; }
    public void setUkuranRoda(int u) { this.ukuranRoda = u; }

    @Override
    public double hitungPajak() {
        // Sepeda mungkin tidak kena pajak, return 0
        return 0;
    }

    @Override
    public String getTipeKendaraan() {
        return "Sepeda";
    }

    // IBergerak
    @Override
    public boolean mulai() {
        System.out.println("Mulai kayuh sepeda.");
        kecepatan = 2;
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Berhenti, injak rem sepeda.");
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
        System.out.println("Cek rem, ban, dan rantai sepeda.");
        return true;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Servis sepeda di bengkel sepeda.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 6);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        return 150000; // 0.15 juta
    }
}
