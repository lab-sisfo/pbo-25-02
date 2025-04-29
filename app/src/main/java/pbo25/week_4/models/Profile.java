package pbo25.week_4.models;

public class Profile {
    private String fullName;
    private String nickName;
    private int age;
    private String hobby;

    public Profile() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        this.nickName = generateNickName(fullName);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    private String generateNickName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            return "";
        }
        String[] parts = fullName.split(" ");
        return parts[parts.length - 1];
    }
}
