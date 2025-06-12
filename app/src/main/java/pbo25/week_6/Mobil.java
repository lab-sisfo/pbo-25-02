import java.util.Date;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;
    private double kecepatan;

    public Mobil(String merek, String model) {
        super(merek, model);
        this.jumlahPintu = 4;
        this.kapasitasMesin = 1.5;
        this.jumlahKursi = 5;
        this.bahanBakar = "Bensin";
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlah) {
        this.jumlahPintu = jumlah;
    }

    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(double kapasitas) {
        this.kapasitasMesin = kapasitas;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlah) {
        this.jumlahKursi = jumlah;
    }

    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    @Override
    public double hitungPajak() {
        return kapasitasMesin * 1000000;
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
    }

    @Override
    public boolean mulai() {
        System.out.println("Mobil " + merek + " " + model + " dinyalakan");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Mobil " + merek + " " + model + " dimatikan");
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
        System.out.println("Kecepatan mobil diatur menjadi " + kecepatan + " km/jam");
    }

    @Override
    public boolean periksaKondisi() {
        System.out.println("Memeriksa kondisi mobil...");
        return Math.random() > 0.2; 
    }

    @Override
    public void lakukanServis() {
        System.out.println("Melakukan servis mobil...");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000); 
    }

    @Override
    public double hitungBiayaServis() {
        return 500000 + (kapasitasMesin * 200000);
    }
}