package pbo25.week_4;

import java.util.ArrayList;
import java.util.Scanner;
import pbo25.week_4.models.Profile;
import pbo25.week_4.models.User;
import pbo25.week_4.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Memanggil method runApp();
        runApp();
    }

    private static void runApp() {
        // Menu Utama Aplikasi
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        // Menginput pilihan menu
        int selectMenu = sc.nextInt();
        sc.nextLine();
        switch (selectMenu) {
            case 1:
                // Membuka Halaman Login
                showLoginMenu();
                break;
            case 2:
                // Membuka Halaman Register
                showRegisterMenu();
                break;
            default:
                // Mengulang Pemanggilan Menu Utama
                runApp();
        }
    }

    private static void showLoginMenu() {
        // Halaman Login
        System.out.println("-------------------------");
        System.out.println("Login");
        // Menginput Username dan Menyimpannya di attribute username;
        System.out.println("Masukkan Username");
        System.out.print("> ");

        String username = sc.next();
        // Membuat variabel userIndex yang mana nanti akan menampung index dari user
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }        
        // Saat userIndex tidak sama dengan -1 atau userIndexnya ditemukan
        if (userIndex != -1) {
            // Menginput Password
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.next();

            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);

            // Jika passwordnya sama maka berhasil login
            if (isPasswordMatch) {
                System.out.println("Berhasil Login");

                showDetailUser(listUserProfile.get(userIndex));

                System.exit(0);
            } else {
                // saat password salah akan menampikan password salah
                System.out.println("Password Salah");
            }
        } else {
            System.out.println("Username tidak ditemukan.");
        }
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        // Menginput username dan password
        System.out.println("Username");
        System.out.print("> ");
        String username = sc.nextLine();
        System.out.println("Password");
        System.out.print("> ");
        String password = sc.nextLine();

        // Membuat objek User
        User user = new User(username, password);

        // Membuat objek Profile
        Profile profile = new Profile();

        // Menginput Data Profile
        System.out.println("Nama Lengkap");
        System.out.print("> ");
        String fullName = sc.nextLine();
        profile.setFullName(fullName);

        System.out.println("Umur");
        System.out.print("> ");
        int age = sc.nextInt();
        sc.nextLine();
        profile.setAge(age);

        System.out.println("Hobby");
        System.out.print("> ");
        String hobby = sc.nextLine();
        profile.setHobby(hobby);

        String nickName = StringUtils.generateNickName(fullName);
        profile.setNickName(nickName);

        // Menampilkan detail profile yang sudah diinput
        System.out.println("-------------------------");
        System.out.println("Detail Profile Pengguna");
        System.out.println("Nama Lengkap : " + profile.getFullName());
        System.out.println("Nick Name    : " + profile.getNickName());
        System.out.println("Umur         : " + profile.getAge());
        System.out.println("Hobby        : " + profile.getHobby());

        // Menambahkan user yang dibuat ke list user
        listUser.add(user);
        // Menambahkan profile user yang dibuat ke list profile
        listUserProfile.add(profile);

        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("Detail Pengguna");
        System.out.println("-------------------------");
        System.out.println("Nama Lengkap : " + profile.getFullName());
        System.out.println("Nick Name    : " + profile.getNickName());
        System.out.println("Umur         : " + profile.getAge());
        System.out.println("Hobby        : " + profile.getHobby());
    }
}
