import java.util.Date;

public class Motor extends Kendaraan implements IBergerak, IServiceable {
    private String jenisMotor;
    private double kapasitasTangki;
    private String tipeSuspensi;
    private double kecepatan;

    public Motor(String merek, String model) {
        super(merek, model);
        this.jenisMotor = "Bebek";
        this.kapasitasTangki = 5.0;
        this.tipeSuspensi = "Teleskopik";
    }

    
    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenis) {
        this.jenisMotor = jenis;
    }

    public double getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setKapasitasTangki(double kapasitas) {
        this.kapasitasTangki = kapasitas;
    }

    public String getTipeSuspensi() {
        return tipeSuspensi;
    }

    public void setTipeSuspensi(String tipe) {
        this.tipeSuspensi = tipe;
    }

    @Override
    public double hitungPajak() {
        return kapasitasTangki * 500000;
    }

    @Override
    public String getTipeKendaraan() {
        return "Motor";
    }

    @Override
    public boolean mulai() {
        System.out.println("Motor " + merek + " " + model + " dinyalakan");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Motor " + merek + " " + model + " dimatikan");
        this.kecepatan = 0;
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
        System.out.println("Kecepatan motor diatur menjadi " + kecepatan + " km/jam");
    }

    @Override
    public boolean periksaKondisi() {
        System.out.println("Memeriksa kondisi motor...");
        return Math.random() > 0.3; 
    }

    @Override
    public void lakukanServis() {
        System.out.println("Melakukan servis motor...");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(System.currentTimeMillis() + 60L * 24 * 60 * 60 * 1000); 
    }

    @Override
    public double hitungBiayaServis() {
        return 200000 + (kapasitasTangki * 50000);
    }
}