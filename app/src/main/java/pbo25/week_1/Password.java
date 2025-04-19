import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan password anda: ");
        String pw = scanner.nextLine();

        String angka = "0123456789";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;

        for (char chara : pw.toCharArray()) {
            if (upper_case.indexOf(chara) != -1) {
                hasUpperCase = true;
            } 
            if (lower_case.indexOf(chara) != -1) {
                hasLowerCase = true;
            }
            if (angka.indexOf(chara) != -1) {
                hasDigit = true;
            }
        }

        if (pw.length() < 8) {
            System.out.println("Password harus minimal mengandung 8 karakter, seperti huruf kapital, huruf kecil, dan angka!");
        } else if (!hasUpperCase || !hasLowerCase || !hasDigit) {
            System.out.println("Password harus mengandung setidaknya satu huruf kapital, satu huruf kecil, dan satu angka!");
        } else {
            System.out.println("Password valid!");
        }

        scanner.close();
    }
}