package pbo25.week_5;

public class Fighter extends Hero {
    public Fighter(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    public Fighter() {
        this("Fighter", 80, 28);
    }

    @Override
    public void serang() {
        System.out.println(name + " menyerang dengan kekuatan sebesar " + attackPower + "!");
    }
}