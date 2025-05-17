package pbo25.week_3;

public class Musuh {
    String nama;
    int kesehatan;

    public Musuh(){
        this.nama = "musuh";
        this.kesehatan = 100;
    }
    public Musuh(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public void terimaSerangan(int kerusakan) {
        this.kesehatan -= kerusakan;
        if (this.kesehatan < 0) this.kesehatan = 0;
        System.out.println(nama + " terkena serangan! Kesehatan: " + this.kesehatan);
    }

    public void tampilkanStatus() {
        System.out.println("Musuh: " + nama + " | Kesehatan: " + kesehatan);
    }
}