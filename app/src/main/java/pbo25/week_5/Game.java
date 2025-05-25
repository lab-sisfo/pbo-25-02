package pbo25.week_5;

import java.util.Scanner;

class Hero {
    String name;
    int health;
    int attackPower;

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
        super("Pemanah", 80, 15);  // Nama di-set langsung
    }
}

class Wizard extends Hero {
    public Wizard() {
        super("Penyihir", 70, 20);  // Nama di-set langsung
    }
}

class Fighter extends Hero {
    public Fighter() {
        super("Petarung", 100, 10);  // Nama di-set langsung
    }
}

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero hero = null;

        System.out.println("=== PILIH KARAKTER ===");
        System.out.println("1. Pemanah (Archer)");
        System.out.println("2. Penyihir (Wizard)");
        System.out.println("3. Petarung (Fighter)");
        System.out.print("Pilihanmu: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                hero = new Archer();
                break;
            case 2:
                hero = new Wizard();
                break;
            case 3:
                hero = new Fighter();
                break;
            default:
                System.out.println("Pilihan tidak valid. Keluar dari program.");
                System.exit(0);
        }

        System.out.println("\nKarakter yang dipilih: " + hero.name);

        int menu;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilihanmu: ");
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    hero.attack();
                    break;
                case 2:
                    System.out.println("Keluar dari game. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (menu != 2);

        scanner.close();
    }
}