package main.java.pbo25.week_5;

public class Wizard extends Hero {

    public Wizard(String name) {
        super(name, 70, 20);
    }

    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan sihir dengan kekuatan " + attackPower + "!");
    }
}
