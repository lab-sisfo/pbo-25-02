package pbo25.week_5;

public class Wizard extends Hero {
    public Wizard(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void serang() {
        System.out.println(name + " menyerang dengan kekuatan sebesar " + attackPower + "!");
    }
}