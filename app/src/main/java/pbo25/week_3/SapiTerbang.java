package FlyingCow;

public class SapiTerbang {
    private String nama;
    private SayapBuatan sayap;
    private RumputAjaib rumput;
    private int kesehatan;
    private boolean ngalah;

    public SapiTerbang() {
        this.nama = "Sapi Biasa";
        this.sayap = new SayapBuatan("Kardus", 2);
        this.rumput = new RumputAjaib("Hijau", 50, "Regenerasi");
        this.kesehatan = 100;
        this.ngalah = false;
    }

    public SapiTerbang(String nama, SayapBuatan sayap, RumputAjaib rumput) {
        this.nama = nama;
        this.sayap = sayap;
        this.rumput = rumput;
        this.kesehatan = 100;
        this.ngalah = false;
    }

    public void terbang() {
        if (!ngalah) {
            int ketinggian = rumput.getKekuatan() / 5;
            System.out.println(nama + " terbang setinggi " + ketinggian + " meter");
        }
    }

    public void salingTabrakan(SapiTerbang sapiLain) {
        int damageSaya = 20 + (sayap.getLebar() * 5);
        int damageLawan = 20 + (sapiLain.sayap.getLebar() * 3);
        
        sapiLain.kesehatan -= damageSaya;
        this.kesehatan -= damageLawan;
        
        System.out.println(nama + " memberikan " + damageSaya + " damage ke " + sapiLain.nama + "        ");
        System.out.println(sapiLain.nama + " memberikan " + damageLawan + " damage ke " + nama + "        ");
        
        if (sapiLain.kesehatan <= 30) { 
            sapiLain.ngalah = true;
            sapiLain.kesehatan = 0; 
        }
        if (this.kesehatan <= 30) {
            this.ngalah = true;
            this.kesehatan = 0;
        }
    }
    
    public void printStatus() {
        System.out.println("================ " + nama + " Status ================");
        System.out.println("Nama            : " + nama);
        System.out.println("Bahan Sayap     : " + sayap.getBahan());
        System.out.println("Ukuran Sayap    : " + sayap.getLebar() + "m");
        System.out.println("Jenis Rumput    : " + rumput.getJenis() + ", Kekuatan " + 
                         rumput.getKekuatan() + ", Efek " + rumput.getEfek());
        System.out.println("Health          : " + (ngalah ? nama + " Ngalah (Pergi Ngopi)" : kesehatan));
        System.out.println("===================================================");
    }
}