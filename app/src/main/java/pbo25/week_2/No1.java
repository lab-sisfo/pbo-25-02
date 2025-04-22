package pbo25.week_2;

public class No1 {
    public static void main(String[] args) {
        Person person = new Person();

        person.setName("Adit");
        person.setAge(70);
        person.setGender("female");

        System.out.println("Nama : " + person.getName());
        System.out.println("Umur : " + person.getAge());
        System.out.println("Gender : " + person.getGender());
    }
}

class Person {
    String name;
    int age;
    boolean isMale;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            this.isMale = true;
        } else if (gender.equalsIgnoreCase("female")) {
            this.isMale = false;
        }
    }

    public String getGender() {
        if (this.isMale) {
            return "male";
        } else {
            return "female";
        }
    }
}
