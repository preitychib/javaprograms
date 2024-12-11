import java.util.Scanner;

public class TruthTable {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n;
        System.out.print("Enter the value of n: ");
        n=sc.nextInt();
        System.out.println("The truth table: ");


        int rows = (int) Math.pow(2, n);

        // Print header
        System.out.println("\nTruth Table for " + n + " variables:");
        for (int i = 1; i <= n; i++) {
            System.out.print("Var" + i + "\t");
        }
        System.out.println();

        // Generate and print truth table
        for (int i = 0; i < rows; i++) {
            for (int j = n - 1; j >= 0; j--) {
                System.out.print(((i >> j) & 1) + "\t");
            }
            System.out.println();
        }
    }
}
