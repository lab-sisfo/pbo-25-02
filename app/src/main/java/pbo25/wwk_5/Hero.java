package pbo25.wwk_5;

public class Hero {
    protected String name;
    protected int health, attackPower;

    public Hero(String name, int health, int attackPower){
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
    void attack(){
        System.out.println(this.name + " menyerang dengan kekuatan " + this.attackPower);
    } 
    
}
