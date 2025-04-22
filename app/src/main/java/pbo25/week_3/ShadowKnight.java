package pbo25.week_3;

public class ShadowKnight {
    private String name; 
    private int health;
    private ShadowPower shadowPower;
    private Blade shadowBlade;
    private Armor armor;
    
    public ShadowKnight(){
    }
    public ShadowKnight(String name, int health, ShadowPower shadowPower, Blade shadowBlade, Armor armor){
        this.name = name;
        this.health = health;
        this.shadowPower = shadowPower;
        this.shadowBlade = shadowBlade;
        this.armor = armor;
    }
    public void attack(ShadowKnight enemy){
        double damage = shadowBlade.getBladeDamage(enemy.name);
        int defense = enemy.armor.getDefense((int) (Math.random() * 10));
        int totalDamage = (int) damage - defense;

        if (totalDamage < 0) totalDamage = 0;
        enemy.health -= totalDamage;
        System.out.println(name + " attacked " + enemy.name + "with damage: " + totalDamage);
    }
    public void checkStatus(){
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Power:" + shadowPower.getPower());
    }
}
