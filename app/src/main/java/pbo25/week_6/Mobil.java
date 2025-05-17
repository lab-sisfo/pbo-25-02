package main.java.pbo25.week_6;
import java.util.Date;

public class Mobil extends Kendaraan implements IBergerak, IServisable {
    private int jumlahPintu;
    private double kapasitasMesin;
    private double kecepatan;
    private boolean statusServis;
    private Date tanggalServis;

    public Mobil(String id, String merek, String model, int tahunProduksi, int jumlahPintu) {
        super(id, merek, model, tahunProduksi);
        this.jumlahPintu = jumlahPintu;
        this.kecepatan = 0;
        this.statusServis = false;
        this.tanggalServis = new Date();
    }

    @Override
    public boolean maju() {
        return kecepatan > 0;
    }

    @Override
    public boolean berhenti() {
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

    @Override
    public boolean getStatusServis() {
        return statusServis;
    }

    @Override
    public void lakukanServis() {
        statusServis = true;
        tanggalServis = new Date();
    }

    @Override
    public Date getTanggalServisBerikutnya() {
        return tanggalServis;
    }

    @Override
    public double hitungBiayaServis() {
        return 500_000;
    }

    @Override
    public String getJenisKendaraan() {
        return "Mobil";
    }
}
