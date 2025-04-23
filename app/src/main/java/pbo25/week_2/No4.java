package pbo25.week_2;

class Alamat {
    String jalan, kota;
}

class Mahasiswa {
    Alamat alamat;
    String nama, nim;

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getAlamat() {
        return alamat.jalan + ", " + alamat.kota;
    }

}

public class No4 {
    public static void main(String[] args) {
        Mahasiswa mahasiswa = new Mahasiswa();

        Alamat alamat = new Alamat();
        alamat.jalan = "Tamalanrea";
        alamat.kota = "Makassar";

        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Wahyu";
        mahasiswa.nim = "H071241089";

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Nim: " + mahasiswa.getAlamat());
    }
}
