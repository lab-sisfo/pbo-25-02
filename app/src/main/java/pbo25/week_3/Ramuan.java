package pbo25.week_3;

public class Ramuan {
    String nama;
    int efekSembuh;

    public Ramuan() {
        this.nama = "Ramuan Dasar";
        this.efekSembuh = 10;
    }

    public Ramuan(String nama, int efekSembuh) {
        this.nama = nama;
        this.efekSembuh = efekSembuh;
    }

    public void gunakan() {
        System.out.println("Ramuan " + nama + " digunakan. Menyembuhkan " + efekSembuh + " poin kesehatan.");
    }
}