package pbo25.week_5;

public class Hero {
    String name;
    int health, attackPower;

    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void Serang() {
        System.out.printf("%s menyerang dengan kekuatan %s! \n", this.name, this.attackPower);
    }
}
