//* WAP in java to create a ragged array like staircase. 
//* Populate it with random values and print array on screen */

import java.util.Random;
import java.util.Scanner;

public class RaggedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows in the ragged array");
        int row = sc.nextInt();

        //? Initaialise ragged array 
        int[][] ragggedArray = new int[row][];
        Random random = new Random();
        
        //? Random value population
        for (int i = 0; i < row; i++) {
            //? memory allocation
            ragggedArray[i] = new int[i + 1];
            for (int j = 0; j < i +1; j++)
                ragggedArray[i][j] = random.nextInt(i + 1);
        }
        
        System.out.println("The staircase ragged arrays is:");
        for (int[] element : ragggedArray){
            for (int e :element)
                System.out.print(e);
            System.out.println();
        }
        sc.close();
    }
}