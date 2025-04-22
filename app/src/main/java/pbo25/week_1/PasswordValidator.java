package pbo25.week_1;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("Input password: ");
        String password = x.nextLine();

        if (password.length() < 8){
            System.err.println("Password Invalid: at least 8 characters");
            x.close();
            return;
        }
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            if (Character.isLowerCase(c)) hasLowercase = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (!Character.isLetterOrDigit(c)) hasSpecialChar = true;
        }

        if (hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            System.out.println("Password valid");
        } else {
            System.err.println("Invalid Password: must contain uppercase, lowercase, digit, and special character");
        }
        x.close();
    }
}
