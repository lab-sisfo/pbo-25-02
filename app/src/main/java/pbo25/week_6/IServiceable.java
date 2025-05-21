package pbo25.week_6;

import java.util.Date;

public interface IServiceable {
    boolean periksaKondisi();
    void lakukanServis();
    Date getWaktuServisBerikutnya();
    double hitungBiayaServis();
}
