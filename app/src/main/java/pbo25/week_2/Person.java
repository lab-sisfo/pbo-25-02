package pbo25.week_2;

public class Person {
    String name;
    int age;
    boolean isMale;

    // Setter untuk name
    public void setName(String name) {
        this.name = name;
    }

    // Getter untuk name
    public String getName() {
        return name;
    }

    // Setter untuk age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter untuk age
    public int getAge() {
        return age;
    }

    // Setter untuk gender (isMale)
    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    // Getter untuk gender, return "Male" atau "Female"
    public String getGender() {
        return isMale ? "male" : "female";
    
    }

    public void data(){
        System.out.println("name: " + name + "\n");
        System.out.println("age: " + age + "\n");
        System.out.println("gender: " + getGender());
    }
    public static void main(String[] args){
        Person person = new Person();
         person.setName("maisyah");
         person.setAge(19);
         person.setGender(false);

         person.data();
    }
}