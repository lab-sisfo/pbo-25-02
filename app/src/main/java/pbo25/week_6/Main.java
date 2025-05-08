import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
      
        Mobil mobil = new Mobil("Lamborgini", "Pete-Pete");
        Motor motor = new Motor("Honda", "Supra Getar");
        Sepeda sepeda = new Sepeda("Polygon", "Xtrada");
        Pesawat pesawat = new Pesawat("Boeing", "737");
        
        mobil.setJumlahPintu(5);
        mobil.setKapasitasMesin(1.3);
        motor.setJenisMotor("Sport");
        sepeda.setJenisSepeda("Balap");
        pesawat.setKapasitasPenumpang(200);
        
        System.out.println("Bergerak");
        testBergerak(mobil);
        testBergerak(motor);
        testBergerak(sepeda);
        testBergerak(pesawat);
        
        System.out.println("\nService");
        testService(mobil);
        testService(motor);
        testService(sepeda);
        
        System.out.println("\nInformasi Pajak");
        System.out.println("Pajak " + mobil.getTipeKendaraan() + ": Rp" + mobil.hitungPajak());
        System.out.println("Pajak " + motor.getTipeKendaraan() + ": Rp" + motor.hitungPajak());
        System.out.println("Pajak " + sepeda.getTipeKendaraan() + ": Rp" + sepeda.hitungPajak());
        System.out.println("Pajak " + pesawat.getTipeKendaraan() + ": Rp" + pesawat.hitungPajak());
    }
    
    public static void testBergerak(IBergerak kendaraan) {
        kendaraan.mulai();
        kendaraan.setKecepatan(60);
        System.out.println("Kecepatan saat ini: " + kendaraan.getKecepatan() + " km/jam");
        kendaraan.berhenti();
    }
    
    public static void testService(IServiceable kendaraan) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("\nServis " + ((Kendaraan)kendaraan).getTipeKendaraan());
        System.out.println("Kondisi baik? " + kendaraan.periksaKondisi());
        kendaraan.lakukanServis();
        System.out.println("Biaya servis: Rp" + kendaraan.hitungBiayaServis());
        System.out.println("Servis berikutnya: " + sdf.format(kendaraan.getWaktuServisBerikutnya()));
    }
}