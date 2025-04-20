public class Main{
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.setAlamat("Tamalanrea Indah", "Makassar");

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setAlamat(alamat);
        mahasiswa.setNama("Gatri");
        mahasiswa.setNim("H071241054");

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("NIM: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}

class Alamat{
    String jalan, kota;

    public void setAlamat(String jalan, String kota) {
        this.jalan = jalan;
        this.kota = kota;
    }

    public String getAlamat() {
        return jalan + ", " + kota;
    }
}

class Mahasiswa {
    String nama, nim;
    Alamat alamat;

    public void setAlamat(Alamat alamat) {
        this.alamat = alamat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public String getAlamat() {
        return alamat.getAlamat();
    }
}