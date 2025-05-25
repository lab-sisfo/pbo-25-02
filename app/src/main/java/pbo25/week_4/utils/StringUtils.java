package pbo25.week_4.utils;

public class StringUtils {
    public static String generateNickName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama lengkap tidak boleh kosong.");
        }

        String[] parts = fullName.trim().split(" ");
        return parts[0];
    }
}
