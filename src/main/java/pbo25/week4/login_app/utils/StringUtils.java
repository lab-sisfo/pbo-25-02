package login_app.utils;

public class StringUtils {
    public static String generateNickName(String fullName) {
        String[] parts = fullName.split(" ");
        if (parts.length > 0) {
            return parts[0];
        }
        return fullName;
    }
}
