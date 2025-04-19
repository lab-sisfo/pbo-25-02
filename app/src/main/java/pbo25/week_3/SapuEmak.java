public class SapuEmak {
    private String nama;
    private String sapu;
    private int kesehatan;
    private int defense;
    private Pelindung pelindung;

    public SapuEmak(){
    }

    public SapuEmak(String nama, String sapu, int kesehatan, int defense, Pelindung pelindung) {
        this.nama = nama;
        this.sapu = sapu;
        this.kesehatan = kesehatan;
        this.defense = defense;
        this.pelindung = pelindung;
    }

    public String getNama() {
        return nama;
    }

    public String getSapu() {
        return sapu;
    }

    public Pelindung getPelindung() {
        return pelindung;
    }

    public void serang(SapuEmak lawan) {
        int damage = (int) (Math.random() * 10) + 1;  // Damage acak
        System.out.println(nama + " memuku; " + lawan.getNama() + " dengan sapu " + sapu + "!");
        
        // Tambah damage berdasarkan jenis sapu
        if (sapu.equalsIgnoreCase("Sapu Super")) {
            damage += 5;  // Sapu Super memberikan bonus damage
        }

        // Penghitungan damage setelah defense lawan
        int totalDamage = Math.max(damage - lawan.defense, 0);  
        lawan.kesehatan -= totalDamage;  
        System.out.println(lawan.getNama() + " menerima " + totalDamage + " damage!");
    }

    public void tampilStatus() {
        System.out.println(nama + " - HP: " + kesehatan + ", Defense: " + defense);
    }

    public boolean isAlive() {
        return kesehatan > 0;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }
}
