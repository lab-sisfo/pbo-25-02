package pbo25.week_6;

import java.util.Date;

interface IServiceable {
    public boolean periksaKondisi();
    public void lakukanServis();
    public Date getWaktuServisBerikutnya();
    public double hitungBiayaServis();
}