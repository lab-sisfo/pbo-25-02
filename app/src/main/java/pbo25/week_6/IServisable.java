package main.java.pbo25.week_6;
import java.util.Date;

public interface IServisable {
    boolean getStatusServis();
    void lakukanServis();
    Date getTanggalServisBerikutnya();
    double hitungBiayaServis();
}
