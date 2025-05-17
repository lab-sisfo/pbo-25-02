package main.java.pbo25.week_6;
public class Skateboard extends Kendaraan implements IBergerak {
    private double kecepatan;

    public Skateboard(String id, String merek, String model, int tahunProduksi) {
        super(id, merek, model, tahunProduksi);
        this.kecepatan = 0;
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
    public String getJenisKendaraan() {
        return "Skateboard";
    }
}
