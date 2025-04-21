package login_app;

import java.util.ArrayList;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;
import login_app.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
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
                System.out.println("Pilihan tidak valid, silakan coba lagi.");
                runApp();
        }
    }

    private static void showLoginMenu() {
        // Halaman Login
        System.out.println("-------------------------");
        System.out.println("Login");

        int userIndex = -1;
        String username;

        // 1. Input ulang kalau kosong & cek username terdaftar
        do {
            System.out.print("Masukkan Username: ");
            username = sc.next();
            if (username.trim().isEmpty()) {
                System.out.println("Username tidak boleh kosong!");
                continue;
            }
            userIndex = -1;
            for (int i = 0; i < listUser.size(); i++) {
                if (listUser.get(i).getUsername().equals(username)) {
                    userIndex = i;
                    break;
                }
            }
            if (userIndex == -1) {
                System.out.println("Username tidak ditemukan, coba lagi.");
            }
        } while (userIndex == -1);

        String password;

        // 2. Input ulang password kalau kosong atau salah
        do {
            System.out.print("Password: ");
            password = sc.next();
            if (password.trim().isEmpty()) {
                System.out.println("Password tidak boleh kosong!");
                continue;
            }
            if (!listUser.get(userIndex).getPassword().equals(password)) {
                System.out.println("Password salah, coba lagi.");
            } else {
                break;
            }
        } while (true);

        // 3. Berhasil login
        System.out.println("Berhasil Login");
        showDetailUser(listUserProfile.get(userIndex));
        System.exit(0);
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");
    
        String username;
        // 4. Input ulang username kalau kosong atau duplikat
        do {
            System.out.print("Username: ");
            username = sc.nextLine();
            if (username.trim().isEmpty()) {
                System.out.println("Username tidak boleh kosong!");
                continue;
            }
            boolean taken = false;
            for (User u : listUser) {
                if (u.getUsername().equals(username)) {
                    System.out.println("Username sudah digunakan!");
                    taken = true;
                    break;
                }
            }
            if (!taken) break;
        } while (true);
    
        String password;
        // 5. Input ulang password kalau kosong atau < 8 karakter
        do {
            System.out.print("Password (min 8 karakter): ");
            password = sc.nextLine();
            if (password.trim().isEmpty()) {
                System.out.println("Password tidak boleh kosong!");
            } else if (password.length() < 8) {
                System.out.println("Password terlalu pendek!");
            } else {
                break;
            }
        } while (true);
    
        // Buat objek User
        User user = new User(username, password);
        // Buat objek Profile
        Profile profile = new Profile();
    
        String fullName;
        // 6. Input ulang fullName kalau kosong
        do {
            System.out.print("Nama Lengkap: ");
            fullName = sc.nextLine();
            if (fullName.trim().isEmpty()) {
                System.out.println("Nama lengkap tidak boleh kosong!");
            } else {
                break;
            }
        } while (true);
        profile.setFullName(fullName);
    
        int age;
        // 7. Input ulang umur kalau bukan angka atau ≤ 0
        do {
            System.out.print("Umur: ");
            if (!sc.hasNextInt()) {
                System.out.println("Masukkan angka untuk umur!");
                sc.nextLine(); // Clear buffer
                continue;
            }
            age = sc.nextInt();
            sc.nextLine(); 
            if (age <= 0) {
                System.out.println("Umur harus positif!");
            } else {
                break;
            }
        } while (true);
        profile.setAge(age);
    
        String hobby;
        // 8. Input ulang hobby kalau kosong
        do {
            System.out.print("Hobby: ");
            hobby = sc.nextLine();
            if (hobby.trim().isEmpty()) {
                System.out.println("Hobby tidak boleh kosong!");
            } else {
                break;
            }
        } while (true);
        profile.setHobby(hobby);
    
        // 9. Generate nickname via StringUtils
        profile.setNickName(StringUtils.generateNickName(fullName));
    
        // Simpan user & profile
        listUser.add(user);
        listUserProfile.add(profile);
    
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }    

    private static void showDetailUser(Profile profile) {
        // Tampilkan semua data profile user yang login
        System.out.println("-------------------------");
        System.out.println("Data Profil Pengguna:");
        System.out.println("Nama Lengkap : " + profile.getFullName());
        System.out.println("Nick Name    : " + profile.getNickName());
        System.out.println("Umur         : " + profile.getAge());
        System.out.println("Hobby        : " + profile.getHobby());
        System.out.println("-------------------------");
    }
}