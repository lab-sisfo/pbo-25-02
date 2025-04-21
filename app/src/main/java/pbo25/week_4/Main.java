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
        String username = sc.nextLine();

        // Membuat variabel userIndex yang mana nanti akan menampung index dari user
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            /*
             * TODO
             * Buatlah sebuah perkondisian (IF) yang akan
             * Mengecek apakah user index ke i dari listUser memiliki username yang sama
             * dengan username yang
             * diinput.
             * Jika ada ganti userIndex dengan Index dari User Tersebut, kemudian hentikan
             * perulangan
             */
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break; // Hentikan perulangan jika username ditemukan
            }
        }

        // Saat userIndex tidak sama dengan -1 atau userIndexnya ditemukan
        if (userIndex != -1) {
            // Menginput Password
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.nextLine();

            /*
             * TODO
             * Mengecek apakah password dari User yang login berdasarkan username
             * sama dengan password yang diinput sebelumnya, kemudian simpan
             * hasilnya di variabel isPasswordMatch
             */
            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);

            // Jika passwordnya sama maka berhasil login
            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                /*
                 * TODO
                 * panggil method showDetailUser dan kirimkan data Profile User yang login
                 * 
                 */
                showDetailUser(listUser.get(userIndex).getProfile());
                System.exit(0);
            } else {
                // saat password salah akan menampikan password salah
                System.out.println("Password Salah");
            }
        }
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        // Menginput username dan password
        String username = "";
        while (true) {
            System.out.println("Username");
            System.out.print("> ");
            username = sc.nextLine();

            // Cek apakah username sudah ada
            boolean thereisUsername = false;
            for (User user : listUser) {
                if (user.getUsername().equals(username)) {
                    thereisUsername = true;
                    break;
                }
            }

            if (thereisUsername) {
                System.out.println("Username sudah digunakan. Silahkan masukkan username lain!!");
            } else if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong. Silahkan masukkan username!!");
            } else {
                break; // Username valid dan belum digunakan
            }
        }

        String password = "";
        while (true) {
            System.out.println("Password");
            System.out.print("> ");
            password = sc.nextLine().trim(); // Trim untuk menghapus spasi di awal dan akhir

            if (password.isEmpty()) {
                System.out.println("Silahkan masukkan password yang benar!!");
            } else if (password.length() < 8) {
                System.out.println("Password harus lebih dari 8 karakter!");
            } else {
                // Jika password valid, keluar dari loop
                break;
            }
        }
        /*
         * TODO
         * Buatlah atau Instance objek User baru, dan tambahkan
         * username dan password yang diinput sebelumnya secara langsung
         * saat instance User
         */
        User newUser = new User(username, password);
        /*
         * TODO
         * Buatlah atau Instance objek Profile baru
         */
        Profile profile = new Profile();
        newUser.setProfile(profile);

        // Menginput Data Profile
        String fullName = "";
        while (true) {
            System.out.println("Nama Lengkap");
            System.out.print("> ");
            fullName = sc.nextLine();
            if (fullName.isEmpty()) {
                System.out.println("Nama lengkap tidak boleh kosong. Silahkan masukkan nama anda!!");
            } else {
                break;
            }
        }

        int age = 0;
        while (true) {
            System.out.println("Umur");
            System.out.print("> ");
            String input = sc.nextLine().trim(); // Ambil input sebagai string dan trim spasi

            if (input.isEmpty()) {
                System.out.println("Umur tidak boleh kosong. Silahkan masukkan umur anda!!.");
            } else {
                try {
                    age = Integer.parseInt(input); // Konversi kembali inputan ke integer
                    if (age <= 0) {
                        System.out.println("Umur harus lebih dari 0. Silahkan coba lagi!!");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input tidak valid. Silahkan masukkan angka untuk umur!!");
                }
            }
        }

        String hobby = "";
        while (true) {
            System.out.println("Hobby");
            System.out.print("> ");
            hobby = sc.nextLine();
            if (hobby.isEmpty()) {
                System.out.println("Hobby tidak boleh kosong. Silahkan masukkan hobby anda!!");
            } else {
                break;
            }
        }

        /*
         * TODO
         * Berikan nilai fullName, age, dan hobby ke objek profile yang telah
         * di Instance sebelumnya. Nilai ini diperoleh dari data profile yang
         * diinput sebelumnya
         */
        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);

        /*
         * TODO
         * Berikan nilai nickName ke objek profile,
         * Nilai ini diperoleh menggunakan static method yang dibuat di class
         * StringUtils, dengan mengirimkan fullName yang diinput sebelumnya
         */
        profile.setNickName(StringUtils.generateNickName(fullName));

        // Menambahkan user yang dibuat ke list user
        listUser.add(newUser);
        // Menambahkan profile user yang dibuat ke list profile
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        /*
         * TODO *
         * Tampilkan semua data profile user yang login
         */
        System.out.println("========================");
        System.out.println("SELAMAT DATANG !!");
        System.out.println("========================");
        System.out.println("Nama Lengkap: " + profile.getFullName());
        System.out.println("Nama Panggilan: " + profile.getNickName());
        System.out.println("Umur: " + profile.getAge());
        System.out.println("Hobby: " + profile.getHobby());
    }
}