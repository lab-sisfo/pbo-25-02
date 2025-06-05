package pbo25.week_5;

public class Fighter extends Hero {
    public Fighter(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    public void SerangLawan() {
        this.Serang();
    }
}