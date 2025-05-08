import java.util.Date;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda;
    private double kecepatan;

    public Sepeda(String merek, String model) {
        super(merek, model);
        this.jenisSepeda = "Gunung";
        this.jumlahGear = 6;
        this.ukuranRoda = 26;
    }

    public String getJenisSepeda() {
        return jenisSepeda;
    }

    public void setJenisSepeda(String jenis) {
        this.jenisSepeda = jenis;
    }

    public int getJumlahGear() {
        return jumlahGear;
    }

    public void setJumlahGear(int jumlah) {
        this.jumlahGear = jumlah;
    }

    public int getUkuranRoda() {
        return ukuranRoda;
    }

    public void setUkuranRoda(int ukuran) {
        this.ukuranRoda = ukuran;
    }

    @Override
    public double hitungPajak() {
        return 100000;
    }

    @Override
    public String getTipeKendaraan() {
        return "Sepeda";
    }

    @Override
    public boolean mulai() {
        System.out.println("Sepeda " + merek + " " + model + " siap digunakan");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Sepeda " + merek + " " + model + " berhenti");
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
        System.out.println("Kecepatan sepeda diatur menjadi " + kecepatan + " km/jam");
    }

    @Override
    public boolean periksaKondisi() {
        System.out.println("Memeriksa kondisi sepeda...");
        return Math.random() > 0.1; 
    }

    @Override
    public void lakukanServis() {
        System.out.println("Melakukan servis sepeda...");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(System.currentTimeMillis() + 90L * 24 * 60 * 60 * 1000); 
    }

    @Override
    public double hitungBiayaServis() {
        return 100000;
    }
}