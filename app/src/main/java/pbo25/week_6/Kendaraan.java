public abstract class Kendaraan {
    protected String id;
    protected String merek;
    protected String model;
    protected int tahunProduksi;
    protected String warna;

    public Kendaraan(String id, String merek, String model, int tahunProduksi) {
        this.id = id;
        this.merek = merek;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
    }

    public abstract String getJenisKendaraan();

    public String getInfoKendaraan() {
        return id + " - " + merek + " " + model + " (" + tahunProduksi + ")";
    }
}
