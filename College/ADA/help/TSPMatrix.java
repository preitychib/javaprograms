import java.util.Scanner;


public class TSPMatrix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // input number of cities (vertices)
        System.out.print("Enter the number of cities:");
        int n = sc.nextInt();

        // Declare the weight matrix
        int[][] weightMatrix = new int[n][n];

        // Input the matrix values
        System.out.println("Enter the weight matrix(use 0 if no path between cities):");

        for(int i =0;i<n;i++){

            for(int j=0;j<n;j++){

                System.out.print("Cost from city " + (i+1)+ " to city " + (j+1) + ": ");

                weightMatrix[i][j] = sc.nextInt();
            }
        }
        // Display the weight matrix 

        System.out.println("\nWeight Matrix:");
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                System.out.print(weightMatrix[i][j] + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}