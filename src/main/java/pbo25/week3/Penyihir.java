public class Penyihir {
    String nama;
    String house;
    int kesehatan;
    int kekuatanSihir;
    Ramuan ramuanFavorit;

    public Penyihir() {
        this.nama = "Tanpa Nama";
        this.house = "Tanpa House";
        this.kesehatan = 100;
        this.kekuatanSihir = 10;
        this.ramuanFavorit = new Ramuan();
    }

    public Penyihir(String nama, String house, int kesehatan, int kekuatanSihir, Ramuan ramuanFavorit) {
        this.nama = nama;
        this.house = house;
        this.kesehatan = kesehatan;
        this.kekuatanSihir = kekuatanSihir;
        this.ramuanFavorit = ramuanFavorit; 
    }

    public void serang(Musuh musuh) {
        System.out.println(nama + " menyerang " + musuh.nama + " dengan sihir!");
        musuh.terimaSerangan(kekuatanSihir);
    }

    public void duel(Penyihir lawan) {
        System.out.println(nama + " duel dengan " + lawan.nama);
        this.kesehatan -= 10;
        lawan.kesehatan -= 10;
        if (this.kesehatan < 0) this.kesehatan = 0;
        if (lawan.kesehatan < 0) lawan.kesehatan = 0;
    }

    public void gunakanRamuanFavorit() {
        this.kesehatan += ramuanFavorit.efekSembuh;
        System.out.println(nama + " menggunakan " + ramuanFavorit.nama + " dan sembuh " + ramuanFavorit.efekSembuh + " poin!");
    
    }

    public void tampilkanStatus() {
        System.out.println("Nama Penyihir   : " + nama);
        System.out.println("House           : " + house);
        System.out.println("Kesehatan       : " + kesehatan);
        System.out.println("Kekuatan Sihir  : " + kekuatanSihir);
        System.out.println("Ramuan Favorit  : " + ramuanFavorit.nama + " (+" + ramuanFavorit.efekSembuh + ")");
        System.out.println("------------------------------");
    }
}