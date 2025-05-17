package pbo25.week_6;

import java.util.Date;
import java.util.Calendar;

public class Motor extends Kendaraan implements IBergerak, IServiceable {
    private String jenisMotor;
    private double kapasitasTangki; // liter
    private String tipeSuspensi;
    private double kecepatan;

    public Motor(String merek, String model, int tahunProduksi, String warna,
                 String jenisMotor, double kapasitasTangki, String tipeSuspensi) {
        super(merek, model, tahunProduksi, warna);
        this.jenisMotor = jenisMotor;
        this.kapasitasTangki = kapasitasTangki;
        this.tipeSuspensi = tipeSuspensi;
        this.kecepatan = 0;
    }

    // getters & setters...
    public String getJenisMotor() { return jenisMotor; }
    public void setJenisMotor(String j) { this.jenisMotor = j; }
    public double getKapasitasTangki() { return kapasitasTangki; }
    public void setKapasitasTangki(double k) { this.kapasitasTangki = k; }
    public String getTipeSuspensi() { return tipeSuspensi; }
    public void setTipeSuspensi(String t) { this.tipeSuspensi = t; }

    @Override
    public double hitungPajak() {
        return kapasitasTangki * 2000;
    }

    @Override
    public String getTipeKendaraan() {
        return "Motor";
    }

    // IBergerak
    @Override
    public boolean mulai() {
        System.out.println("Motor dinyalakan, siap jalan.");
        kecepatan = 5;
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Motor berhenti, mesin off.");
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
        System.out.println("Cek kondisi motor.");
        return true;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Servis motor di bengkel.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 4);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        return 300000; // 0.3 juta
    }
}
