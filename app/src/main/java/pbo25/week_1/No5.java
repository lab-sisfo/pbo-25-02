package pbo25.week_1;

import java.util.Scanner;

public class No5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = input.nextLine();

        if (password.length() < 8) {
            System.out.println("Password harus minimal 8 karakter!");
            return;
        }

        boolean adaBesar = false;
        boolean adaKecil = false;
        boolean adaAngka = false;

        for (char karakter : password.toCharArray()) {
            if (Character.isUpperCase(karakter))
                adaBesar = true;
            if (Character.isLowerCase(karakter))
                adaKecil = true;
            if (Character.isDigit(karakter))
                adaAngka = true;
        }

        if (adaBesar && adaKecil && adaAngka) {
            System.out.println("Password valid!");
        } else {
            System.out.println("Password tidak memenuhi syarat:");
            if (!adaBesar)
                System.out.println("- Harus ada huruf besar");
            if (!adaKecil)
                System.out.println("- Harus ada huruf kecil");
            if (!adaAngka)
                System.out.println("- Harus ada angka");
        }

        input.close();
    }
}
