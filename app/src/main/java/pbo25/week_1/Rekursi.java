import java.util.Scanner;

public class Rekursi{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan angka: ");
        int angka = scanner.nextInt();

        int hasil = factorial(angka);
        System.out.println(angka + "! = " + hasil);

        scanner.close();
    }

    public static int factorial(int n){
        return n == 0 ? 1 : n * factorial(n-1);
    }
}
