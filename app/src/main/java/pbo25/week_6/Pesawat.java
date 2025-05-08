public class Pesawat extends Kendaraan implements IBergerak {
    private double kecepatan;
    private int kapasitasPenumpang;
    private double jarakTempuh;

    public Pesawat(String merek, String model) {
        super(merek, model);
        this.kapasitasPenumpang = 150;
        this.jarakTempuh = 0;
    }

    public int getKapasitasPenumpang() {
        return kapasitasPenumpang;
    }

    public void setKapasitasPenumpang(int kapasitas) {
        this.kapasitasPenumpang = kapasitas;
    }

    public double getJarakTempuh() {
        return jarakTempuh;
    }

    public void setJarakTempuh(double jarak) {
        this.jarakTempuh = jarak;
    }

    @Override
    public double hitungPajak() {
        return kapasitasPenumpang * 10000000;
    }

    @Override
    public String getTipeKendaraan() {
        return "Pesawat";
    }

    @Override
    public boolean mulai() {
        System.out.println("Pesawat " + merek + " " + model + " lepas landas");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Pesawat " + merek + " " + model + " mendarat");
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
        System.out.println("Kecepatan pesawat diatur menjadi " + kecepatan + " km/jam");
    }
}