package login_app.utils;

public class StringUtils {
    public static String generateNickName(String fullName) {
        String[] names = fullName.split(" ");
        String nickName = names[0].charAt(0) + names[names.length - 1];
        return nickName;
    }
}