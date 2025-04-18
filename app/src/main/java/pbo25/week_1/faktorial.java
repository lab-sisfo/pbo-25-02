import java.util.Scanner;

public class faktorial {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        try {
            System.out.print("Input a number: ");
            int n = x.nextInt();

            if (n < 0) {
                System.err.println("Undefined factorial for negative numbers.");
            } else {
                int result = 1;
                for (int i = 1; i <= n; i++) {
                    result *= i;
                }
                System.out.println(n + "! = " + result);
            }
        } catch (Exception e) {
            System.err.println("Invalid input! Please enter a valid integer.");
        }
        x.close();
        
    }
}
