package pbo25.week_1;

import java.util.Scanner;

public class nomorSatu {
    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+"); 
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0))) 
                      .append(word.substring(1).toLowerCase()) 
                      .append(" ");
            }
        }
        return result.toString().trim(); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Judul Film: ");
        String input = scanner.nextLine();
        System.out.println(capitalizeWords(input));
        scanner.close();
    }
}
