package pbo25.week_1;

import java.util.Scanner;

public class nomorLima {
    public static boolean isValid(String password) {
        if (password.length() < 8) return false;
        boolean hasUpper = false, hasLower = false, hasDigit = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isLowerCase(ch)) hasLower = true;
            if (Character.isDigit(ch)) hasDigit = true;
        }
        return hasUpper && hasLower && hasDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        System.out.println(isValid(password) ? "Password valid" : "Password tidak valid");
        scanner.close();
    }
}
