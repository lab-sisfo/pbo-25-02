package pbo25.week_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        Hero sjw = null;

        System.out.println("=== Selamat Datang di Game Interaktif ===");
        System.out.println("Pilih Karakter: ");
        System.out.println("1. Archer\n2. Wizard\n3. Fighter");
        System.out.print("Masukkan pilihan: ");
        String cha = x.nextLine();

        while (cha != null) {
            if (cha.equals("1")){
                sjw = new Archer("Pemanah");
                break;
            } else if(cha.equals("2")){
                sjw = new Wizard("Penyihir");
                break;
            } else if(cha.equals("3")){
                sjw = new Fighter("Petarung");
                break;
            } else{
                System.out.println("Pilihan tidak valid!");
                System.out.print("Masukkan pilihan yang benar: ");
                cha = x.nextLine();
            }
            }
        String suho;
        do {
            System.out.println("\nMenu: ");
            System.out.println("1. Serang\n2. Keluar");
            System.out.print("Masukkan pilihan: ");
            suho = x.nextLine();

            if(suho.equals("1")){
                sjw.attack();
            } else if(suho.equals("2")){
                System.out.println("Game selesai");
            } else{
                System.out.println("Pilihan tidak valid");
            }
        } while (!suho.equals("2"));
            x.close();
        }
    }
    

