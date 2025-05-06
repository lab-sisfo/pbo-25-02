package pbo25.week_6;

// Main untuk sepeda
public class Main {
    public static void main(String[] args) {
        Sepeda sepeda = new Sepeda("Trek", "Domane ALR");

        sepeda.setJenisSepeda("Fixie");
        sepeda.setJumlahGear(20);
        sepeda.setUkuranRoda(700);
        sepeda.setKecepatan(10.0);
        sepeda.setTipeKendaraan("Kendaraan roda dua");

        // Menampilkan informasi sepeda
        System.out.println("Merek: " + sepeda.getMerek());
        System.out.println("Model: " + sepeda.getModel());
        System.out.println("Jenis Sepeda: " + sepeda.getJenisSepeda());
        System.out.println("Jumlah Gear: " + sepeda.getJumlahGear());
        System.out.println("Ukuran Roda: " + sepeda.getUkuranRoda());
        System.out.println("Kecepatan: " + sepeda.getKecepatan() + " km/jam");

        System.out.println("Pajak: Rp " + sepeda.hitungPajak());

        // Menggunakan sepeda
        sepeda.mulai();
        sepeda.setKecepatan(20);
        sepeda.berhenti();

        sepeda.periksaKondisi();

        sepeda.lakukanServis();

        sepeda.hitungBiayaServis();

        sepeda.getWaktuServisBerikutnya();
    }
}