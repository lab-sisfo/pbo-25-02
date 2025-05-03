package FlyingCow;

public class RumputAjaib {
    private String jenis;
    private int kekuatan;
    private String efek;

    public RumputAjaib(String jenis, int kekuatan, String efek) {
        this.jenis = jenis;
        this.kekuatan = kekuatan;
        this.efek = efek;
    }

    public String getJenis() { return jenis; }
    public int getKekuatan() { return kekuatan; }
    public String getEfek() { return efek; }
}