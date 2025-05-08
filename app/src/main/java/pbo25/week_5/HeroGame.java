import java.util.Scanner;

class Hero {
    protected String name;
    protected int health;
    protected int attackPower;

    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower + "!");
    }
}

class Archer extends Hero {
    public Archer() {
        super("Pemanah", 100, 15);
    }
}

class Wizard extends Hero {
    public Wizard() {
        super("Penyihir", 80, 20);
    }
}

class Fighter extends Hero {
    public Fighter() {
        this("Petarung");
    }

    public Fighter(String name) {
        this(name, 120, 25);
    }

    public Fighter(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
}

public class HeroGame{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero[] heroes = {new Archer(), new Wizard(), new Fighter()};

        System.out.println("Pilih Karakter:");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("Masukkan pilihan: ");
        int choice = scanner.nextInt() - 1;

        if (choice < 0 || choice >= heroes.length) {
            System.out.println("Pilihan tidak valid!");
            System.exit(0);
        }

        Hero hero = heroes[choice];

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih aksi: ");
            int action = scanner.nextInt();

            if (action == 1) {
                hero.attack();
            } else if (action == 2) {
                System.out.println("Game selesai!");
                break;
            } else {
                System.out.println("Aksi tidak valid!");
            }
        }

        scanner.close();
    }
}