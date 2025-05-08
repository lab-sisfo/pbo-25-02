package pbo25.week_6;

// kelas tambahan

public class Kereta extends Kendaraan implements IBergerak {
    private String nama;
    private String nomorKereta;
    private boolean bergerak;
    private double kecepatan;
    private String tipeKendaraan;
    private double jarakPerjalanan;
    private String jenisKereta;

    public Kereta(String merek, String model) {
        super(merek, model);
    }

    @Override
    public double hitungPajak() {
        if ("Jasa".equalsIgnoreCase(jenisKereta)) {
            return 1000000;
        } else if ("Sewa".equalsIgnoreCase(jenisKereta)) {
            return 550000;
        } else if ("Travel".equalsIgnoreCase(jenisKereta)) {
            double tarifPajak = 7500;
            double tarif = jarakPerjalanan * tarifPajak;
            return tarif;
        }
        return 0;
    }

    public void setTipeKendaraan(String tipe) {
        this.tipeKendaraan = tipe;
    }

    @Override
    public String getTipeKendaraan() {
        return tipeKendaraan;
    }

    // Implementasi IBergerak
    int kondisiKereta = 100;

    @Override
    public boolean mulai() {
        if (!bergerak) {
            bergerak = true;
            kecepatan = 50.0; // Kecepatan awal saat kereta mulai bergerak
            System.out.println("Kereta " + nama + " " + nomorKereta + " mulai bergerak");
            kondisiKereta -= 5; // Kondisi menurun 5 setiap kali kereta digunakan
            return true;
        } else {
            System.out.println("Kereta sudah bergerak");
            return false;
        }
    }

    @Override
    public boolean berhenti() {
        if (bergerak) {
            bergerak = false;
            kecepatan = 0.0;
            System.out.println("Kereta " + nama + " " + nomorKereta + " berhenti");
            return true;
        } else {
            System.out.println("Kereta sudah berhenti");
            return false;
        }
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        if (kecepatan >= 0 && kecepatan <= 200) { // Anggap kecepatan maksimal kereta adalah 200 km/jam
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan kereta diatur ke " + kecepatan + " km/jam");
        } else {
            System.out.println("Kecepatan tidak valid. Kecepatan harus antara 0-200 km/jam");
        }
    }

    // setters and getters
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorKereta() {
        return nomorKereta;
    }

    public void setNomorKereta(String nomorKereta) {
        this.nomorKereta = nomorKereta;
    }

    public double getJarakPerjalanan() {
        return jarakPerjalanan;
    }

    public void setJarakPerjalanan(double jarakPerjalanan) {
        this.jarakPerjalanan = jarakPerjalanan;
    }

    public String getJenisKereta() {
        return jenisKereta;
    }

    public void setJenisKereta(String jenisKereta) {
        this.jenisKereta = jenisKereta;
    }

}