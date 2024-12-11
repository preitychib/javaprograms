/*
* Write an efficient program to print truth table of n boolean variables.
*/

package AssignmentADA.help;
import java.util.Scanner;

public class Q7TruthTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of boolean variables: ");
        int n = sc.nextInt();
        sc.close();
        
        generateTruthTable(n);
    }
    
    public static void generateTruthTable(int n) {
        // Initialize boolean array (adding 1 to make array 1-based)
        boolean[] a = new boolean[n + 1];
        
        // Initialize all values to false
        for (int i = 1; i <= n; i++) {
            a[i] = false;
        }
        
        // Generate 2^n combinations
        int totalRows = (int) Math.pow(2, n);
        for (int i = 0; i < totalRows; i++) {
            int m = i;
            int j = n;
            
            // Convert decimal to binary representation
            while (m != 0) {
                if (m % 2 == 0) {
                    a[j] = false;
                } else {
                    a[j] = true;
                }
                m = (int) Math.floor(m / 2);
                j = j - 1;
            }
            
            // Fill remaining positions with false
            while (j > 0) {
                a[j] = false;
                j--;
            }
            
            // Print current combination
            for (int k = 1; k <= n; k++) {
                System.out.print(a[k] ? "T " : "F ");
            }
            System.out.println();
        }
    }
}