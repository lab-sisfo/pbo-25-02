package pbo25.week_4.login_app.utils;

public class StringUtils {
    public static String generateNickName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("FullName cannot be null or empty");
        }
        String[] names = fullName.trim().split("\\s+");
        if (names.length == 1) {
            return fullName.trim();
        }
        return names[1];
    }
}