package pbo25.week_3;

import java.util.ArrayList;

public class Keluarga {
    private String nomorKK;
    double kekayaanBersih;
    String kepalaKeluarga;
    ArrayList<String> anggotaKeluarga;
    Rumah rumahHunian;

    public Keluarga(String nomorKK, String kepalaKeluarga, int kekayaanBersih) {
        this.nomorKK = nomorKK;
        this.kepalaKeluarga = kepalaKeluarga;
        this.kekayaanBersih = kekayaanBersih;
        this.anggotaKeluarga = new ArrayList<>();
        this.anggotaKeluarga.add(kepalaKeluarga);
    }

    public Keluarga() {
        this.anggotaKeluarga = new ArrayList<>();
    }

    public void tambahAnggota(String namaAnggota) {
        anggotaKeluarga.add(namaAnggota);
        System.out.println(namaAnggota + " ditambahkan ke KK " + nomorKK);
    }

    public void displayInfo() {
        System.out.println();
        System.out.println("=== Informasi Keluarga ===");
        System.out.println("Nomor KK: " + nomorKK);
        System.out.println("Kepala Keluarga: " + kepalaKeluarga);
        System.out.println("Kekayaan Bersih: Rp" + kekayaanBersih);
        System.out.println("Anggota Keluarga: " + String.join(", ", anggotaKeluarga));

        if (rumahHunian != null) {
            System.out.println("\n=== Rumah Hunian ===");
            rumahHunian.displayInfo();
        } else {
            System.out.println("\nStatus: Belum memiliki rumah");
        }
    }

    public String getNomorKK() {
        return nomorKK;
    }

}