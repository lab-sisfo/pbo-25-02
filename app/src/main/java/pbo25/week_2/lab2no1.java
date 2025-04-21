public class lab2no1 {
    private String name;
    private int age;
    private boolean isMale;

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

    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    public String getGender() {
        return isMale ? "Laki-laki" : "Perempuan";
    }

    public static void main(String[] args) {
        lab2no1 person = new lab2no1();
     
        person.setName("Budi");
        person.setAge(25);
        person.setGender(true);
   
        System.out.println("Nama: " + person.getName());
        System.out.println("Umur: " + person.getAge() + " tahun");
        System.out.println("Jenis Kelamin: " + person.getGender());
    }
}