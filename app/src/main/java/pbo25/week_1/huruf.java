import java.util.Scanner;
public class huruf{
    public static void main(String[]args){
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan judul film: ");
        String input = x.nextLine();
        String output = capitalizeEachWordSimple(input);
        System.out.println(output);
    x.close();
    }
    public static String capitalizeEachWordSimple (String sentence) {
        String[] words = sentence.split(" ");
        String result = "";

        for (String word : words){
            if (word.length() > 0) { //array
                String capitalizeWord = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
                result += capitalizeWord + " ";
            }
        }
        return result;
    }
}