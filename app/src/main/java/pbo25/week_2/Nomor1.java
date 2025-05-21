package pbo25.week_2;

import java.util.Scanner;

public class nomor1 {
    String name;
    int age;
    boolean isMale;

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }
    public String getGender() {
        return isMale ? "Male" : "Female";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        nomor1 person = new nomor1();

        System.out.print("Masukkan nama: ");
        String inputName = input.nextLine();
        person.setName(inputName);

        System.out.println("Masukkan umur: ");
        int inputAge = input.nextInt();
        person.setAge(inputAge);

        System.out.println("Apakah laki-laki (true/false)");
        boolean inputGender = input.nextBoolean();
        person.setGender(inputGender);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Gender: " + person.getGender());

        input.close();
    }
}

