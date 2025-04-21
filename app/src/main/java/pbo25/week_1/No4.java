import java.util.Scanner;

public class No4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Masukkan sebuah bilangan: ");
        int bilangan = scanner.nextInt();

    
        System.out.println("Faktorial dari " + bilangan + " adalah " + factorial(bilangan));

        scanner.close();
    }
    static int factorial(int value) {
        if (value == 1 || value == 0) {
            return 1;
        } else {
            return value * factorial(value - 1);
        }

    }
}