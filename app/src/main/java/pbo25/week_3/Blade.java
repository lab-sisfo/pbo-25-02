package pbo25.week_3;

public class Blade {
    private String name;
    private int sharpness;

    public Blade(){
    }
    public Blade(String name, int sharpness){
        this.name = name;
        this.sharpness = sharpness;
    }
    public double getBladeDamage(String target){
        return sharpness * 1.5;
    }
    
}
