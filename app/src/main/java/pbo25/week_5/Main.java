package pbo25.week_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean pilihmenu = true;

        Archer pemanah = new Archer("Archer", 80, 15);
        Wizard penyihir = new Wizard("Wizard", 70, 20);
        Fighter petarung = new Fighter("Fighter", 90, 18);

        Hero selectedHero = null;

        while (selectedHero == null) {
            System.out.println("Pilih Karakter:");
            System.out.println("1. Archer");
            System.out.println("2. Wizard");
            System.out.println("3. Fighter");
            System.out.print("Masukkan pilihan: ");

            if (input.hasNextInt()) {
                int pilihanHero = input.nextInt();
                input.nextLine();

                switch (pilihanHero) {
                    case 1:
                        selectedHero = pemanah;
                        break;
                    case 2:
                        selectedHero = penyihir;
                        break;
                    case 3:
                        selectedHero = petarung;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } else {
                System.out.println("Input harus berupa angka. Silahkan masukkan angka yang benar!");
                input.next();
            }
        }

        while (pilihmenu) {
            System.out.println("Menu: ");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih aksi: ");

            if (input.hasNextInt()) {
                int aksi = input.nextInt();
                input.nextLine();

                switch (aksi) {
                    case 1:
                        if (selectedHero != null) {
                            selectedHero.serang();
                        } else {
                            System.out.println("Belum ada karakter yang dipilih.");
                        }
                        break;
                    case 2:
                        pilihmenu = false;
                        System.out.println("Game selesai!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } else {
                System.out.println("Input harus berupa angka. Silahkan masukkan angka yang benar!");
                input.next();
            }
        }

        input.close();
    }
}