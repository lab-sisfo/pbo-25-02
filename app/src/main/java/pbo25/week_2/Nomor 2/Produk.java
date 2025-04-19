public class Produk {
    int produkId;
    String nama;
    int stok;
    double harga;

    public void setProdukId(int produkId){
        this.produkId = produkId;
    }

    public int getProdukId(){
        return produkId;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public void setStok(int stok){
        this.stok = stok;
    }

    public int getStok(){
        return stok;
    }

    public void setHarga(double harga){
        this.harga = harga;
    }

    public double getHarga(){
        return harga;
    }

    public String cekDataProduk(){
        return "ID: " + produkId + ", Nama: " + nama + ", Stok: " + stok + ", Harga: " + harga;
    }

    public boolean isTersedia(){
        return stok > 0;
    }

    

    public static void main(String[] args){
        Produk produk1 = new Produk();
        produk1.setProdukId(01);
        produk1.setNama("Dancow");
        produk1.setStok(5);
        produk1.setHarga(98000);
        System.out.println(produk1.cekDataProduk());
        System.out.println("Tersedia di stok: " + produk1.isTersedia());

    }
    
}