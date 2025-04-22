package pbo25.week_3;

public class Main {
    public static void main(String[] args) {
        ShadowPower powerknight1 = new ShadowPower(30, 12.5);
        ShadowPower powerknight2 = new ShadowPower(25, 10.0);

        Blade bladeknight1 = new Blade("Baran", 80 );
        Blade bladeknight2 = new Blade("Raikan", 50 );

        Armor armorknight1 = new Armor("Dark Cloak" ,"Shadow helm");
        Armor armorknight2 = new Armor("Night Robe" ,"Ghost Hood");

        ShadowKnight knight1 = new ShadowKnight("Sung Jin Woo", 100, powerknight1, bladeknight1, armorknight1);
        ShadowKnight knight2 = new ShadowKnight("Antares", 120, powerknight2, bladeknight2, armorknight2);

        System.out.println("\n====Initial Status====");
        knight1.checkStatus();
        System.out.println();
        knight2.checkStatus();

        System.out.println("\n====Monarch Battle Begins====");
        knight1.attack(knight2);
        knight2.attack(knight1);

        System.out.println("\n====STATUS AFTER BATTLE====");
        knight1.checkStatus();
        System.out.println();
        knight2.checkStatus();
















    }
    
}
