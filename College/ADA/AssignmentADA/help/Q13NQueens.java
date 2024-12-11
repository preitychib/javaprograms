package AssignmentADA.help;

import java.util.Scanner;

public class Q13NQueens {
    private static int[] col; // Array to store the column position of each queen
    private static int n;     // Size of the chessboard (n x n)
    private static int totalSolutions; // Counter for total number of solutions

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the chessboard (n x n): ");
        n = sc.nextInt();
        col = new int[n + 1]; // Initialize the column array (index 0 is not used)
        totalSolutions = 0;   // Initialize the solution counter
        queens(0); // Start the backtracking algorithm from row 0
        System.out.println("Total solutions: " + totalSolutions);
        sc.close();
    }

    /**
     * Recursive method to place queens on the board.
     * @param i The current row being considered (0-based index)
     */
    private static void queens(int i) {
        if (isPromising(i)) {
            if (i == n) {
                // If all queens are placed successfully, print the solution
                printSolution();
                totalSolutions++;
            } else {
                // Try placing the next queen in each column of the next row
                for (int j = 1; j <= n; j++) {
                    col[i + 1] = j; // Place queen in column j
                    queens(i + 1);  // Recurse for the next row
                }
            }
        }
    }

    /**
     * Checks if placing a queen in the current position is promising.
     * @param i The current row being checked (0-based index)
     * @return true if the placement is promising, false otherwise
     */
    private static boolean isPromising(int i) {
        int k = 1;
        boolean promising = true;

        while (k < i && promising) {
            // Check if the current queen conflicts with any previously placed queen
            if (col[i] == col[k] || Math.abs(col[i] - col[k]) == i - k) {
                promising = false;
            }
            k = k + 1;
        }
        return promising;
    }

    /**
     * Prints the current solution (positions of all queens).
     */
    private static void printSolution() {
        System.out.print("Solution: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(col[i] + " ");
        }
        System.out.println();
    }
}
