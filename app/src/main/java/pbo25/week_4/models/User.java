package pbo25.week_4.models;

public class User {
    /*
     * TODO:
     * Tambahkan attribute, method, atau constructor
     * yang dibutuhkan di kelas user
     */

    private String username;
    private String password;
    private Profile profile; // Relasi ke kelas Profile

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.profile = new Profile(); 
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}