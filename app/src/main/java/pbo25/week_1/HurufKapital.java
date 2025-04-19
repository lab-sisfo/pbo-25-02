import java.util.Scanner;

public class HurufKapital{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan judul: ");
        String input = scanner.nextLine();

        String hasil = hurufKapitalAwalKata(input);
        System.out.println(hasil);

        scanner.close();
    }

    public static String hurufKapitalAwalKata(String str){
        String[] kata = str.split(" ");
        String hasilString = "";

        for (String word : kata) {
            if (word.length() > 0) {
                hasilString += Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase() + " ";
            } else {
                System.out.print("Tidak ada judul yang dimasukkan. Coba lagi!");
            }
        }

        return hasilString.trim();
    }
}