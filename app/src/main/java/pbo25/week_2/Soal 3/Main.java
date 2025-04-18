class Cuboid{
    double height;
    double width;
    double length;

    double getVolume(){
        return height * width * length;//lengkapi
    }
}
public class Main {
public static void main(String [] args){
    Cuboid cuboid = new Cuboid();
    cuboid.height = 50;
    cuboid.width = 30;
    cuboid.length = 3;//lengkapi
    System.out.printf("Volume = %.2f", cuboid.getVolume());
}
}
