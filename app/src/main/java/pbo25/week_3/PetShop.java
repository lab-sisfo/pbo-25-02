public class PetShop {
    String namaPet;
    Owner owner = new Owner();
    String jenis;
    String color;
    int health;

    public PetShop(){

    }

    public PetShop(String namaPet){
        this.namaPet = namaPet;
    }

    public PetShop(String namaPet, int health){
        this.namaPet = namaPet;
        this.health = health;
    }

    public PetShop(String namaPet, String jenis, String color, int health, String nama_owner){
        this.namaPet = namaPet;
        this.jenis = jenis;
        this.color = color;
        this.health = health;
        this.owner.namaOwner = nama_owner;
    }

    public PetShop(String namaPet, String jenis, String color, int health, String nama_owner, String alamat_owner, String no_hp){
        this.namaPet = namaPet;
        this.jenis = jenis;
        this.color = color;
        this.health = health;
        this.owner.namaOwner = nama_owner;
        this.owner.alamatOwner = alamat_owner;
        this.owner.noHp = no_hp;
    }

    public void checkPet(){
        System.out.println("PET INFO");
        System.out.println("----------------------------------------------------");
        System.out.println("Nama Pet: " + this.namaPet + "\n"
        + "Jenis: " + this.jenis + "\n" + "Warna: " + this.color + "\n" + "Owner: " + owner.namaOwner 
        + "\n" + "Status: " + isPetHappy() + "\n" + "Health: " + this.health);
        owner.ownerInfo();
    }

    public String isPetHappy(){
        if(this.health == 0){
            return "Hewan peliharaan anda sedang sekarat.";
        } else if (this.health == 100){
            return "Hewan peliharaan anda sangat senang. Full charge!!";
        } else if (this.health >= 70){
            return "Hewan peliharaan anda senang";
        } else{
            return "Hewan peliharaan anda murung, kurang bersemangat";
        }
    }

    public void petWash(){
        System.out.println(namaPet + " sedang dimandikan");
        this.health += 20;
        if(this.health > 100){
            this.health = 100;
        }
        System.out.println("Health setelah dimandikan bertambah sebanyak 20. Health sekarang: " + this.health);
    }

    public void petEatDrinks(){
        System.out.println(namaPet + " sedang diberi makan dan minum");
        this.health += 20;
        if(this.health > 100){
            this.health = 100;
        }
        System.out.println("Health setelah diberi makan dan minum bertambah sebanyak 20. Health sekarang: " + this.health);
    }


    public void petGrooming(){
        System.out.println(namaPet + " sedang dibersihkan (potong kuku, potong bulu, membersihkan telinga)");
        this.health += 20;
        if(this.health > 100){
            this.health = 100;
        }
        System.out.println("Health setelah dibersihkan bertambah sebanyak 20. Health sekarang: " + this.health);
    }

    public void attack(PetShop otherPet){
        System.out.println(namaPet + " berkelahi dengan " + otherPet.namaPet);
        this.health -= 15;
        if (this.health <= 0){
            this.health = 0;
        }
        otherPet.health -= 15;
        if (otherPet.health <= 0){
            otherPet.health = 0;
        }
        System.out.println("Health " + namaPet + " berkurang 15. Health sekarang: " + this.health);
        System.out.println("Health " + otherPet.namaPet + " berkurang 15. Health sekarang: " + otherPet.health);
    }

    public void playwith(PetShop otherPet){
        System.out.println(namaPet + " sedang bermain bersama " + otherPet.namaPet);
        this.health += 20;
        if (this.health > 100){
            this.health = 100;
        }
        otherPet.health += 20;
        if (otherPet.health > 100){
            otherPet.health = 100;
        }
        System.out.println("Health " + namaPet + " bertambah 20. Health sekarang: " + this.health);
        System.out.println("Health " + otherPet.namaPet + " bertambah 20. Health sekarang: " + otherPet.health);
    }


    public void setNamaPet(String namaPet){
        this.namaPet = namaPet;
    }
    public String getNamaPet(){
        return namaPet;
    }

    public void setJenisPet(String jenis){
        this.jenis = jenis;
    }
    public String getJenisPet(){
        return jenis;
    }

    public void setColorPet(String color){
        this.color = color;
    }
    public String getColorPet(){
        return color;
    }

    public void setHealth(int health){
        this.health = health;
    }
    public int getHealth(){
        return health;
    }
}