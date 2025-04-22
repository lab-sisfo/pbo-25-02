package pbo25.week_2;

public class Product {
    // Properti
    String id;
    String nama;
    int stok;
    double harga;

    // Set
    public void setId(String id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    // Get
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public double getHarga() {
        return harga;
    }

    // Method cek produk tersedia
    public boolean isTersedia() {
        return stok > 0;
    }

    // Method cetak data produk
    public void data() {
        System.out.println("ID Produk : " + id);
        System.out.println("Nama      : " + nama);
        System.out.println("Stok      : " + stok);
        System.out.println("Harga     : Rp " + harga);
        System.out.println("Tersedia  : " + (isTersedia() ? "Ya" : "Tidak"));
    }

    public static void main(String[] args) {
        Product produk = new Product();
        produk.setId("P001");
        produk.setNama("Iphone promag");
        produk.setStok(15);
        produk.setHarga(12000);

        produk.data();
    }
}
