package pbo25.week_2.nomor_3;

class Cuboid {
    double height, widht, lenght;

    double getVolume(){
        double volume = height*widht*lenght;
        return volume;
    }
}

public class Balok{
    public static void main(String[] args){
        Cuboid cuboid = new Cuboid();
        cuboid.height = 15;
        cuboid.widht = 10;
        cuboid.lenght = 30;

        System.out.println(String.format("Volume = %.2f", cuboid.getVolume()));
    }
}
