package main.java.pbo25.week_6;
import java.util.Date;

public class Motor extends Kendaraan implements IBergerak, IServisable {
    private String jenisMotor;
    private double kapasitasTangki;
    private double kecepatan;
    private boolean statusServis;
    private Date tanggalServis;

    public Motor(String id, String merek, String model, int tahunProduksi, String jenisMotor) {
        super(id, merek, model, tahunProduksi);
        this.jenisMotor = jenisMotor;
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
        return 200_000;
    }

    @Override
    public String getJenisKendaraan() {
        return "Motor";
    }
}
