package pbo25.week_2;

public class lab2no2 {
    private String id;
    private String nama;
    private int stok;
    private double harga;

    public lab2no2(String id, String nama, int stok, double harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public boolean isTersedia() {
        return stok > 0;
    }

    public void tampilkanInfo() {
        System.out.println("ID Produk: " + id);
        System.out.println("Nama Produk: " + nama);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Tersedia: " + (isTersedia() ? "Ya" : "Tidak"));
    }

    public static void main(String[] args) {
        lab2no2 produk1 = new lab2no2("P001", "Buku Tulis", 50, 12500.0);

        produk1.tampilkanInfo();

        System.out.println("\nApakah produk tersedia? " + produk1.isTersedia());
    }
}
