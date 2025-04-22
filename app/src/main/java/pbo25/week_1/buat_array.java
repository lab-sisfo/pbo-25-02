package pbo25.week_1;
import java.util.Scanner;

public class buat_array {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int [][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };
        try{
            System.out.print("Find number u want: ");
            int target = x.nextInt();
            String result = findArray(nums, target);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        x.close();
    }
    public static String findArray (int[][] nums, int target){
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums [i].length; j++){
                if (nums[i][j] == target){
                    return "Found " + target + " at["+ i +"]["+ j+"]";
                }
            }
        }
        return "number " + target + " isn't found in array. ";
    }
}