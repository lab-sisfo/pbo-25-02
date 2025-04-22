package pbo25.week_3;

public class Owner {
    String namaOwner;
    String alamatOwner;
    String noHp;

    public void setNamaOwner(String namaOwner){
        this.namaOwner = namaOwner;
    }
    public String getNamaOwner(){
        return namaOwner;
    }

    public void setAlamatOwner(String alamatOwner){
        this.alamatOwner = alamatOwner;
    }
    public String getAlamatOwner(){
        return alamatOwner;
    }

    public void setNoHp(String noHp){
        this.noHp = noHp;
    }
    public String getnomorHp(){
        return noHp;
    }

    public void ownerInfo(){
        String nama = getNamaOwner();
        String alamat = getAlamatOwner();
        String nomorHp = getnomorHp();

        System.out.println("OWNER INFO");
        System.out.println("-----------------------------------------------------");
        System.out.println("Nama pemilik hewan: " + nama + "\n" +
        "Alamat: " + alamat + "\n" + "Nomor Tlp: " + nomorHp + "\n");
    }

}