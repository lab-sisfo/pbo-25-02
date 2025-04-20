public class Main {
    public static void main(String[] args) {
        Ramuan ramuanHarry = new Ramuan("Felix Felicis", 50);
        Ramuan ramuanDraco = new Ramuan("Ramuan Kegelapan", 20);

        Penyihir harry = new Penyihir("Harry Potter", "Griffindor", 100, 30, ramuanHarry);
        Penyihir draco = new Penyihir("Draco Malfoy", "Slytherin", 100, 25, ramuanDraco);
        Musuh dementor = new Musuh("Dementor", 80);

        harry.tampilkanStatus();
        draco.tampilkanStatus();
        dementor.tampilkanStatus();

        harry.serang(dementor);
        draco.serang(dementor);

        harry.duel(draco);

        harry.gunakanRamuanFavorit();

        harry.tampilkanStatus();
        draco.tampilkanStatus();
        dementor.tampilkanStatus();
    }
}