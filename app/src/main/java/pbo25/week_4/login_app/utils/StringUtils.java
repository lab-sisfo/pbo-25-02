package login_app.utils;

public class StringUtils {
    public static String generateNickName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return "unknown";
        }
        String[]names = fullName.trim().split("\\s+");
        if (names.length == 1) {
            return fullName.trim();
        }
        return names[1];
    }
}