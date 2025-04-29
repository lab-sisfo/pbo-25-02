package pbo25.week_2;

import java.util.Scanner;

public class Nomor2 {
    String ID;
    String nama;
    int stok;
    double harga;

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getStok() {
        return stok;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getHarga() {
        return harga;
    }

    public boolean cekStok() {
        return stok > 0;
    }

    public void tampilkanInfo() {
        System.out.println("ID Produk: " + ID);
        System.out.println("Nama Produk" + nama);
        System.out.println("Stok Produk: " + stok);
        System.out.println("Harga Produk: " + harga);
        System.out.println("Tersedia: " + (cekStok() ? "Ya" : "Tidak"));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Nomor2 produk = new Nomor2();

        System.out.println("Masukkan ID Produk: ");
        produk.setID(input.nextLine());

        System.out.println("Masukkan Nama Produk: ");
        produk.setNama(input.nextLine());

        System.out.println("Masukkan Stok Produk: ");
        produk.setStok(input.nextInt());

        System.out.println("Masukkan Harga Produk: ");
        produk.setHarga(input.nextDouble());

        produk.tampilkanInfo();

        input.close();
    }
}
