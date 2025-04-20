import java.util.Scanner;

public class Nomor4 {
    public static int faktorial(int n) {
        if (n == 0 || n == 1) {
            return 1; 
        }
        return n * faktorial(n - 1); 
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan bilangan: ");
        int n = input.nextInt();
        input.close(); 
        System.out.println(faktorial(n));
    }
}
