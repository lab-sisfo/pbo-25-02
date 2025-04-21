package pbo25.week_4.utils;

public class StringUtils {
    
    public static String generateNickName(String fullName) {
            /*
        TODO
        * Buatlah sebuah method static yang akan
        * mengembalikan nickName berdasarkan fullName yang diberikan
        * aturan pembuatan nickName adalah :
        * 1. Jika fullName hanya 1 kata maka nickName = fullName
        * (ex: FullName = Agus, maka NickName = Agus)
        * 2. Jika fullName lebih dari 1 kata maka nickName adalah kata kedua dari
        * fullName
        * (ex: FullName = Eurico Devon, maka NickName = Devon)
        */
        
        // Memeriksa apakah fullName tidak null atau kosong
        if (fullName == null || fullName.trim().isEmpty()) {
            return "User"; // Default nickname jika input tidak valid
        }

        // Memisahkan fullName menjadi kata-kata
        String[] kata = fullName.trim().split("\\s+");

        // Mengembalikan nama depan jika hanya satu kata
        if (kata.length == 1) {
            return kata[0];
        } else {
            return kata[kata.length - 1]; // Mengembalikan nama belakang
        }
    }
}