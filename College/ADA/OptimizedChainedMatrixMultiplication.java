import java.util.Scanner;

public class OptimizedChainedMatrixMultiplication {
    public static int minMul(int[] d, int[][] P) {
        int n = d.length - 1;
        int[][] M = new int[n][];
        for (int i = 0; i < n; i++) {
            M[i] = new int[n - i];
        }

        // Initialize diagonal elements to 0
        for (int i = 0; i < n; i++) {
            M[i][0] = 0;
        }

        // Fill the matrix
        for (int diagonal = 1; diagonal < n; diagonal++) {
            for (int i = 0; i < n - diagonal; i++) {
                int j = i + diagonal;
                M[i][j - i] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = M[i][k - i] + M[k + 1][j - k - 1] + d[i] * d[k + 1] * d[j + 1];
                    if (cost < M[i][j - i]) {
                        M[i][j - i] = cost;
                        P[i][j] = k;
                    }
                }
            }
        }

        return M[0][n - 1];
    }

    public static void printOptimalParenthesization(int[][] P, int i, int j) {
        if (i == j) {
            System.out.print("A" + (i + 1));
        } else {
            System.out.print("(");
            printOptimalParenthesization(P, i, P[i][j]);
            printOptimalParenthesization(P, P[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of matrices: ");
        int numMatrices = scanner.nextInt();

        int[] dimensions = new int[numMatrices + 1];
        System.out.println("Enter the dimensions of the matrices:");
        for (int i = 0; i <= numMatrices; i++) {
            System.out.print("d" + i + ": ");
            dimensions[i] = scanner.nextInt();
        }

        int n = dimensions.length - 1;
        int[][] P = new int[n][n];

        int result = minMul(dimensions, P);
        System.out.println("Minimum number of multiplications: " + result);

        System.out.print("Optimal parenthesization: ");
        printOptimalParenthesization(P, 0, n - 1);
        System.out.println();

        scanner.close();
    }
}