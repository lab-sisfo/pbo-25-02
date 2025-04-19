public class Main {
    public static void main(String[] args) {
        PetShop pet1 = new PetShop("Kitty", "Kucing", "Putih", 50, "Gatri", "Mengkendek", "08123453922");
        PetShop pet2 = new PetShop("Doggy", "Anjing", "Coklat", 10, "Ria");

        pet1.checkPet();
        pet1.petGrooming();
        pet1.petEatDrinks();
        pet1.petWash();
        pet1.checkPet();

        pet2.checkPet();
        pet2.petGrooming();
        pet2.petWash();
        pet2.petEatDrinks();
        pet2.checkPet();

        pet1.playwith(pet2);
        pet1.checkPet();
        pet2.checkPet();

        pet1.attack(pet2);
        pet1.checkPet();
        pet2.checkPet();
    }
}
