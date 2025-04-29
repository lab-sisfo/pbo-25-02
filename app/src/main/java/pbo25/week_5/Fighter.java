package main.java.pbo25.week_5;

public class Fighter extends Hero {

    public Fighter(String name) {
        this(name, 120, 10);
    }

    public Fighter(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan pedang dengan kekuatan " + attackPower + "!");
    }
}
