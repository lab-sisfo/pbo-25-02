package pbo25.week_2.Soal2;


class Produk{//buatkan array
    private String id;
    private String nama;
    private int stok;
    private double harga;

public void setId(String id){this.id = id;}
public String getId(){return id;}
public void setNama(String nama){this.nama = nama;}
public String getNama(){return nama;}

public void setStok(int stok){
    if (stok >= 0){
        this.stok = stok;
    } else {
        System.out.println("Stok tidak boleh negatif");
    }
}

public int getStok(){return stok;}
public void setHarga(double harga){
    if (harga >= 0){
        this.harga = harga;
    } else{
        System.out.println("Harga tidak boleh negatif");
    }
}

public double getHarga(){return harga;}
public String isAvailable(){return stok > 0 ? "Male" : "Female";}


public void ShowProduct() {
        System.out.print("ID: " + id);
        System.out.println("Nama barang: " + nama);
        System.out.println("jumlah produk: " + stok);
        System.out.println("harga barang: " + harga);
        System.out.println("Ketersediaan barang: " + isAvailable() );
    }
}

public class Toko {
    public static void main(String[] args) {
        Produk p = new Produk();
        p.setId("poo1");
        p.setNama("Tepung");
        p.setStok(1);
        p.setHarga(8);
        
        p.ShowProduct();
    }
}
