public class ChainedMatrixMultiplication {
    public static int minMul(int[] d, int[][] P, int n) {
        int[][] M = new int[n][n];

        // Initialize diagonal elements to 0
        for (int i = 1; i < n; i++) {
            M[i][i] = 0;
        }

        // Fill the matrix
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                M[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = M[i][k] + M[k+1][j] + d[i-1] * d[k] * d[j];
                    if (cost < M[i][j]) {
                        M[i][j] = cost;
                        P[i][j] = k;
                    }
                }
            }
        }

        return M[1][n-1];
    }

    public static void printOptimalParenthesization(int[][] P, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimalParenthesization(P, i, P[i][j]);
            printOptimalParenthesization(P, P[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        int[] dimensions = {5,2,3,4,6};
        int n = dimensions.length;
        int[][] P = new int[n][n];

        int result = minMul(dimensions, P, n);
        System.out.println("Minimum number of multiplications: " + result);

        System.out.print("Optimal parenthesization: ");
        printOptimalParenthesization(P, 1, n - 1);
        System.out.println();
    }
}