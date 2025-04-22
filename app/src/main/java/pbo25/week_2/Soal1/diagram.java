package pbo25.week_2.Soal1;


class Person {
    private String name;
    private int age;
    private boolean isMale; 

public void setName(String name){this.name = name;}
public String getName() {return name;}

public void setAge(int age){
    if (age >= 0){
        this.age = age;
    } else {
        System.out.println("Age can't be negative");
    }
}

public int getAge(){return age;}
public void setGender(boolean isMale){ this.isMale = isMale;}
public String getGender(){return isMale ? "Male" : "Female" ;}}

public class diagram {
    public static void main (String [] args){
        Person p1 = new Person();
        p1.setName("Haris");
        p1.setAge(21);
        p1.setGender(true);

        System.out.println(p1.getName() + " - " + p1.getAge() + " tahun - " + p1.getGender());
    }
    
}
