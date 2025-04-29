public class Archer extends Hero {

    public Archer(String name) {
        super(name, 80, 15);
    }

    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan panah dengan kekuatan " + attackPower + "!");
    }
}
