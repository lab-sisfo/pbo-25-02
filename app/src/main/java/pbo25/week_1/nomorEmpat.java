package pbo25.week_1;

import java.util.Scanner;

public class nomorEmpat {
    public static int faktorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * faktorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(faktorial(n));
        scanner.close();
    }
}
