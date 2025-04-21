package login_app.utils;

import java.util.ArrayList;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        try {
            int selectMenu = sc.nextInt();
            sc.nextLine();
            switch (selectMenu) {
                case 1:
                    showLoginMenu();
                    break;
                case 2:
                    showRegisterMenu();
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    runApp();
            }
        } catch (Exception e) {
            System.out.println("Input harus berupa angka!");
            sc.nextLine();
            runApp();
        }
    }

    private static void showLoginMenu() {
        System.out.println("-------------------------");
        System.out.println("Login");
        System.out.println("Masukkan Username");
        System.out.print("> ");

        String username = sc.nextLine();
        int userIndex = -1;
        
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }

        if (userIndex != -1) {
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.nextLine();

            if (listUser.get(userIndex).getPassword().equals(password)) {
                System.out.println("Berhasil Login");
                showDetailUser(listUserProfile.get(userIndex));
                System.exit(0);
            } else {
                System.out.println("Password Salah");
                showLoginMenu();
            }
        } else {
            System.out.println("Username tidak ditemukan!");
            runApp();
        }
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        String username;
        while (true) {
            System.out.println("Username");
            System.out.print("> ");
            username = sc.nextLine();
            
            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong!");
                continue;
            }
            
            boolean usernameExists = false;
            for (User user : listUser) {
                if (user.getUsername().equals(username)) {
                    usernameExists = true;
                    break;
                }
            }
            
            if (usernameExists) {
                System.out.println("Username sudah digunakan!");
            } else {
                break;
            }
        }

        String password;
        while (true) {
            System.out.println("Password (minimal 8 karakter)");
            System.out.print("> ");
            password = sc.nextLine();
            
            if (password.isEmpty()) {
                System.out.println("Password tidak boleh kosong!");
            } else if (password.length() < 8) {
                System.out.println("Password harus minimal 8 karakter!");
            } else {
                break;
            }
        }

        User user = new User(username, password);
        Profile profile = new Profile();

        String fullName;
        while (true) {
            System.out.println("Nama Lengkap");
            System.out.print("> ");
            fullName = sc.nextLine();
            
            if (fullName.isEmpty()) {
                System.out.println("Nama lengkap tidak boleh kosong!");
            } else {
                break;
            }
        }

        int age = 0;
        while (true) {
            System.out.println("Umur");
            System.out.print("> ");
            try {
                age = Integer.parseInt(sc.nextLine());
                if (age <= 0) {
                    System.out.println("Umur harus lebih dari 0!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Umur harus berupa angka!");
            }
        }

        String hobby;
        while (true) {
            System.out.println("Hobby");
            System.out.print("> ");
            hobby = sc.nextLine();
            
            if (hobby.isEmpty()) {
                System.out.println("Hobby tidak boleh kosong!");
            } else {
                break;
            }
        }

        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);

        listUser.add(user);
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("SELAMAT DATANG !!");
        System.out.println("-------------------------");
        System.out.println("Nama Lengkap : " + profile.getFullName());
        System.out.println("Nama Panggilan : " + profile.getNickName());
        System.out.println("Umur : " + profile.getAge());
        System.out.println("Hobby : " + profile.getHobby());
    }
}