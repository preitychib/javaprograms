package AssignmentADA.help;
import java.util.Scanner;

public class Q9LCS {

    // Method 1: Divide and Conquer Only
    public static int lcsDivideAndConquer(String X, String Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X.charAt(m - 1) == Y.charAt(n - 1))
            return 1 + lcsDivideAndConquer(X, Y, m - 1, n - 1);
        else
            return Math.max(lcsDivideAndConquer(X, Y, m - 1, n), lcsDivideAndConquer(X, Y, m, n - 1));
    }

    // Method 2: Dynamic Programming Algorithm (Using C and B arrays)
    public static void lcsDynamicProgramming(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] C = new int[m + 1][n + 1];
        char[][] B = new char[m + 1][n + 1];

        // Initialize first row and column to 0
        for (int i = 0; i <= m; i++)
            C[i][0] = 0;
        for (int j = 0; j <= n; j++)
            C[0][j] = 0;

        // Build C and B arrays according to the provided algorithm
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                    B[i][j] = '↖'; // Diagonal arrow
                } else if (C[i - 1][j] >= C[i][j - 1]) {
                    C[i][j] = C[i - 1][j];
                    B[i][j] = '↑'; // Up arrow
                } else {
                    C[i][j] = C[i][j - 1];
                    B[i][j] = '←'; // Left arrow
                }
            }
        }

        System.out.println("\nDynamic Programming Algorithm:");
        System.out.println("Length of LCS is " + C[m][n]);

        System.out.print("LCS using B matrix (Print_LCS): ");
        printLCS(B, X, m, n);

        System.out.print("\nLCS without using B matrix (Print_LCS1): ");
        printLCS1(C, X, Y, m, n);
        System.out.println();
    }

    // Method 3: Dynamic Programming with 2 1D Arrays
    public static void lcsDynamicProgrammingOptimized(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int[] previous = new int[n + 1];
        int[] current = new int[n + 1];

        // Build the current and previous arrays
        for (int i = 1; i <= m; i++) {
            // Swap current and previous for next iteration
            int[] temp = previous;
            previous = current;
            current = temp;

            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    current[j] = previous[j - 1] + 1;
                else
                    current[j] = Math.max(previous[j], current[j - 1]);
            }
        }

        System.out.println("\nDynamic Programming with 2 1D Arrays:");
        System.out.println("Length of LCS is " + current[n]);
    }

    // Print_LCS(b[][], X, i, j)
    public static void printLCS(char[][] B, String X, int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (B[i][j] == '↖') {
            printLCS(B, X, i - 1, j - 1);
            System.out.print(X.charAt(i - 1));
        } else if (B[i][j] == '↑') {
            printLCS(B, X, i - 1, j);
        } else {
            printLCS(B, X, i, j - 1);
        }
    }

    // Print_LCS1(c[][], X, Y, i, j)
    public static void printLCS1(int[][] C, String X, String Y, int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            printLCS1(C, X, Y, i - 1, j - 1);
            System.out.print(X.charAt(i - 1));
        } else if (C[i - 1][j] >= C[i][j - 1]) {
            printLCS1(C, X, Y, i - 1, j);
        } else {
            printLCS1(C, X, Y, i, j - 1);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first sequence (X): ");
        String X = scanner.nextLine();

        System.out.print("Enter second sequence (Y): ");
        String Y = scanner.nextLine();

        int m = X.length();
        int n = Y.length();

        // Method 1: Divide and Conquer Only
        int lcsLengthDivideAndConquer = lcsDivideAndConquer(X, Y, m, n);
        System.out.println("\nDivide and Conquer Only:");
        System.out.println("Length of LCS is " + lcsLengthDivideAndConquer);

        // Method 2: Dynamic Programming Algorithm
        lcsDynamicProgramming(X, Y);

        // Method 3: Dynamic Programming with 2 1D Arrays
        lcsDynamicProgrammingOptimized(X, Y);

        scanner.close();
    }
}