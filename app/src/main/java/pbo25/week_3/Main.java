package FlyingCow;

public class Main {
    public Main() {
    }
 
    public static void main(String[] var0) {
       SayapBuatan var1 = new SayapBuatan("Emas", 3);
       RumputAjaib var2 = new RumputAjaib("Pelangi", 80, "Boost Kecepatan");
       SapiTerbang var3 = new SapiTerbang("Sapi Super", var1, var2);
       SayapBuatan var4 = new SayapBuatan("Kardus", 2);
       RumputAjaib var5 = new RumputAjaib("Hijau", 50, "Menambah Lemak");
       SapiTerbang var6 = new SapiTerbang("Sapi Biasa", var4, var5);
       var3.printStatus();
       var6.printStatus();
       System.out.println("\nSapi Super dan Sapi Biasa Mulai Terbang");
       System.out.println("_____________________________________");
       var3.terbang();
       var6.terbang();
       System.out.println("\nSapi Super dan Sapi Biasa saling bertabrakan");
       System.out.println("_____________________________________");
       var3.salingTabrakan(var6);
       var3.printStatus();
       var6.printStatus();
       System.out.println("\nSapi Super dan Sapi Biasa bertabarak Lagi");
       System.out.println("_____________________________________");
       var3.salingTabrakan(var6);
       System.out.println("\nSapi Biasa Ngalah (Pergi Ngopi)");
       var3.printStatus();
       var6.printStatus();
    }
 }
 