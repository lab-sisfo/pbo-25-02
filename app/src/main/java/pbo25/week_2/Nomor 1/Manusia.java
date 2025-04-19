public class Manusia{
    private String name;
    int age;
    boolean isMale;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setGender(boolean isMale){
        this.isMale = isMale;
    }

    public String getGender(){
        return isMale ? "Male" : "Female";
    }
    
    public void result(){
        System.out.println("Nama: " + getName());
        System.out.println("Umur: " + getAge());
        System.out.println("Gender: " + getGender());
    }

    public static void main(String[] args){
        Manusia Gatri = new  Manusia();
        Gatri.name = "A";
        //Gatri.setName("Gatri");
        Gatri.setAge(19);
        Gatri.setGender(false);
        Gatri.result();

        Manusia Ardes = new Manusia();
        Ardes.setName("Artur");
        Ardes.setAge(21);
        Ardes.setGender(true);
        Ardes.result();
    }
}